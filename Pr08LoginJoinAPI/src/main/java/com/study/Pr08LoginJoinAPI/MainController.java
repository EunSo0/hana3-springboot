package com.study.Pr08LoginJoinAPI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {
  @GetMapping("/")
  public String main(){
    return "redirect:/login";
  }

  @GetMapping("/login")
  public String loginForm() {
    return "login";
  }

  @GetMapping("/join")
  public String joinForm() {
    return "join";
  }
}
