package com.raySpot.ProductManagementSystem.Controllers.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class APIResponse {
    private Object payLoad;
    private String message;
    private boolean isSuccessful;
}
