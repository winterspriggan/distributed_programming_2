export const HOST = 'http://localhost:'
export const GATEWAY_PORT = 40005;
export const SERVICE_NAME = '/customer-service'
export const ENDPOINT_GET_LOGIN = HOST + GATEWAY_PORT + SERVICE_NAME + '/customer/login'
export const ENDPOINT_GET_CONTRACTS = HOST + GATEWAY_PORT + SERVICE_NAME + '/contract/get_all_by_customer_id';
export const ENDPOINT_POST_CLAIM = HOST + GATEWAY_PORT + SERVICE_NAME + '/claim/create';
export const ENDPOINT_GET_PRODUCTS = HOST + GATEWAY_PORT + SERVICE_NAME + '/product/get_all';
export const ENDPOINT_POST_CONTRACT = HOST + GATEWAY_PORT + SERVICE_NAME + '/contract/create';
export const ENDPOINT_GET_BOARDS = HOST + GATEWAY_PORT + SERVICE_NAME + '/board/get_all';
export const ENDPOINT_POST_BOARD = HOST + GATEWAY_PORT + SERVICE_NAME + '/board/create';

// export const ENDPOINT_GET_LOGIN = 'http://localhost:40021/our_insurance/customer/login';
// export const ENDPOINT_GET_CONTRACTS = 'http://localhost:40021/our_insurance/contracts';
// export const ENDPOINT_POST_CLAIM = 'http://localhost:40021/our_insurance/claim'
// export const ENDPOINT_GET_PRODUCTS = 'http://localhost:40021/our_insurance/products';
// export const ENDPOINT_POST_CONTRACT = 'http://localhost:40021/our_insurance/contract';
// export const ENDPOINT_GET_BOARDS = 'http://localhost:40021/our_insurance/boards'
// export const ENDPOINT_POST_BOARD = 'http://localhost:40021/our_insurance/board';