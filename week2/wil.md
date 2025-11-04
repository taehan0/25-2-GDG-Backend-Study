# 백엔드 스터디 2주차

## 스프링 계층형 아키텍쳐
- Browser(Frontend): 손님
- Controller: 웨이터
- Service: 주방장
- Repository: 창고 관리인
- DB: 창고
- Browser~Repository는 DTO로, Repository와 DB는 Entity로 소통한다

## Spring Bean
- 스프링 컨테이너 안에서 관리되는 객체로, 우리가 new로 생성하는 것이 아닌, 스프링이 대신 생성하고 주입하는 것
- @Controller, @Service, @Repository 등의 annotation을 사용하여 등록 가능

## 의존성 주입
- 의존하는 객체를 내가 생성하지 않고, 스프링이 넣어주는 것
- 이번 실습의 경우, private final 한 객체를 @RequiredArgsContructor 어노테이션이 생성자에 포함시키며 자동으로 주입
