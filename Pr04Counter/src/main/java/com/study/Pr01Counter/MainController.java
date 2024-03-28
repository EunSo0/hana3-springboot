package com.study.Pr01Counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class MainController {
  @Autowired
  private Counter counter;

  @GetMapping("/")
  public String main(Model model) {
    model.addAttribute("count", counter.getCount());
    return "index";
  }

  @GetMapping("/plus")
  public String plus(Model model){
    counter.setCount(counter.getCount()+1);
    model.addAttribute("count", counter.getCount());
    return "index";
  }

  @GetMapping("/minus")
  public String minus(Model model){
    counter.setCount(counter.getCount()-1);
    model.addAttribute("count", counter.getCount());
    return "index";
  }

  @GetMapping("/api/plus")
  @ResponseBody
  public String api_plus() {
    counter.setCount(counter.getCount()+1);

    return String.valueOf(counter.getCount());
  }

  @GetMapping("/api/minus")
  @ResponseBody
  public String api_minus() {
    counter.setCount(counter.getCount()-1);

    return String.valueOf(counter.getCount());
  }
}
