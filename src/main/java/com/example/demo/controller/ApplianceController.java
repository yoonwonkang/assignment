package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("appliance")
public class ApplianceController {

  @GetMapping("")
  public ResponseEntity<String> test() {
      return ResponseEntity.ok("test");
  }

  @PostMapping("off")
  public ResponseEntity<String> turnOffAllAppliance() {
      System.out.println("something work");
      return ResponseEntity.ok("All Appliance Off");
  }
  
}
