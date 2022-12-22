package com.deliverylab.inspection.payload.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SigninRequest {
	private String username;

	private String password;

	private String role;
}
