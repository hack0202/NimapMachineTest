package com.MachineTest.Nimap.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ErrorResponse {
private String message;
private int status;
public ErrorResponse() {
	
}
}
