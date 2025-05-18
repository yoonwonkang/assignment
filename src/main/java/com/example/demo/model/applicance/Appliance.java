package com.example.demo.model.applicance;

import com.example.demo.enums.ApplianceMode;
import com.example.demo.enums.ApplianceType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Transient;

/**
 * every IOT device is appliance
 * appliance has switchable and mode controllable
 */
@Entity
public class Appliance {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Enumerated(EnumType.STRING)
  private ApplianceType type;

  private String modeCode;

  @Transient
  private ApplianceMode mode;

  @PostLoad
  public void loadMode() {
    if (type != null && modeCode != null) {
      this.mode = type.parseMode(modeCode);
    }
  }

  @PrePersist
  @PreUpdate
  public void persistMode() {
    if (mode != null) this.modeCode = mode.name();
    else new NullPointerException("mode is required value");
  }

  public void setMode(ApplianceMode mode) {
    this.mode = mode;
    this.modeCode = mode.name();
  }

  public ApplianceMode getMode() {
    return this.mode;
  }
  public ApplianceType getType() {
    return this.type;
  }
}
