package com.example.homeservice.Request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HomeRequest {
    @NotBlank
    private String name;
    @Nullable
    private String address;
}
