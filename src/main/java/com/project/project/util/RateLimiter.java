package com.project.project.util;

import com.project.project.constants.MessageConstants;
import com.project.project.constants.StringConstants;
import com.project.project.exception.RateLimitExceededException;
import com.project.project.service.system.RateLimiterBlacklistService;
import com.project.project.exception.IpAddressRetrievalException;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class RateLimiter {

    private final int maxRequests;
    private final long timeWindow;
    private final Map<String, UserRequestInfo> requestMap = new ConcurrentHashMap<>();
    
    private RateLimiterBlacklistService rateLimiterBlacklistService = new RateLimiterBlacklistService();

    public RateLimiter(int maxRequests, long timeWindow, RateLimiterBlacklistService rateLimiterBlacklistService) {
        this.rateLimiterBlacklistService = rateLimiterBlacklistService;
	this.maxRequests = maxRequests;
	this.timeWindow = timeWindow;
    }

    public ResponseEntity<Map<String, Object>> checkRateLimit(HttpServletRequest request) {
	
        String ipAddress = getRequestIpAddress(request);
        if(rateLimiterBlacklistService.isBlacklisted(ipAddress)) {
            return ResponseUtil.buildErrorResponse(HttpStatus.BAD_REQUEST,
                    MessageConstants.TO_MANY_REQUEST + StringConstants.IP + ipAddress, MessageConstants.RATE_LIMIT_EXCEEDED);
        }
        if (!isAllowed(ipAddress)) {
            return ResponseUtil.buildErrorResponse(HttpStatus.BAD_REQUEST,
                MessageConstants.TO_MANY_REQUEST + StringConstants.IP + ipAddress, MessageConstants.RATE_LIMIT_EXCEEDED);
        }
        
        return ResponseUtil.buildSuccessResponse(HttpStatus.OK, Map.of(StringConstants.STATUS, StringConstants.ALLOWED));
    }

    public boolean isAllowed(String ipAddress) throws RateLimitExceededException {
	try {
	    UserRequestInfo userRequestInfo = requestMap.computeIfAbsent(ipAddress, k -> new UserRequestInfo());

	    synchronized (userRequestInfo) {
		long currentTime = System.currentTimeMillis();
		userRequestInfo.requests.removeIf(timestamp -> currentTime - timestamp > timeWindow);

		if (userRequestInfo.requests.size() >= maxRequests) {
		    rateLimiterBlacklistService.addToBlacklist(ipAddress);
		    throw new RateLimitExceededException(MessageConstants.RATE_LIMIT_EXCEEDED);
		}

		userRequestInfo.requests.add(currentTime);
		return true;
	    }
	} catch (Exception e) {
	    throw new RateLimitExceededException(MessageConstants.RATE_LIMIT_EXCEEDED, e);
	}
    }

    public String getRequestIpAddress(HttpServletRequest request) throws IpAddressRetrievalException {
	try {
	    String ipAddress = request.getHeader("X-Forwarded-For");
	    if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
		ipAddress = request.getHeader("X-Real-IP");
	    }
	    if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
		ipAddress = request.getRemoteAddr();
	    }
	    if (ipAddress != null && ipAddress.contains(",")) {
		ipAddress = ipAddress.split(",")[0].trim();
	    }
	    return ipAddress;
	} catch (Exception e) {
	    throw new IpAddressRetrievalException(MessageConstants.ERROR_GETTING_IP_ADDRESS, e);
	}
    }

    public static class UserRequestInfo {
	private final List<Long> requests = new CopyOnWriteArrayList<>();
    }
}
