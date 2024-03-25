package com.study.Ex03Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
  @GetMapping("/")
  @ResponseBody
  public String main() {
    return "스트링부터 웹 어플입니다.";
  }

  @Autowired
  private Member member;

  // 호출 url : localhost:8080/member
  @GetMapping("/member")
  @ResponseBody
  public String member(){
    member.setName("홍길동");
    return "member() 호출됨:" + member.getName();
  }

  @Autowired
  @Qualifier("kakaoCard") // 주입될 객체를 직접 지정함.
  ICard iCard; // 인터페이스 구현 객체를 주입해줌.
               // BCCard, KakaoCard 중 어떤거를 주입할까?

  @GetMapping("/card")
  @ResponseBody
  public String card() {
    member.setiCard(iCard);
    member.getiCard().buy("핸드폰");
    return "card() 호출됨.";
  }
}
