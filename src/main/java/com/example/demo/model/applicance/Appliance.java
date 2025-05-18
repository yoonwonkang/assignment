package com.example.demo.model.applicance;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 * appliance common part
 * appliance can turn off
 * appliance has id, name
 * if wanna appliance more flexible can split function(interface), column class
 * thinking about status need to be a common column?
 * ?? why need to split each device? is that helpful?
 */
@MappedSuperclass
public abstract class Appliance {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50)
  private String name;

  public abstract void turnOff();
}
