package jpabook.japshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded   //내장타입
    private Address address;

    @OneToMany(mappedBy = "member")  //mappedBy는 연관관계 주인이 아니라는 뜻, 또한 멤버에 의해 매핑이 되었다는 뜻이다.
    private List<Order> orders = new ArrayList<>();
}