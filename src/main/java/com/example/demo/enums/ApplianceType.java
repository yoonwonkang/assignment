package com.example.demo.enums;

/**
 * When We support more IOT appliance need to add
 */
public enum ApplianceType {
  FAN(FanMode.class), 
  LIGHT(LightMode.class), 
  AIR_CONDITIONER(AirConditionerMode.class);

  private final Class<? extends ApplianceMode> modeClass;

  ApplianceType(Class<? extends ApplianceMode> modeClass) {
    this.modeClass = modeClass;
  }

  public ApplianceMode parseMode(String name) {
    for (ApplianceMode mode : modeClass.getEnumConstants()) {
      if (mode.name().equalsIgnoreCase(name)) return mode;
    }
    throw new IllegalArgumentException("Invalid mode " + name + " for type " + this.name());
}

  public Class<? extends ApplianceMode> getModeClass() {
    return modeClass;
  }
}
