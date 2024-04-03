package com.study.Pr03VM_answer;

import org.springframework.boot.Banner;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
  public static List<Product> list = new ArrayList<>();

  @GetMapping("/")
  public String main(Model model) {
    model.addAttribute("list", list);
    model.addAttribute("count", list.size());
    return "productList";
  }

  @GetMapping("/addProductForm")
  public String addProductForm() {
    return "addProductForm";
  }

  // 1. @RequestParam 단일변수
  // 2. @ModelAttribute 객체 매핑(바인딩)
  @PostMapping("/addProduct")
  @ResponseBody
  public String addProduct(
      // null을 허용한다.
      @RequestParam(required = false, defaultValue = "기본값") String inputName,
      @RequestParam int inputPrice,
      @RequestParam LocalDate inputLimitDate){

    System.out.println(inputName + inputPrice + inputLimitDate);

    // 매개변수가 있는 생성자보다 선호
    Product product = Product.builder()
        .name(inputName)
        .price(inputPrice)
        .limit_date(inputLimitDate)
        .build();
    list.add(product);

    System.out.println("size"+list.size());

    return "<script>alert('상품이 추가되었습니다.'); location.href='/';</script>";
//    return "redirect:/";
    // 웹브라우저에게 응답을 주면서, 리다이렉트할 경로를 전달하면, 웹브라우저는 받자마자 이 경로로 다시 요청한다.
  }

  @GetMapping("/editProductForm")
  public String editProductForm(Model model, @RequestParam int index) {
    Product product = list.get(index);
    model.addAttribute("product", product);

    return "editProductForm";
  }

  @PostMapping("/editProduct")
  @ResponseBody
  public String editProductForm(@RequestParam int index, @RequestParam String inputName
                               ,@RequestParam int inputPrice, @RequestParam LocalDate inputLimitDate){
    Product product = list.get(index);
    product.setName(inputName);
    product.setPrice(inputPrice);
    product.setLimit_date(inputLimitDate);
    list.set(index, product);

    return "<script>alert('상품이 수정되었습니다.'); location.href='/';</script>";
  }

  // deleteProduct?index=0
  @GetMapping("/deleteProduct")
  @ResponseBody
  public String deleteProduct(@RequestParam int index) {
    System.out.println("index:" + index);
    list.remove(index);
    return "<script>alert('상품이 삭제되었습니다.'); location.href='/';</script>";
  }


}
