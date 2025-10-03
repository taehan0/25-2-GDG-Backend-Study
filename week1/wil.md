# 백엔드 스터디 1주차

## HTTP 
-클라이언트와 서버가 어떻게 데이터를 주고받을지 정해놓은 규칙
-요청 메소드/헤더/바디 등을 담고 있음

## 주요 메소드
-GET

-POST

-PUT

-PATCH

-DELETE

## 주요 상태메세지
-200 요청 성공

-201 요청 성공, 리소스 생성

-400 클라이언트측 오류

-404 리소스 찾을 수 없음

-500 서버 내부 오류

## 기타

프론트엔드: 사용자와 직접 상호작용, UI개발

백엔드: 사용자의 요청을 받아 실제 데이터를 저장/관리

API: 한 프로그램이 다른 프로그램의 기능을 사용 가능하게 미리 정해놓은 규칙

REST API: HTTP의 장점을 가장 잘 활용할 수 있는 스타일로, 가장 보편적임

<img width="1140" height="518" alt="image" src="https://github.com/user-attachments/assets/8d8cc30d-b539-488f-b62f-f7e75e0a3317" />

## 상품 기능
-상품 등록:[post]/products

-상품 목록 조회:[get]/products

-개별 상품 정보 상세 조회:[get]/products/{productId}

-상품 정보 수정:[patch]/products/{productId}

-상품 삭제:[delete]/products/{productId}

## 주문 기능
-주문 정보 생성:[post]/orders

-주문 목록 조회:[get]/orders

-개별 주문 상세 정보 조회:[get]/orders/{orderId}

-주문 취소:[delete]/orders/{orderId}
