# 📝 대출 서비스 맛보기 과제

## 1️⃣ Tech Stack
- Language : `kotlin`
- Build : `gradle`
- DataBase : `MySQL`
- Containerization : `docker`
- JDK : `JDK 11`
- Caching : `Redis`
- Framework : `SpringBoot Multi Module`
- library : `Spring Data JPA`, `Lombok`, `Swagger`, `Apache Kafka` , `Nginx`

## 2️⃣ API 설명
### **- ✅ 상품 정보 API**
1. 상품 정보 수신 API
   - 상품 정보에 변경이 발생했을 때, 상품 정보 조회 API 의 캐시가 Evict 되어야 한다.
   - 금융사, 상품 별로 데이터를 관리해야한다.

2. 상품 정보 조회 API
   - 상품 정보 조회는 모든 유저에게 동일한 상품을 노출해준다.
   - Redis를 사용하여 DB Transaction을 줄이는 방향으로 개발한다.

<br/>

### **- ✅ 유저 정보 API**
**1. 유저 정보 수신 API**
   1. 유저에 관련된 정보를 받는다.
   2. 유저의 정보 중 민감한 정보는 **모두 암호화 되어 데이터베이스에 저장**되어야한다.
   3. 단순히 암호화 필요한 데이터마다 암호화를 해줄 수도 있지만, 데이터베이스별로, 
      각 금융사별로 다른 키 값을 사용해서 암호화할 수 있고, 여러 데이터를 암호화해야
      하기에 공통적인 처리 로직을 만들어야한다.
   4. 휴먼 에러를 줄이기 위해 데이터베이스에 저장 혹은 조회할 때는
      Entity 중에서 @Encrypt 라는 어노테이션이 붙은 칼럼은 암/복호화 하도록 개발한다.
   5. @Encrypt Custom Annotation 만들기
   6. AOP를 통해서 find함수, save 함수를 PointCut으로 잡고, 해당 Entity에 @Encrypt 어노테이션이
      붙은 칼럼은 암호화 혹은 복호화를 하도록 개발한다.

**2. 유저 정보 조회 API**
   - 위에 서술한 AOP를 통한 복호화가 잘 진행되는 지 확인할 수 있다.

## 3️⃣ 공통 사항
✅ 모든 Request 는 AOP를 통해 로그를 찍을 수 있도록 개발한다.

✅ 기관별, 상품별로 데이터를 관리할 경우가 많다.

✅ 기관과 상품은 EnumClass 를 만들어서 휴먼 에러의 여지를 줄여준다.

✅ 데이터베이스 Entity 역시 EnumClass 를 사용하고, Converter 를 사용한다.

✅ 모든 API 에 Swagger 를 작성해야한다.

✅ API 내에서 ExceptionHandling 을 ControllerAdvice 를 통해 처리해야한다.

✅ Docker 이미지를 만들어야한다.

✅ Docker-Compose 를 사용해서 도커 이미지를 띄워야한다.

✅ 여러 개의 Spring Boot 서버를 띄우고 NginX와 연결해야한다.
