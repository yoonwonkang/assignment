package com.example.demo.strategy;

import com.example.demo.enums.ApplianceMode;
import com.example.demo.enums.ApplianceType;
import com.example.demo.model.applicance.Appliance;

public interface Switchable <T extends ApplianceMode> {
  void turnOff(Appliance appliance);
  ApplianceType getTargetType();
}
