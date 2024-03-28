package com.study.Pr03VM;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Product {
  private String name; // 상품명
  private int price; // 가격
  private LocalDate limitDate; // 유통기한

  public Product(String name, int price, LocalDate limitDate){
    this.name = name;
    this.price = price;
    this.limitDate = limitDate;
  }

}