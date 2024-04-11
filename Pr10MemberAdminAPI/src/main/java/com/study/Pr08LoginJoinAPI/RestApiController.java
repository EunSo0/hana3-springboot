package com.study.Pr08LoginJoinAPI;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RestApiController {
  final MemberRepository mRepo;

  public RestApiController(MemberRepository mRepo){
    this.mRepo = mRepo;

    Member member1 = Member
        .builder()
        .username("admin")
        .password("1234")
        .email("admin@naver.com")
        .joindate(LocalDate.parse("2024-01-01")).build();
    mRepo.memberList.add(member1);
    Member member2 = Member
        .builder()
        .username("이은수")
        .password("1216")
        .email("dmstn@naver.com")
        .joindate(LocalDate.parse("2024-03-01")).build();
    mRepo.memberList.add(member2);
  }

  @PostMapping("/login")
  public ResDto login(@RequestBody LoginDto dto){
    boolean isLogin = false;
    if(dto.getInputName().equals("admin") && dto.getInputPw().equals("1234")){
      isLogin = true;
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

  @GetMapping("/memberList")
  public List<Member> memberList() {
    System.out.println(mRepo.memberList);
    return mRepo.memberList;
  }
}
