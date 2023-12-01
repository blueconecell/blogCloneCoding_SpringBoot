import { ChangeEvent, forwardRef,KeyboardEvent } from "react";
import './style.css'

// interface: Input box 컴포넌트 Propperties
interface Props{
    label:string;
    type:'text' | 'password';
    placeholder: string;
    error:boolean;
    value:string;
    onChange: (event: ChangeEvent<HTMLInputElement>) => void;
    icon?: 'eye-light-off-icon'|'eye-light-on-icon'|'expand-right-light-icon';//필수아닐때 물음표씀
    onButtonClick?: ()=> void;
    message?:string;
    onKeyDown?:(event:KeyboardEvent<HTMLInputElement>)=>void;
}

const InputBox = forwardRef<HTMLInputElement, Props>((props: Props, ref)=>{

    // state //
    const {label,type,error,placeholder,value,icon,message}= props;
    const {onChange,onButtonClick,onKeyDown} = props;

    // event handler : input 키 이벤트 처리 함수 //

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
                <input ref={ref} type={type} className="input" placeholder={placeholder} value={value} onChange={onChange} onKeyDown={onKeyDownHandler}/> 
                {onButtonClick !== undefined && 
                <div className="icon-button" onClick={onButtonClick}>
                    {icon !== undefined && <div className={`icon ${icon}`}></div>}
                </div>
                }
            </div>
            {message !== undefined && <div className="inputbox-message">{message}</div>}
            
        </div>
    )
});
export default InputBox;