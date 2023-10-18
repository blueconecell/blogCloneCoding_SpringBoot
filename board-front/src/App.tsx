import React from 'react';
import './App.css';
import BoardItem from 'components/BoardItem';
import { commentListMock, favoriteListMock, latestBoardListMock } from 'mocks';
import Top3Item from 'components/Top3Item';
import top3BoardListMock from 'mocks/top-3-board-list.mock';
import CommentItem from 'components/CommentItem';
import FavoriteItem from 'components/FavoriteItem';

function App() {
  return (
    <>
    <div style={{padding:'0 20px', display: 'flex', flexDirection:'column',columnGap:'30px',rowGap:'20px'}}>
      {favoriteListMock.map(favoriteListItem => <FavoriteItem favoriteListItem={favoriteListItem}/>)}
    </div>
    </>
  );
}

export default App;
