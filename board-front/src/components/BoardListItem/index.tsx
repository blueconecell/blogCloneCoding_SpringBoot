import React from 'react'
import './style.css';

// component : Board list item
export default function BoardListItem() {
  // render : Board list item - component rendering
    return (
        <div className='board-list-item'>
            <div className='board-list-item-main-box'>
                <div className='board-list-item-top'>
                    <div className='board-list-item-profile-box'>
                        <div className='board-list-item-profile-image' style={{backgroundImage:`url(https://lh3.googleusercontent.com/a/ACg8ocLZBEdbzcSMZUfzYSB0-kRWBQaWvdcHUc5ErZafS4SykGw=s288-c-no)`}}></div>
                    </div>
                    <div className='board-list-item-write-box'>
                        <div className='board-list-item-nickname'>{'닉네임이 들어갑니다'}</div>
                        <div className='board-list-item-write-datetime'>{'작성날짜가 들어갑니다'}</div>
                    </div>
                </div>
            <div className='board-list-item-middle'>
                <div className='board-list-item-title'>{'게시물 제목이 들어갑니다'}</div>
                <div className='board-list-item-content'>{'게시물 내용이 들어갑니다'}</div>
            </div>
            <div className='board-list-item-bottom'>
                <div className='board-list-item-counts'>{`댓글 0 - 좋아요 0 - 조회수 0`}</div>
            </div>
        </div>
        <div className='board-list-item-image-box'>
            <div className='board-list-item-image' style={{backgroundImage:`url(https://lh3.googleusercontent.com/a/ACg8ocLZBEdbzcSMZUfzYSB0-kRWBQaWvdcHUc5ErZafS4SykGw=s288-c-no)`}}></div>
        </div>
    </div>
  )
}
