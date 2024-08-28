package com.project.project.constants;

public class MessageConstants {

    // Exceptions
    public static final String BAD_REQUEST_ERROR = "A requisição falhou.";
    public static final String UNAUTHORIZED_ERROR = "Não autorizado: Verifique suas credenciais.";
    public static final String FORBIDDEN_ERROR = "Acesso não autorizado.";
    public static final String NOT_FOUND_ERROR = "Recurso não encontrado.";
    public static final String INTERNAL_SERVER_ERROR = "Ocorreu um erro interno no servidor.";
    public static final String INVALID_ARGUMENT_ERROR = "Valor inválido fornecido.";
    public static final String NULL_POINTER_ERROR = "Valor nulo encontrado.";
    public static final String CONFLICT_ERROR = "Conflito com as informações fornecidas.";
    public static final String UNPROCESSABLE_ENTITY_ERROR = "Não foi possível processar os dados.";
    public static final String CONSTRAINT_VIOLATION_ERROR = "Violação de restrição: Verifique os dados fornecidos.";
    public static final String ILLEGAL_ARGUMENT_ERROR = "Argumento inválido ou não aceito.";
    public static final String DATA_INTEGRITY_ERROR = "Erro de integridade de dados: Verifique os dados.";
    public static final String PROPERTY_VALUE_ERROR = "Propriedade obrigatória não fornecida.";
    public static final String ENTITY_NOT_FOUND_ERROR = "Entidade não encontrada.";
    public static final String OPTIMISTIC_LOCK_ERROR = "Erro de bloqueio otimista.";
    public static final String TRANSACTION_REQUIRED_ERROR = "Transação é necessária.";
    public static final String LAZY_INITIALIZATION_ERROR = "Erro de inicialização tardia.";
    public static final String ENTITY_EXISTS_ERROR = "Entidade já existe.";
    public static final String DATA_INTEGRITY_VIOLATION_ERROR = "Violação de integridade dos dados.";
    public static final String DATA_ERROR = "Erro de dados.";
    public static final String NO_RESULT_ERROR = "Nenhum resultado encontrado.";
    public static final String MAX_UPLOAD_SIZE_EXCEEDED_ERROR = "Tamanho máximo de upload excedido.";
    public static final String NO_HANDLER_FOUND_ERROR = "Nenhum manipulador encontrado para a requisição.";
    public static final String METHOD_NOT_SUPPORTED_ERROR = "Método de requisição não suportado.";
    public static final String ACCESS_DENIED_ERROR = "Acesso negado.";
    public static final String ILLEGAL_STATE_ERROR = "Estado ilegal.";

    // General Error Messages
    public static final String ERROR_GETTING_IP_ADDRESS = "Erro ao obter o endereço IP.";
    public static final String RATE_LIMIT_EXCEEDED = "Limite de requisições excedido.";
    public static final String BLOCKED_IP = "IP bloqueado, não é possível realizar essa requisição.";
    public static final String ERROR_TOKEN_CREATION = "Erro ao criar o token.";

    // Authentication & User Messages
    public static final String PASSWORD_ERROR = "Senha incorreta.";
    public static final String INVALID_USER = "Usuário não encontrado.";
    public static final String INVALID_CAPTCHA = "Captcha inválido ou expirado. Atualize a página e tente novamente.";
    public static final String USER_NOT_FOUND = "Usuário não encontrado.";
    public static final String SEND_OTP = "Código OTP enviado para o número de celular registrado.";
    public static final String INVALID_OTP = "Código OTP inválido.";
    public static final String OTP_SUCCESS = "Código OTP aprovado.";
    public static final String INVALID_TOKEN = "Token inválido.";
    public static final String USER_ALREADY_EXISTS = "Usuário já cadastrado.";
    public static final String INVALID_AUTHORIZATION_HEADER = "Cabeçalho de autorização inválido.";
    public static final String PASSWORD_UPDATE_SUCCESS = "Senha atualizada com sucesso.";
    public static final String LOGIN_ERROR = "Erro ao tentar fazer login.";
    public static final String INVALID_CREDENTIALS = "Credenciais inválidas.";
    public static final String REGISTER_ERROR = "Erro ao tentar registrar.";
    public static final String OTP_VERIFY_ERROR = "Erro na verificação do código OTP.";
    public static final String FORGOT_PASSWORD_ERROR = "Erro no processo de recuperação de senha.";
    public static final String RESET_PASSWORD_ERROR = "Erro ao redefinir a senha.";

    // User
    public static final String USERS_FETCH_ERROR = "Erro ao buscar os usuários.";
    public static final String USERS_NOT_FOUND = "Usuário não encontrado.";
    public static final String USER_FETCH_ERROR = "Erro ao buscar o usuário.";
    public static final String USER_UPDATE_ERROR = "Erro ao atualizar o usuário.";
    public static final String UPDATE_PASSWORD_ERROR = "Erro ao atualizar a senha.";
    public static final String UPDATE_PASSWORD_SUCCESS = "Senha atualizada com sucesso.";

    // Rate Limiting
    public static final String TO_MANY_REQUEST = "Muitas requisições do mesmo cliente - IPv6: ";

    // Item Messages
    public static final String ITEM_OR_USER_ID_MISSING = "ID do item ou do usuário ausente.";
    public static final String ITEM_SUCCESS = "Item registrado com sucesso.";
    public static final String ITEM_ERROR = "Erro ao registrar o item.";
    public static final String ITEM_FETCH_ERROR = "Erro ao buscar o item.";
    public static final String ITEMS_FETCH_ERROR = "Erro ao buscar os itens.";
    public static final String ITEM_NOT_FOUND = "Item não encontrado.";
    public static final String ITEMS_NOT_FOUND = "Itens não encontrados.";
    public static final String NO_ITEMS_FOUND_FOR_USER = "Nenhum item encontrado para o usuário com ID: %s";
    public static final String ITEM_NAME_OR_CATEGORY_ID_MISSING = "Nome ou ID da categoria do item ausente.";
    public static final String ITEM_CREATE_ERROR = "Erro ao criar o item.";
    public static final String ITEM_UPDATE_ERROR = "Erro ao atualizar o item.";
    public static final String ITEM_DELETE_ERROR = "Erro ao excluir o item.";
    public static final String ITEM_NOT_FOUND_BY_ID = "Item não encontrado para o ID: ";
    public static final String ITEM_DELETE_SUCCESS = "Item excluído com sucesso.";

    // Category Messages
    public static final String CATEGORY_SUCCESS = "Categoria registrada com sucesso.";
    public static final String CATEGORY_NAME_OR_TYPE_MISSING = "Nome ou tipo da categoria ausente.";
    public static final String CATEGORY_FETCH_ERROR = "Erro ao buscar a categoria.";
    public static final String CATEGORIES_FETCH_ERROR = "Erro ao buscar as categorias.";
    public static final String CATEGORY_CREATE_ERROR = "Erro ao criar a categoria.";
    public static final String CATEGORY_UPDATE_ERROR = "Erro ao atualizar a categoria.";
    public static final String CATEGORY_DELETE_ERROR = "Erro ao excluir a categoria.";
    public static final String CATEGORY_NOT_FOUND = "Categoria não encontrada.";
    public static final String CATEGORIES_NOT_FOUND = "Categorias não encontradas.";
    public static final String CATEGORY_NOT_FOUND_BY_ID = "Categoria não encontrada para o ID: ";
    public static final String CATEGORY_DELETE_SUCCESS = "Categoria excluída com sucesso.";
    public static final String CATEGORY_ALREADY_EXISTS = "Categoria já existe.";

    // Category Messages
    public static final String CATEGORY_DRINK_SUCCESS = "Categoria registrada com sucesso.";
    public static final String CATEGORY_DRINK_NAME_OR_TYPE_MISSING = "Nome ou tipo da categoria ausente.";
    public static final String CATEGORY_DRINK_FETCH_ERROR = "Erro ao buscar a categoria.";
    public static final String CATEGORIES_DRINK_FETCH_ERROR = "Erro ao buscar as categorias.";
    public static final String CATEGORY_DRINK_CREATE_ERROR = "Erro ao criar a categoria.";
    public static final String CATEGORY_DRINK_UPDATE_ERROR = "Erro ao atualizar a categoria.";
    public static final String CATEGORY_DRINK_DELETE_ERROR = "Erro ao excluir a categoria.";
    public static final String CATEGORY_DRINK_NOT_FOUND = "Categoria não encontrada.";
    public static final String CATEGORIES_DRINK_NOT_FOUND = "Categorias não encontradas.";
    public static final String CATEGORY_DRINK_NOT_FOUND_BY_ID = "Categoria não encontrada para o ID: ";
    public static final String CATEGORY_DRINK_DELETE_SUCCESS = "Categoria excluída com sucesso.";
    public static final String CATEGORY_DRINK_ALREADY_EXISTS = "Categoria já existe.";

    // Flavor Controller Messages
    public static final String FLAVOR_FETCH_ERROR = "Erro ao buscar o sabor.";
    public static final String FLAVORS_FETCH_ERROR = "Erro ao buscar os sabores.";
    public static final String FLAVOR_CREATE_ERROR = "Erro ao criar o sabor.";
    public static final String FLAVOR_UPDATE_ERROR = "Erro ao atualizar o sabor.";
    public static final String FLAVOR_DELETE_ERROR = "Erro ao excluir o sabor.";
    public static final String FLAVOR_NOT_FOUND = "Sabor não encontrado.";
    public static final String FLAVORS_NOT_FOUND = "Sabores não encontrados.";
    public static final String FLAVOR_NOT_FOUND_BY_ID = "Sabor não encontrado para o ID: ";
    public static final String FLAVOR_DELETE_SUCCESS = "Sabor excluído com sucesso.";
    public static final String FLAVOR_SIZE_LINK_NOT_FOUND = "Tamanho para o sabor não encontrado.";

    // Item Option Controller Messages
    public static final String ITEM_OPTION_FETCH_ERROR = "Erro ao buscar as opções de item.";
    public static final String ITEM_OPTION_CREATE_ERROR = "Erro ao criar a opção de item.";
    public static final String ITEM_OPTION_UPDATE_ERROR = "Erro ao atualizar a opção de item.";
    public static final String ITEM_OPTION_DELETE_ERROR = "Erro ao excluir a opção de item.";
    public static final String ITEM_OPTION_NOT_FOUND = "Opção de item não encontrada.";
    public static final String ITEM_OPTIONS_NOT_FOUND = "Opções de item não encontradas.";
    public static final String ITEM_OPTION_NOT_FOUND_BY_ID = "Opção de item não encontrada para o ID: ";
    public static final String ITEM_OPTION_DELETE_SUCCESS = "Opção de item excluída com sucesso.";
    public static final String OPTION_NOT_FOUND_BY_ID = "Opção não encontrada para o ID: ";

    // Item Type Controller Messages
    public static final String ITEM_TYPE_FETCH_ERROR = "Erro ao buscar o tipo de item.";
    public static final String ITEM_TYPES_FETCH_ERROR = "Erro ao buscar os tipos de item.";
    public static final String ITEM_TYPE_CREATE_ERROR = "Erro ao criar o tipo de item.";
    public static final String ITEM_TYPE_UPDATE_ERROR = "Erro ao atualizar o tipo de item.";
    public static final String ITEM_TYPE_DELETE_ERROR = "Erro ao excluir o tipo de item.";
    public static final String ITEM_TYPE_NOT_FOUND = "Tipo de item não encontrado.";
    public static final String ITEM_TYPE_NOT_FOUND_BY_ID = "Tipo de item não encontrado para o ID: ";
    public static final String ITEM_TYPE_DELETE_SUCCESS = "Tipo de item excluído com sucesso.";

    // Size Controller Messages
    public static final String SIZE_CREATE_ERROR = "Erro ao criar o tamanho.";
    public static final String SIZE_UPDATE_ERROR = "Erro ao atualizar o tamanho.";
    public static final String SIZE_FETCH_ERROR = "Erro ao buscar o tamanho.";
    public static final String SIZES_FETCH_ERROR = "Erro ao buscar os tamanhos.";
    public static final String SIZE_DELETE_ERROR = "Erro ao excluir o tamanho.";
    public static final String SIZE_DELETE_SUCCESS = "Tamanho excluído com sucesso.";
    public static final String SIZE_NOT_FOUND_BY_ID = "Tamanho não encontrado para o ID: ";
    public static final String SIZE_NAME_OR_VALUE_MISSING = "Nome ou valor do tamanho ausente.";
    public static final String SIZE_NOT_FOUND = "Tamanho não encontrado.";
    public static final String SIZES_NOT_FOUND = "Tamanhos não encontrados.";

    // Order Messages
    public static final String ORDER_FETCH_ERROR = "Erro ao buscar o pedido.";
    public static final String ORDERS_FETCH_ERROR = "Erro ao buscar os pedidos.";
    public static final String ORDER_CREATE_ERROR = "Erro ao criar o pedido.";
    public static final String ORDER_UPDATE_ERROR = "Erro ao atualizar o pedido.";
    public static final String ORDER_DELETE_ERROR = "Erro ao excluir o pedido.";
    public static final String ORDER_NOT_FOUND = "Pedido não encontrado.";
    public static final String ORDER_NOT_FOUND_BY_ID = "Pedido não encontrado para o ID: ";
    public static final String ORDER_DELETE_SUCCESS = "Pedido excluído com sucesso.";
    public static final String ORDER_SUCCESS = "Pedido registrado com sucesso.";
    public static final String ORDER_ALREADY_EXISTS = "Pedido já registrado.";

    // Shipping Messages
    public static final String SHIPPING_FETCH_ERROR = "Erro ao buscar o frete.";
    public static final String SHIPPING_CREATE_ERROR = "Erro ao criar o frete.";
    public static final String SHIPPING_UPDATE_ERROR = "Erro ao atualizar o frete.";
    public static final String SHIPPING_DELETE_ERROR = "Erro ao excluir o frete.";
    public static final String SHIPPING_NOT_FOUND = "Frete não encontrado.";
    public static final String SHIPPING_NOT_FOUND_BY_ID = "Frete não encontrado para o ID: ";
    public static final String SHIPPING_DELETE_SUCCESS = "Frete excluído com sucesso.";
    public static final String SHIPPING_NAME_OR_COST_MISSING = "Nome ou custo do frete ausente.";

    // Payment Method
    public static final String PAYMENT_METHOD_DELETE_SUCCESS = "Erro ao excluir o método de pagamento.";
    public static final String PAYMENT_METHOD_NOT_FOUND_BY_ID = "Erro ao excluir o método de pagamento do ID: ";
    public static final String PAYMENT_METHOD_NOT_FOUND = "Método de pagamento não encontrado.";

    // Address
    public static final String ADDRESS_DELETE_SUCCESS = "Erro ao excluir o endereço.";
    public static final String ADDRESS_NOT_FOUND_BY_ID = "Erro ao excluir o endereço do ID: ";

    // General
    public static final String SERVER_ERROR = "Erro no servidor. Tente novamente mais tarde.";
    public static final String SUCCESS = "Operação realizada com sucesso.";
    public static final String UPDATE_SUCCESS = "Atualização realizada com sucesso.";

    // Images
    public static final String BASE64_DECODE_FAILED = "Erro ao decodificar Base64: ";
    public static final String DECODE_IMAGE_FAILED = "Falha ao decodificar a imagem: ";
    public static final String BASE64_CANNOT_NULL = "Imagem base64 não pode ser nulo ou vazio";
    public static final String IMAGE_NOT_FOUND_BY_ID = "Imagem não encontrada para o ID: ";

    // Schedule
    public static final String SCHEDULE_PERIOD_NOT_FOUND_BY_ID = "Periodo não encontrado para o ID: ";
    public static final String SCHEDULE_WEEKDAY_NOT_FOUND_BY_ID = "Dia da semana não encontrado para o ID: ";
    public static final String PERIOD_DELETED = "Periodo deletado com sucesso.";
    public static final String WEEKDAY_DELETED = "Dia da semana deletado com sucesso.";

}
