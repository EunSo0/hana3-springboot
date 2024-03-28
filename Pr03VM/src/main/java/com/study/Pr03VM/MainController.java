package com.study.Pr03VM;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
  private List<Product> productList = new ArrayList<>();

  @GetMapping("/")
  public String index(Model model){
    model.addAttribute("products", productList);
    return "productList";
  }

  @GetMapping("/addProductForm")
  public String addProduct() {
    return "addProductForm";
  }

  @PostMapping("/addProduct")
  public String addProduct(@RequestParam String inputName, @RequestParam int inputPrice, @RequestParam LocalDate inputLimitDate) {
    Product product = new Product(inputName, inputPrice, inputLimitDate);
    productList.add(product);
    System.out.println("추가완료!");
    return "redirect:/";
  }

  @GetMapping("/editProductForm")
  public String editProduct(@RequestParam int index, Model model) {
    Product product = productList.get(index);
    model.addAttribute("product", product);
    model.addAttribute("index", index);
    return "editProductForm";
  }

  @PostMapping("/editProduct")
  public String editProduct(@RequestParam int index, @RequestParam String inputName, @RequestParam int inputPrice, @RequestParam LocalDate inputLimitDate) {
    Product product = productList.get(index);
    product.setName(inputName);
    product.setPrice(inputPrice);
    product.setLimitDate(inputLimitDate);
    System.out.println("수정완료!");
    return "redirect:/";
  }

  @GetMapping("/deleteProduct")
  public String deleteProduct(@RequestParam int index) {
    productList.remove(index);
    return "redirect:/";
  }
}
