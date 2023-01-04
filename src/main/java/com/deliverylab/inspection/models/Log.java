package com.deliverylab.inspection.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "logs")
public class Log extends Base {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotBlank
	private String msg;

	@NotBlank
	private String path;

	public Log() {
	}

	public Log(String msg, String path) {
		super();
		this.msg = msg;
		this.path = path;
	}
}