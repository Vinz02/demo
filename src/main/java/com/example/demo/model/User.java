package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "user", schema="public")
public class User implements Serializable 
{
	private static final long serialVersionUID = 1;
	
	@Id
	@Column(name = "user_id")
	public Long userId;
	
	@Column(name = "name")
	public String name;
	
	@Column(name = "email")
	public String email;
	
	@Column(name = "phone")
	public String phone;
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 private Booking booking;
}
