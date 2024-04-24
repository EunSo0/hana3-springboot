package com.study.springboot.controller;

import com.study.springboot.dto.CommunityResponseDto;
import com.study.springboot.service.One2OneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/community")
@RequiredArgsConstructor
public class CommunityController {
  private final One2OneService communityService;

//  @GetMapping("/community01")
//  public String community01(Model model){
//    List<CommunityResponseDto> list = communityService.findAll();
//    model.addAttribute("list", list);
//    return "/community/community01";
//  }

  @GetMapping("/community01_1")
  public String community01_1(@RequestParam Long no, Model model) {
    System.out.println(no);
    CommunityResponseDto dto = communityService.findById(no);
    model.addAttribute("dto", dto);
    return "/community/community01_1";
  }
}
