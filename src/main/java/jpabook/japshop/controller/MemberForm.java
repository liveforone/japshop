package jpabook.japshop.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "회원 이름은 필수 입니다")  //값을 필수로 지정(validation) -> 값이 없으면 에러 반환
    private String name;

    private String city;
    private String street;
    private String zipcode;
}
