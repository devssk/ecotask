java 17, spring boot 3.0.5

JPA + querydsl

mariaDB

### `개발고민들`
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
</details>