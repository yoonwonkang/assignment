package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.example.demo.enums.ApplianceMode;
import com.example.demo.enums.ApplianceType;
import com.example.demo.model.applicance.Appliance;
import com.example.demo.model.applicance.ApplianceRepository;
import com.example.demo.strategy.Switchable;

@Service
public class ApplianceService {

  private final ApplianceRepository applianceRepository;
  private final Map<ApplianceType, Switchable<?>> strategyMap;

  private static final Logger logger = LogManager.getLogger(ApplianceService.class);

  public ApplianceService(ApplianceRepository applianceRepository, List<Switchable<?>> strategyList) {
    this.applianceRepository = applianceRepository;
    this.strategyMap = strategyList.stream().collect(Collectors.toMap(Switchable::getTargetType, s -> s));
  }

  public Appliance updateMode(Long applianceId, ApplianceMode mode) {
    logger.info("Received Appliance Id : {}, update Mode : {} ", applianceId, mode);
    Appliance appliance = applianceRepository.findById(applianceId).orElseThrow(() -> new NoSuchElementException("Appliance not found"));
    // ApplianceMode mode = appliance.getType().parseMode(modeName);x
    appliance.setMode(mode);

    appliance = applianceRepository.save(appliance);
    // update IOT ->
    return appliance;
  }


  public void updateMode(Long applianceId, String modeName) {
    logger.info("Received Appliance Id : {}, update ModeName : {} ", applianceId, modeName);
    Appliance appliance = applianceRepository.findById(applianceId).orElseThrow(() -> new NoSuchElementException("Appliance not found"));
    ApplianceMode mode = appliance.getType().parseMode(modeName);
    appliance.setMode(mode);

    applianceRepository.save(appliance);
    // update IOT ->
  }

  public void turnOffAll() {
    logger.info("Turn off all apppliance");
    List<Appliance> appliances = applianceRepository.findAll();
    for( Appliance appliance : appliances ) {
      Switchable<?> strategy = strategyMap.get(appliance.getType());
      if(strategy != null) {
        strategy.turnOff(appliance);
      }
    }
    applianceRepository.saveAll(appliances);
    // update all IOT
  }
}