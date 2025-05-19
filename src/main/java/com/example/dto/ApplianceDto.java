package com.example.dto;

import com.example.demo.enums.ApplianceType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ApplianceDto {
  private Long id;
  private String name;
  private ApplianceType type;
  private String mode;
}
