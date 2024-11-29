## [스파르타 코딩클럽 내일 배움 캠프] Spring 심화 프로젝트
# 유저가 가진 금액을 환율 데이터를 통해 환전 해주는 API 제작.

### Tech Stack

>JAVA : JDK 17
> 
> Spring Boot : 3.3.5
> 
> IDE : IntelliJ
> 
>MySQL : Ver 9.1.0



API 명세서
---
> 일정 관리 앱  API 설계

|     기능      | Method | URL                  | request | response | 상태코드                           |
|:-----------:|:------:|----------------------|-----|----------|--------------------------------|
|    환전 요청    |  POST  | ./exchange           |요청 body          | 등록 정보    | 200 정상조회                       |
| 선택 고객 환전 조회 |  GET   | ./exchange/{id}      |요청 param         | 다건 응답 정보 | 200 정상조회 / 400 Bad Request("") |
| 환전 요청 상태 수정 |  PUT   | .exchange/{requestId}/cancel |요청 body          | 수정 정보    | 200 정상등록                       |
|    고객 삭제    | DELETE | ./users/{user_id}    |요청 param | -        | 200 정상삭제 / 404 Not Fount       |
ERD
---
![img.png](img.png)
https://www.erdcloud.com/d/Ne9CtkgNfjEZ4eN8C
