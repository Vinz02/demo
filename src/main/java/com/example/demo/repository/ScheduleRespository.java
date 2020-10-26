package com.example.demo.repository;

import com.example.demo.model.Schedule;
import com.example.demo.model.ScheduleId;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ScheduleRespository extends JpaRepository<Schedule, ScheduleId> 
{
	@Query(value = "SELECT * FROM PUBLIC.SCHEDULE WHERE ST_TIME>=?1 AND ST_LOC = ?2",nativeQuery = true)
		List<Schedule> findByStartTimeAndStartLoc(LocalDateTime startTime, String startLoc);
	
	@Query(value = "SELECT * FROM PUBLIC.SCHEDULE WHERE ST_TIME>=?1 AND ST_LOC = ?2 AND EN_LOC = ?3",nativeQuery = true)
	List<Schedule> findByStartTimeAndStartLocAndEndLoc(LocalDateTime startTime, String startLoc,String endLoc);
	
}
