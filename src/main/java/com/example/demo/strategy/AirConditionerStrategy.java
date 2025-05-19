package com.example.demo.strategy;

import org.springframework.stereotype.Component;

import com.example.demo.enums.AirConditionerMode;
import com.example.demo.enums.ApplianceType;
import com.example.demo.model.applicance.Appliance;

@Component
public class AirConditionerStrategy implements Switchable<AirConditionerMode> {

  @Override
  public void turnOff(Appliance appliance) {
    appliance.setMode(AirConditionerMode.OFF);
  }

  @Override
  public ApplianceType getTargetType() {
    return ApplianceType.AIR_CONDITIONER;
  }

}
