package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "transport", schema = "public")
public class Transport 
{
	@Id
	@Column(name = "tid")
	public String tId;
	
	@Column(name = "tinfo")
	public String tInfo;
	
	@OneToOne(mappedBy = "transport",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 private Schedule schedule;
}
