package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.enums.ApplianceMode;
import com.example.demo.service.ApplianceService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("appliance")
public class ApplianceController {
  private static final Logger logger = LogManager.getLogger(ApplianceController.class);
  private final ApplianceService applianceService;

  public ApplianceController(ApplianceService applianceService) {
    this.applianceService = applianceService;
  }

  @GetMapping("")
  public ResponseEntity<String> test() {
    return ResponseEntity.ok("test");
  }

  @PostMapping("off")
  public ResponseEntity<String> turnOffAllAppliance() {
    System.out.println("something work");
    return ResponseEntity.ok("All Appliance Off");
  }

  @PutMapping("{id}")
  public ResponseEntity<String> putMethodName(@PathVariable Long id, @RequestBody ApplianceMode mode) {
    applianceService.updateMode(id, mode);
    return ResponseEntity.ok("appliance update");
  }
  
}
