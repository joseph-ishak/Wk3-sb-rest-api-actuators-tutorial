package com.choicehotels.dap.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ProfileDTO {

	private @Id @GeneratedValue Long id;

	private String name;
	private String role;

	
	public ProfileDTO() {
		
	}
	public ProfileDTO(String name, String role) {

		this.name = name;
		this.role = role;
	}
	
	
}
