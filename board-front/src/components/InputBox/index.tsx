import { ChangeEvent, Dispatch, SetStateAction, forwardRef,KeyboardEvent } from "react";
import './style.css'
interface Props{
    label:string;
    type:'text' | 'password';
    placeholder: string;
    error:boolean;
    value:string;
    setValue:Dispatch<SetStateAction<string>>;
    icon?: 'eye-light-off-icon'|'eye-light-on-icon'|'expand-right-light-icon';//필수아닐때 물음표씀
    onButtonClick?: ()=> void;
    message?:string;
    onKeyDown?:(event:KeyboardEvent<HTMLInputElement>)=>void;
}

const InputBox = forwardRef<HTMLInputElement, Props>((props: Props, ref)=>{

    // state //
    const {label,type,error,placeholder,value,icon,message}=props;
    const {setValue,onButtonClick,onKeyDown} =props;

    // event handler : input 값 변경 이벤트 처리 함수 //
    const onChangeHandler = (event:ChangeEvent<HTMLInputElement>)=>{
        const {value} = event.target;
        setValue(value);
    }
    // 입력창에 엔터치면 다음 입력창이나 버튼으로 넘어가게 해주기
    const onKeyDownHandler = (event: KeyboardEvent<HTMLInputElement>)=>{
        if(!onKeyDown) return;
        onKeyDown(event);
    }

    // render //
    return (
        <div className="inputbox">
            <div className="inputbox-label">{label}</div>
            <div className={error ? "inputbox-container-error" : "inputbox-container" }>
                <input ref={ref} type={type} className="input" placeholder={placeholder} value={value} onChange={onChangeHandler} onKeyDown={onKeyDownHandler}/> 
                {onButtonClick !== undefined && 
                <div className="icon-button" onClick={onButtonClick}>
                    {icon !== undefined && <div className={`icon ${icon}`}></div>}
                    
                </div>
                }

            </div>
            {message !== undefined && <div className="inputbox-message">{'비밀번호는 8자 이상 입력해주세요.'}</div>}
            
        </div>
    )
});
export default InputBox;