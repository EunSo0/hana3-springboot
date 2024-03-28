package com.study.Pr02Calc;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Calc {
  private int num1;
  private int num2;
  private int result;
  private double divResult;

  public void add(int a, int b) {
    num1 = a;
    num2 = b;
    result = a + b;
  }

  public void sub(int a, int b) {
    num1 = a;
    num2 = b;
    result = a - b;
  }

  public void mul(int a, int b) {
    num1 = a;
    num2 = b;
    result = a * b;
  }

  public void div(int a, int b) {
    num1 = a;
    num2 = b;
    divResult = (double) a / (double) b;
  }
}
