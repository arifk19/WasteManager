package com.wms.api.enums;

import org.springframework.http.HttpStatus;

public enum SecurityError {

	OPERATION_FAILED(HttpStatus.BAD_REQUEST, 400203, "The current operation is failed."),

	OPERATION_SUCCESS(HttpStatus.OK, 200001, "Your request has been submitted or updated successfully."),
	OPERATION_DELETE(HttpStatus.OK, 200001, "request data deleted successfully."),

	ACCESS_TOKEN_VALIDITY_SECONDS(5 * 60 * 60), SIGNING_KEY("devglan123r"), TOKEN_PREFIX("Bearer "),
	HEADER_STRING("Authorization"), AUTHORITIES_KEY("scopes");

	private int code;
	private String description;
	private HttpStatus status;
	private String value;
	private int valueInInt;

	private SecurityError(int valueInLong) {
		this.valueInInt = valueInLong;
	}

	private SecurityError(String value) {
		this.value = value;
	}

	SecurityError(HttpStatus status, int code, String description) {
		this.status = status;
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public HttpStatus getHttpStatus() {
		return status;
	}

	public int getValueInLong() {
		return valueInInt;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getValue() {
		return value;
	}

}
