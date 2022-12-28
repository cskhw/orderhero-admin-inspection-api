package com.deliverylab.inspection.payload.request.auth;

import jakarta.validation.constraints.NotBlank;

public class ValidRequest {
  @NotBlank
  private String refreshToken;

  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }
}