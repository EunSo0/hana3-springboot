package com.study.Ex03Autowired;

import org.springframework.stereotype.Component;

//원래 빈의 이름 "bcCard"
@Component("cardBC") // 빈의 이름을 직접 지정할 수 있다.
public class BCCard implements ICard{
  @Override
  public void buy(String itemName) {
    System.out.println("BC카드로 "+itemName+"을 샀다.");
  }
}