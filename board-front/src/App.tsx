import React from 'react';
import './App.css';
import BoardItem from 'components/BoardItem';
import { commentListMock, favoriteListMock, latestBoardListMock } from 'mocks';
import Top3Item from 'components/Top3Item';
import top3BoardListMock from 'mocks/top-3-board-list.mock';
import CommentItem from 'components/CommentItem';
import FavoriteItem from 'components/FavoriteItem';
import InputBox from 'components/InputBox';

function App() {
  return (
    <>
      <InputBox/>
    </>
  );
}

export default App;
