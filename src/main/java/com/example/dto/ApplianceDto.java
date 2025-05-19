package com.example.dto;

import com.example.demo.enums.ApplianceMode;
import com.example.demo.enums.ApplianceType;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApplianceDto {
  private Long id;
  private String name;
  private ApplianceType type;
  private ApplianceMode mode;
}
