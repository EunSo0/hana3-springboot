package com.study.Ex02SpringDI;

// 스프링에서 빈생성시 POJO 클래스를 이용한다.
// POJO : EJB와 달리 순수한 자바클래스 getter/setter/생성자만 추가해서 빈 클래스를 만든다.

import org.springframework.stereotype.Component;

@Component // 필수!!
public class Member {
  private String name = "이순신";
  // 기본생성자 - 필수!!
  public Member() {}
  // 매개변수가 있는 생성자
  public Member(String name){
    this.name = name;
  }
  //Getter/Setter
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
