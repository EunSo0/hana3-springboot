package com.study.Ex02SpringDI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
  // @GetMapping : HTTP Get요청을 처리하는 함수에 붙인다.
  //                    내부적으로 메소드는 Servlet으로 동작한다.
  // @ResponseBody : 응답을 문자열(JSON)로 응답한다는 의미
  // 요청 URL : localhost:8090/
  @GetMapping("/")
  @ResponseBody
  public String main() {
    return "스프인부터 웹 어플리케이션 첫 응답!";
  }
  // 스프링 빈을 주입받는 방법
  // 1. 필드 주입
  // @Autowired : 스프링 빈을 주입
  @Autowired
  private Member member1;
  @Autowired //@Autowired는 각각 기입해야한다.
  private Member member2;

  @GetMapping("/field")
  @ResponseBody
  public String field() {
    System.out.println("member1:"+member1); // 싱글톤 유지
    System.out.println("member2:"+member2); // 싱글톤 유지
    return "field() 호출됨 - " + member1.getName();
  }

  //2. 수정자(setter) 주입
  private Member member3;
  @Autowired
  public void setMember(Member member){
    this.member3 = member;
  }
  @GetMapping("/setter")
  @ResponseBody
  public String setter() {
    return "setter() 호출됨: " + member3.getName();
  }

  // 3. 생성자(constructor) 주입 - 추천
  // 1. final 키워드 사용 가능(객체 재할당 방지)
  // 2. 생성자로서 미리 주입을 받을 수 있다. null safety를 제공
  private final Member member4;
  @Autowired
  public MainController(Member member){
    // 레거시 자바 프로그램
    // 직접 주입
    Member member5 = new Member();

    this.member4 = member;
  }
  @GetMapping("constructor")
  @ResponseBody
  public String constructor(){
    return "constructor() 호출됨: " + member4.getName();
  }
}
