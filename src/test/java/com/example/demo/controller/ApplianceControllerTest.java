package com.example.demo.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.enums.ApplianceMode;
import com.example.demo.enums.ApplianceType;
import com.example.demo.enums.FanMode;
import com.example.demo.model.applicance.Appliance;
import com.example.demo.service.ApplianceService;
import com.example.dto.ApplianceDto;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Simple TDD Plan
 */
@WebMvcTest(ApplianceController.class)
public class ApplianceControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private ApplianceService applianceService;

  @Test
  void put_UpdateMode_ReturnsData() throws Exception {
    long id = 1;
    ApplianceMode mode = FanMode.SPEED1;
    ApplianceDto dto = ApplianceDto.builder()
      .id(id)
      .mode(mode.name())
      .type(ApplianceType.FAN)
      .name("my fan")
    .build();
    ObjectMapper om = new ObjectMapper();

    when(applianceService.updateMode(id, dto))
    .thenReturn(new Appliance(dto));

    mockMvc.perform(put("/appliance/{id}", id)
      .contentType(MediaType.APPLICATION_JSON)
      .content(om.writeValueAsString(dto)))
      .andExpect(status().isOk());
  }

  @Test
  void put_UpdateMode_ReturnsBadRequest() throws Exception {
    String id = "test";
    ApplianceDto dto = ApplianceDto.builder().build();

    ObjectMapper om = new ObjectMapper();

    mockMvc.perform(put("/appliance/{id}", id)
    .contentType(MediaType.APPLICATION_JSON)
    .content(om.writeValueAsString(dto)))
    .andExpect(status().isBadRequest());
  }
}
