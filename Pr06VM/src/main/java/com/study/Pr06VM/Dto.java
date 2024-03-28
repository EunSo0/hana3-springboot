package com.study.Pr06VM;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Dto {
  String name;
  int price;
  LocalDate limitDate;
}
