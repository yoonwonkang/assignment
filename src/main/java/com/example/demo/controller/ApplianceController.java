package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ApplianceService;
import com.example.dto.ApplianceDto;




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
    logger.info("[POST] /appliance/off start");
    return ResponseEntity.ok("All Appliance Off");
  }

  @PutMapping("{id}")
  public ResponseEntity<String> updateMode(@PathVariable("id") Long id, @RequestBody ApplianceDto dto) {
    logger.info("[PUT] /appliance/{} with dto : {}", id, dto);
    applianceService.updateMode(id, dto);
    return ResponseEntity.ok("appliance update");
  }
  
}
