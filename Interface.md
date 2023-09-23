## signIn (로그인)
### <span style="background-color:#fff5b1"> request</span>
```
*email : string,
*password : string,
//앞에 *는 필수라는 뜻
```
### <span style="background-color:#DCFFE4"> response </span>
**성공**
Http Status - 200 (OK)
```
code : "SU", 
message : "Success.",
token : "jwt...", //TODO
expiredDate : 12345678,
```
**실패**
- 필수정보 미입력
- 로그인 실패
Http Status - 401 (Unauthorized)
```
code : "SF",
message : "Sign In Failed.",
//아이디가 틀렸는지 비번이 틀렸는지 알려주면 안됨
```
- 데이터베이스 에러
Http Status - 500 (internal Server Error)
```
code : "DE",
message : "Database Error,"
```
---
## signUp (회원가입)
### <span style="background-color:#fff5b1"> request</span>
```
*email : string,
*password : string,
*nickname : string,
*telNumber : string,
*address : string,
addressDetail : string,
```
### <span style="background-color:#DCFFE4"> response </span>
**성공**
Http Status - 200 (OK)
```
code : "SU", 
message : "Success.",
```

**실패**
- 필수정보 미입력 / 이메일 포멧 불일치 / 비밀번호 8자리 미만 / 전화번호 포멧 불일치 
- 이메일 중복
Http Status - 400 (Bad Request)
```
code : "EE",
message : "Existed Email",
```
- 데이터베이스 에러
Http Status - 500 (internal Server Error)
```
code : "DE",
message : "Database Error.",
```
---
## weeklyTop3List (주간 3위 게시물)

### <span style="background-color:#DCFFE4"> response </span>
**성공**
Http Status - 200 (OK)
```
code : "SU", 
message : "Success.",
top3List : boardListItem[],
```

boardListItem
```
boardNumber : int,
title : string,
content : string,
boardTitleImg : string,
favoriteCount : int,
commentCount : int,
viewCount : int,
writeDatetime : string,
writerNickName : string,
writerProfileImg : string,


```

**실패**
- 데이터베이스 에러
Http Status - 500 (internal Server Error)
```
code : "DE",
message : "Database Error.",
```


---
## currentList (최신 게시물 리스트)
### <span style="background-color:#DCFFE4"> response </span>
**성공**
Http Status - 200 (OK)
```
code : "SU", 
message : "Success.",
currentList : boardListItem[],
```

boardListItem
```
boardNumber : int,
title : string,
content : string,
boardTitleImg : string,
favoriteCount : int,
commentCount : int,
viewCount : int,
writeDatetime : string,
writerNickName : string,
writerProfileImg : string,


```

**실패**
- 데이터베이스 에러
Http Status - 500 (internal Server Error)
```
code : "DE",
message : "Database Error.",
```

---
## popularWordList (인기 검색어 리스트)
### <span style="background-color:#DCFFE4"> response </span>
**성공**
Http Status - 200 (OK)
```
code : "SU", 
message : "Success.",
popularWordList : string[],
```

**실패**
- 데이터베이스 에러
Http Status - 500 (internal Server Error)
```
code : "DE",
message : "Database Error.",
```

---
## searchList (검색 게시물 리스트)
### <span style="background-color:#DCFFE4"> response </span>
**성공**
Http Status - 200 (OK)
```
code : "SU", 
message : "Success.",
searchList : boardListItem[],
```

boardListItem
```
boardNumber : int,
title : string,
content : string,
boardTitleImg : string,
favoriteCount : int,
commentCount : int,
viewCount : int,
writeDatetime : string,
writerNickName : string,
writerProfileImg : string,


```

**실패**
- 데이터베이스 에러
Http Status - 500 (internal Server Error)
```
code : "DE",
message : "Database Error.",
```


---
## relativeWordList (관련 검색어 리스트)
### <span style="background-color:#DCFFE4"> response </span>
**성공**
Http Status - 200 (OK)
```
code : "SU", 
message : "Success.",
relativeWordList : string[],
```

**실패**
- 데이터베이스 에러
Http Status - 500 (internal Server Error)
```
code : "DE",
message : "Database Error.",
```

---
## boardDetail (게시물 상세)
## favoriteList (좋아요 리스트)
## favorite (좋아요 기능)
## commentList (댓글 리스트)
## postComment (댓글 쓰기)
## boardDelete (게시물 삭제)
## boardWrite (게시물 쓰기)
## boardUpdate (게시물 수정)
## getUser (유저정보)
## userBoardList (특정 유저 게시물 리스트)
### <span style="background-color:#DCFFE4"> response </span>
**성공**
Http Status - 200 (OK)
```
code : "SU", 
message : "Success.",
searchList : boardListItem[],
```

boardListItem
```
boardNumber : int,
title : string,
content : string,
boardTitleImg : string,
favoriteCount : int,
commentCount : int,
viewCount : int,
writeDatetime : string,
writerNickName : string,
writerProfileImg : string,


```

**실패**
- 데이터베이스 에러
Http Status - 500 (internal Server Error)
```
code : "DE",
message : "Database Error.",
```

---
## fileUpload (파일 업로드)
## getFile (파일 불러오기)