package com.study.Pr08LoginJoinAPI;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
  @GetMapping("/")
  public String main(){
    return "redirect:/login-form";
  }

  @GetMapping("/login-form")
  public String loginForm() {
    return "login";
  }

  @GetMapping("/join-form")
  public String joinForm() {
    return "join";
  }

  @GetMapping("/admin")
  public String admin() { return "admin"; }

  @GetMapping("/update-form")
  public String update() { return "update"; }
}
