# Spring boot + Reactjs(ts) + MySQL 게시판형 블로그 만들기

## 0. 개발환경 구축
<details>
<summary>
유튜브 링크
</summary>

https://www.youtube.com/watch?v=NTZgPYlassE&list=PLbq5jHjpmq7q-Td2jOXtpf7SD5c53RqXh

</details>

모든 개발 IDE는 vsCode로만 진행할 예정이다.

**Extension 설치**

- Korean Language Pack for Visual Studio Code : 한국어 팩
- Better Comments : 각주를 좀더 눈에 잘띄게
- Color Highlight : 색상 바로 보기
- GitHub Theme : 깃허브 테마(그냥 평소에 쓰던걸 쓰기로함 Material Icon Theme)
- Material Icon Theme : 아이콘 테마
- Git Graph : SourceTree처럼 깃을 시각화하여 볼 수 있음
- Git History : 깃 기록
- GitLens : 누가 어떤 커밋했는지 알려줌
- GitHub Pull Requests and Issues : 누가 Pull Request 했는지 알려줌
- GitHub Repositories : 레포지토리 연결해서 볼 수 있는데 로그인해야함
- Markdown Preview Github Styling : 마크다운 미리보기
- Todo Tree : 각주로 TODO를 적어놓으면 표시되어 뭘 해야할지 알 수 있음



**Java 설치**

https://code.visualstudio.com/docs/java/java-tutorial 에서 운영체제에 맞는 것을 다운받는다. JDK까지 자동으로 설치가 된다.

설치 후, 추가적인 Extension을 설치한다.

- gradle for java
- Spring Boot Extension Pack
- Spring Boot Snippets

**MySQL 설치**

홈페이지에서 MySQL을 설치해준다.

설치 후, 추가적인 Extension을 설치한다.
- mysql(publisher:"Weijan Chen")

왼쪽에 DB모양을 클릭하여 MySQL 설치시 사용했던 비밀번호를 입력하여 새 connection을 만들어준다.(0000)

**Node.js**

홈페이지에서 Node.js를 설치해준다.

설치 후, 추가적인 Extension을 설치한다.
- ES7+ React/Redux/React-Native snippets

## 1-1. 기능 설계 [a]

<details>
<summary>
유튜브 링크
</summary>

https://www.youtube.com/watch?v=bOAV4GeGYHg

</details>

**설계할 것들 적어보기**

메모장을 하나 열어서 설계할 것들을 미리 적어본다.

[인터페이스 설계](./Interface.md)

## 1-2. 기능 설계 [b]

<details>
<summary>
유튜브 링크
</summary>

https://www.youtube.com/watch?v=bOAV4GeGYHg

</details>

**설계할 것들 적어보기**

이어서 설계할 것들을 미리 적어본다.

[인터페이스 설계](./Interface.md)

## 1-3. 기능 설계 [c]

<details>
<summary>
유튜브 링크
</summary>

https://www.youtube.com/watch?v=kuqPBjZgsus&t=21s

</details>

**설계할 것들 적어보기**

이어서 설계할 것들을 미리 적어본다.

[인터페이스 설계](./Interface.md)


## 2-1 ERD / DDL / DCL 작성

<details>
<summary>
유튜브 링크
</summary>

https://www.youtube.com/watch?v=Nd3i_8f8RTw&list=PLbq5jHjpmq7q-Td2jOXtpf7SD5c53RqXh&index=5&t=5s

</details>

**데이터베이스 테이블 구현**

시작하기전 extension 추가할 것이 있다.

- ERD Editor

설치 후 workspace에 새로운 파일을 만들어준다. 이름은 `board.vuerd.json` 이다.(데이터 베이스 명.vuerd.json 형식이다.)

다이어그램을 다 그린 후 위에 데이터베이스 모양의 SQL DDL 아이콘을 클릭하면 쿼리문으로 만들어진 것을 뽑아낼 수 있다.

여기서 몇가지 항목들을 수작업으로 조정해줄 것이다.

1. "board"와 "image"테이블에 있는 AUTO_INCREMENT 항목 앞에 DEFAULT 라고 적혀있는 것을 지워줄 것이다.
2. "user" 테이블에 "nickname", "tel_number"에 UNIQUE를 추가해줄 것이다. NOT NULL과 COMMENT 사이에 추가해주면 된다.

그 다음 왼쪽에 익스텐션으로 추가한 DB아이콘을 클릭하면 MySQL이 왼쪽에 표시된다.

여기서 + 버튼을 눌러서 DB를 추가해준다. 생성된 SQL파일에 board라는 db를 만들겠다는 코드를 적어 실행한다.
```
CREATE DATABASE board;
```
