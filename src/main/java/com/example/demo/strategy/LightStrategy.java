package com.example.demo.strategy;

import org.springframework.stereotype.Component;

import com.example.demo.enums.ApplianceType;
import com.example.demo.enums.LightMode;
import com.example.demo.model.applicance.Appliance;

@Component
public class LightStrategy implements Switchable {

  @Override
  public void turnOff(Appliance appliance) {
    appliance.setMode(LightMode.OFF);
  }

  @Override
  public ApplianceType getTargetType() {
    return ApplianceType.LIGHT;
  }

}
