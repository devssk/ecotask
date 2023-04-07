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
</details>