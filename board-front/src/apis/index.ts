import axios from "axios";
import { SignInRequestDto, SignUpRequestDto } from "./request/auth";
import { SignInResponseDto, SignUpResponseDto } from "./response/auth";
import { ResponseDto } from "./response";
import { GetSignInUserResponseDto } from "./response/user";

const DOMAIN = 'http://localhost:4000';

const API_DOMAIN = `${DOMAIN}/api/v1`
// 인증정보 쉽게 사용하기 위해 함수로 만들어두기
const authorization = (accessToken: string) => {
    return {headers: { Authorization: `Bearer ${accessToken}`}}
};

const SIGN_IN_URL = () => `${API_DOMAIN}/auth/sign-in`
const SIGN_UP_URL = () => `${API_DOMAIN}/auth/sign-up`

// async 동기함수로 처리하기 
export const signInRequest = async (requestBody: SignInRequestDto) => {
    // sign-in 작업 post 요청을 할 것이다. 
    // 첫번째 위치 : 어떤 url에 보낼 것인지.
    // request body : 무엇을 보낼 것인지
    const result = await axios.post(SIGN_IN_URL(), requestBody)
        .then(response => {
            // post 요청의 결과를 response에 받아서 처리할 것이다.
            const responseBody: SignInResponseDto = response.data;
            return responseBody;
        })
        .catch(error => {
            if(!error.response) return null;
            const responseBody: ResponseDto = error.response.data;
            return responseBody;
        })
    return result;
}
export const signUpRequest = async (requestBody: SignUpRequestDto) =>{
    const result = await axios.post(SIGN_UP_URL(), requestBody)
        .then(response => {
            const responseBody: SignUpResponseDto = response.data;
            return responseBody;
        })
        .catch(error => {
            if(!error.response.data) return null;
            const responseBody: ResponseDto = error.response.data;
            return responseBody;
        });
    return result;
}
const GET_SIGN_IN_USER_URL = () => `${API_DOMAIN}/user`;

export const getSignInUserRequest = async (accessToken: string) =>{
    // GET 요청 axios로 받기
    // 인증정보를 authorization이랑 같이 보내야함
    const result = await axios.get(GET_SIGN_IN_USER_URL(), authorization(accessToken))
    .then(response => {
        const responseBody: GetSignInUserResponseDto = response.data;
        return responseBody;
    })
    .catch(error => {
        if (!error.response) return null;
        const responseBody: ResponseDto = error.response.data;
        return responseBody;
    });
    return result;
}