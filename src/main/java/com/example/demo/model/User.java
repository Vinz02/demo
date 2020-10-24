package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user", schema="public")
public class User 
{
	@Id
	@Column(name = "UserId")
	Long userId;
	
	@Column(name = "Name")
	String name;
	
	@Column(name = "Email")
	String email;
	
	@Column(name = "Phone")
	String phone;
}
