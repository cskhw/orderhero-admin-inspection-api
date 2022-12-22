# 딜리버리랩 검수확인서 어드민 백엔드

> ## 오더히어로

- http://orderhero.co.kr/index.php

## Setup proejct with npm

```bash
# dev
npm install
npm run dev

# testing
npm run test

# production
npm run build
npm run preview
```

> ## How to run dev, pruduction with docker

```bash
# local
docker-compose down
docker-compose up --build -d

# pruduction
docker-compose down
docker-compose -f docker-compose.prod.yml up --build -d
```

> ## Coding Convention

- AirBnB의 eslint + prettier를 사용
- 선정 이유: 일반적으로 제일 많이 사용됨(AirBnB, Naver, )
- 참고 링크: https://github.com/naver/eslint-config-naver/blob/master/STYLE_GUIDE.md

> ## Commit Convention

# 1. Commit Type

- feat: 새로운 기능 추가
- fix: 버그 수정
- docs: 문서 수정
- style: 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우
- refactor: 코드 리펙토링
- test: 테스트 코드, 리펙토링 테스트 코드 추가
- chore: 빌드 업무 수정, 패키지 매니저 수정

# 2. Subject

- 제목은 50자를 넘기지 않고, 대문자로 작성하고 마침표를 붙이지 않는다.
- 과거시제를 사용하지 않고 명령어로 작성한다.
  - “Fixed” —> “Fix"
  - “Added” —> “Add"

# 3. Example

```rust
feat: 멀티 셀렉트 박스 UI 개발
fix: 멀티 셀렉트 박스 마지막 json이 표시되지 않는 버그 수정
docs: Readme.md 커밋 컨벤션 수정 -> (더 자세하게 적으면 50~54줄 ~내용 수정)
style: 멀티 셀렉트 박스 색상 변경 및 값 width에 반응형으로 width 설정
refactor: 멀티 셀렉트 박스 이벤트 코드 event.js로 이동
test: login.php 로그인 버튼 테스트 코드 작성
chore: foobar-cookie^6.2.0 패키지에 추가
```
