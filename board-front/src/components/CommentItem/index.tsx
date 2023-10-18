import React from 'react'
import defaultProfileImage from 'assets/image/default-profile-image.png'
import './style.css'
import { CommentListItem } from 'types/interface'

interface Props{
    commentListItem: CommentListItem;
}

// component: Comment List Item component
export default function CommentItem({commentListItem}:Props) {

    // properties
    const {nickname, profileImage, writeDateTime, content} = commentListItem;

    // render: Comment List Item rendering
  return (
    <div className='comment-list-item'>
        <div className='comment-list-item-top'>
            <div className='comment-list-item-profile-box'>
                <div className='comment-list-item-profile-image' style={{backgroundImage: `url(${profileImage ? profileImage : defaultProfileImage})`}}></div>
            </div>
            <div className='comment-list-item-nickname'>{nickname}</div>
            <div className='comment-list-item-divider'>{'\|'}</div>
            <div className='comment-list-item-time'>{writeDateTime}</div>
        </div>
        <div className='comment-list-item-main'>
            <div className='comment-list-item-content'>{content}</div>
        </div>
    </div>
  )
}
