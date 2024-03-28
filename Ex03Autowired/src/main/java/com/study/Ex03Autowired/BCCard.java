package com.study.Ex03Autowired;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//원래 빈의 이름 "bCCard"
@Component("cardBC") //빈의 이름을 직접 지정할 수 있다.
@Primary  //우선적으로 사용되는 객체 빈으로 지정
public class BCCard implements ICard{
    @Override
    public void buy(String itemName) {
        System.out.println("BCCard : "+itemName);
    }
}
