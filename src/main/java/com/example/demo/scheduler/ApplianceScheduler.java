package com.example.demo.scheduler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.service.ApplianceService;

@Component
public class ApplianceScheduler {

  private static final Logger logger = LogManager.getLogger(ApplianceScheduler.class);
  private final ApplianceService applianceService;
  public ApplianceScheduler(ApplianceService applianceService) {
    this.applianceService = applianceService;
  }

  @Scheduled(cron = "0 0 1 1 1 *")
  public void turnOffAllAppliance() {
    logger.info("start turn off all appliance");
    applianceService.turnOffAll();
    logger.info("end turn off all appliance");
  }
}
