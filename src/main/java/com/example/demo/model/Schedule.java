package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(ScheduleId.class)
@Table(name = "schedule", schema="public")
public class Schedule implements Serializable
{
	private static final long serialVersionUID = 1;
	
    @Id
    @Column(name = "tid")
    public String tId;

    @Id
    @Column(name = "st_time")
    public LocalDateTime startTime;

    @Column(name = "en_time")
    public LocalDateTime endTime;

    @Column(name = "price")
    public Integer price;
    
    @Column(name = "st_loc")
    public String startLoc;
    
    @Column(name = "en_loc")
    public String endLoc;
    
    public ScheduleId getId()
    {
    	return new ScheduleId(tId,startTime);
    }
    
    public void setId(ScheduleId id)
    {
    	this.tId = id.tId;
    	this.startTime = id.startTime;
    }

}