package com.example.demo.strategy;

import org.springframework.stereotype.Component;

import com.example.demo.enums.ApplianceType;
import com.example.demo.enums.FanMode;
import com.example.demo.model.applicance.Appliance;

@Component
public class FanStrategy implements Switchable<FanMode> {

  @Override
  public void turnOff(Appliance appliance) {
    appliance.setMode(FanMode.OFF);
  }

  @Override
  public ApplianceType getTargetType() {
    return ApplianceType.FAN;
  }

}
