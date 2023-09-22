## signIn (로그인)
### request
```
*email : String,
*password : String,
//앞에 *는 필수라는 뜻
```
### response
**성공**
Http Status - 200 (OK)
```
code : "SU", 
message : "Success.",
token : "jwt...",
expiredDate : 12345678,
```
**실패**
- 로그인 실패
Http Status - 401 (Unauthorized)
```
code : "SF",
message : "Sign In Failed.",
//아이디가 틀렸는지 비번이 틀렸는지 알려주면 안됨
```
- 데이터베이스 에러
Http Status - 500 (Internal Server Error)
```
code : "DE",
message : "Database Error,"
```
---
## signUp (회원가입)
### request
```
*email : String,
*password : String,
*nickname : String,
*telNumber : String,
*address : String,
addressDetail : String,
```
### response
**성공**
Http Status - 200 (OK)
```
code : "SU", 
message : "Success.",
```

**실패**
- 이메일 중복
Http Status - 400 (Bad Request)
```
code : "EE",
message : "Existed Email",
```




---


## weeklyTop3List (주간 3위 게시물)
## currentList (최신 게시물 리스트)
## popularWordList (인기 검색어 리스트)
## searchList (검색 게시물 리스트)
## relativeWordList (관련 검색어 리스트)
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
## fileUpload (파일 업로드)
## getFile (파일 불러오기)