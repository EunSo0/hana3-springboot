package com.study.Pr06VM;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
  private List<Product> productList = new ArrayList<>();

  @GetMapping("/")
  public String index(){
    return "productList";
  }

  @GetMapping("/addProductForm")
  public String addProduct() {
    return "addProductForm";
  }

  @PostMapping("/api/addProduct")
  @ResponseBody
  public String addProduct(@RequestBody Dto dto) {
    Product product = new Product(dto.getName(), dto.getPrice(), dto.getLimitDate());
    productList.add(product);
    System.out.println("추가완료!");
    return "";
//    return "productList";
  }

  @GetMapping("/editProductForm")
  public String editProduct(@RequestParam int index) {
    Product product = productList.get(index);
    return "editProductForm";
  }

  @PostMapping("/api/editProduct")
  public String editProduct(@RequestParam int index, @RequestParam String inputName, @RequestParam int inputPrice, @RequestParam LocalDate inputLimitDate) {
    Product product = productList.get(index);
    product.setName(inputName);
    product.setPrice(inputPrice);
    product.setLimitDate(inputLimitDate);
    System.out.println("수정완료!");
    return "redirect:/";
  }

  @GetMapping("/api/deleteProduct")
  public String deleteProduct(@RequestParam int index) {
    productList.remove(index);
    return "redirect:/";
  }
}
