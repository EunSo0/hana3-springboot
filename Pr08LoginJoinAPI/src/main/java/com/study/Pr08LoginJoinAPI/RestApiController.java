package com.study.Pr08LoginJoinAPI;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class RestApiController {
  final MemberRepository mRepo;

  @PostMapping("/login")
  public ResDto login(@RequestBody LoginDto dto){
    boolean isLogin = false;
    for(Member m : mRepo.memberList){
      if(m.getUsername().equals(dto.getInputName())
        && m.getPassword().equals(dto.getInputPw())){
        isLogin = true;
        break;
      }
    }

    if(isLogin){
      return ResDto.builder()
          .status("ok").message("로그인 성공")
          .build();
    } else{
      return ResDto.builder()
          .status("fail").message("로그인 실패")
          .build();
    }
  }

  @PostMapping("/duple")
  public ResDto duple(@RequestBody DupleDto dto){
    for(Member m : mRepo.memberList){
      if(m.getUsername().equals(dto.getInputName())){
        return ResDto.builder()
            .status("fail").message("중복된 아이디가 있습니다.")
            .build();
      }
    }
    return ResDto.builder()
        .status("ok").message("중복된 아이디가 없습니다.")
        .build();
  }

  @PostMapping("/join")
  public ResDto join(@RequestBody JoinDto dto){
    if(dto.getInputPw().equals(dto.getInputPw2())){
      Member member = Member.builder()
          .username(dto.getInputName())
          .email(dto.getInputEmail())
          .password(dto.getInputPw())
          .joindate(LocalDate.now())
          .build();
      mRepo.memberList.add(member);
    } else{
      return ResDto.builder()
          .status("fail").message("비밀번호가 일치하지 않습니다.")
          .build();
    }
    return ResDto.builder()
        .status("ok").message("회원가입이 완료되었습니다.")
        .build();
  }
}
