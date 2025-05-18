package com.example.demo.model.applicance;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
  private String type;

  private String mode;
  
  
}
