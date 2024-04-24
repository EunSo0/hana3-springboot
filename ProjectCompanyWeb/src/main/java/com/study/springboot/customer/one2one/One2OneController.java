package com.study.springboot.one2one;

import com.study.springboot.ResDto;
import com.study.springboot.one2one.dto.One2OneSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/customer")
@RequiredArgsConstructor
public class One2OneController {
  private final One2OneService one2OneService;

  @PostMapping("/customerWriteAction")
  @ResponseBody
  public ResDto writeAction(@RequestBody One2OneSaveRequestDto dto) {
    Long newIdx = one2OneService.save(dto);

    boolean isFound = one2OneService.existsById(newIdx);
    if(isFound){
      return ResDto.builder()
          .status("ok").message("질문이 등록되었습니다.")
          .build();
    } else{
      return ResDto.builder()
          .status("fail").message("질문 등록에 실패했습니다.")
          .build();
    }
  }

}
