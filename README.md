java 17, spring boot 3.0.5

JPA + querydsl

mariaDB

### `개발이슈들`
<details>
<summary>PK가 없는 TABLE JPA 맵핑</summary>
JobHistory의 DB구조는 PK가 없는 구조이다.
<br>
하지만 JPA를 사용하는 상황에서 TABLE을 ENTITY로 맵핑하려면 ID가 필요하다.
<br>
JobHistory에서 employee_id와 start_date를 유니크 인덱스로 사용하고 있었고
<br>
이를 복합키로 처리하여 JobHistoryId클래스를 만들고 이를 JobHistory의 ID로 사용했다.

[출처](https://seunghunchan.tistory.com/32)
[출처2](https://www.baeldung.com/spring-jpa-embedded-method-parameters)
</details>
<details>
<summary>DTO 구조와 mapper의 처리</summary>
dto에 대해서 생각이 많아진다.
<br>
dto를 각 table에 대응하여 만들어 계층형으로 사용할지
<br>
아니면 dto마다 필요한 데이터만 담아두는것으로 사용할지에 대한 고민이다.
<br>
table에 대응하여 계층형으로 사용한다면 재사용성이 높아지는 장점이 있으며
<br>
dto마다 필요한 데이터만 담으면 mapper를 만들기 쉽다.
<br>
이 mapper에 대한 고민도 있는데 라이브러리를 사용하는게 쉽지만
<br>
아직 api가 몇개 없으므로 직접 function을 사용하여 mapper를 만들어서 사용해보았다.
<br>
이리저리 유튜브나 구글로 검색해보는데 명확하게 들어오지많아서 고민이 많다.
<br>
2023-04-08
<br>
dto를 table에 대응하여 계층형으로 사용하기로 결정하였다.
<br>
dto를 재사용하는게 좀더 유지보수 측면에서 더 좋다고 생각되었기 때문이다.
<br>
mapper에 대한거는 modelMapper와 MapStruct중 MapStruct가 성능이 좋고 다양한 설정들이 있어서
<br>
MapStruct 라이브러리를 사용하기로 결정하였다.
<br>
MapStruct를 사용하면서 나타난 문제는 JPA의 대표적 문제인 N + 1 을 해결하기 위해 querysdl을 사용해
<br>
연관되는 테이블을 모두 fetch를 사용하여 끌어왔는데 추가적으로 쿼리가 나가고 있는 문제가있다.
<br>
이것에 대한거는 좀더 디버그를 해보면서 잡아봐야할것같다.
<br>
2023-04-11
<br>
추가적으로 쿼리가 나가는 문제는 mapperImpl이 잘못생성되어 사용하지않는 필드도 접근하여
<br>
Lazy로딩이 추가적으로 나가고 있었던 문제로 재생성을하여 해결하였다.
</details>
<details>
<summary>validation</summary>
dto의 유효성 검증을 위해 validation을 도입하여 사용하였다.
<br>
컨트롤러에 써도 되지만 해당 exception을 핸들링 하고 싶어서 서비스단에 적용했다.
<br>
컨트롤러에서는 ArgumentResolver가 동작하여 구현체인 RequestResponseBodyMethodProcessor가 처리를 하는데
<br>
이 내부에서 @Valid로 시작하는 어노테이션이 있을경우 유효성 검사를 진행한다.
<br>
이때 검증에 오류가 있다면 MethodArgumentNotValidException 예외가 발생하고 dispatcherservlet에 등록된
<br>
DefaultHandlerExceptionResolver에 의해 400 BAD_REQUEST가 반환된다.
<br>
컨트롤러가 아닌 다른곳에 하고싶다면 AOP기반으로 유효성 검증을 진행하는 @Validated가 있다.
<br>
클래스단에 @Validated 를 붙이고 유효성 검증을 진행할 파라미터에 @Valid를 붙여주면 된다.
<br>
검증에 오류가 있다면 ConstraintViolationException 예외가 발생한다.
<br>
이 예외를 globalExceptionHandler에 지정하여 반환해주도록 설정했다.
<br>
다만 service를 인터페이스와 구현체로 사용하는데 구현체에 @Validated를 적용하면 안된다.
<br>
이러면 ConstraintDeclarationException 예외가 발생하며 인터페이스에 @Validated를 적용해야 한다.
</details>