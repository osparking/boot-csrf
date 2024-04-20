package space.bum.spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example")
public class ExampleController {

  @GetMapping("/form")
  public String showForm() {
    return "csrf-form";
  }

  @PostMapping("/submit")
  public String processForm() {
    return "success";
  }
}