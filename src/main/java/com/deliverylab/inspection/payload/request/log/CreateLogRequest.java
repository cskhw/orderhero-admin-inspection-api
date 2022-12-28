package com.deliverylab.inspection.payload.request.log;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateLogRequest {
	@NotBlank
	private String msg;

	@NotBlank
	private String path;
}
