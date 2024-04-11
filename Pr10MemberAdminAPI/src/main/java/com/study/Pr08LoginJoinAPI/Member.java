package com.study.Pr08LoginJoinAPI;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Member {
  private String username;
  private String password;
  private String email;
  private LocalDate joindate;
}