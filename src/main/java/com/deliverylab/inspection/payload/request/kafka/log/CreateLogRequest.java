package com.deliverylab.inspection.payload.request.kafka.log;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateLogRequest {
    String userId;

    @NotBlank
    private String path;

    @NotBlank
    String url;

    @NotBlank
    String ip;

    String event;

}
