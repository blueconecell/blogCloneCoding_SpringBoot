import { User } from "types/interface";
import { create } from "zustand";

interface LoginUserStore {
    loginUser: User | null;
    setLoginUser: (loginUser: User) => void;
    resetLoginUser: () => void;
};
// 전역적으로 사용하는 상태변수를 만드는 방법

const useLoginUserStore = create<LoginUserStore>(set => ({
    // 상태값 = 처음엔 null
    loginUser: null,
    // 상태를 변경해주는 set함수 - 로그인상태로 변경
    setLoginUser: (loginUser) => set(state =>({...state, loginUser})),
    // 상태를 변경해주는 set함수 - null로 초기화해줌
    resetLoginUser: () => set(state => ({...state, loginUser:null}))
}));

export default useLoginUserStore