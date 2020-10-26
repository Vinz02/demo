package com.example.demo.controller;

import com.example.demo.model.Schedule;
import com.example.demo.repository.ScheduleRespository;
import com.example.demo.services.ScheduleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    
    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/get/shortest")
    @ResponseBody
    public List<Schedule> getShortestPath(@RequestParam(value = "date",required = true)String date,
    		@RequestParam(value = "from",required = true)String from, 
    		@RequestParam(value = "to",required = true)String to)
    {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	LocalDateTime Date = LocalDateTime.parse(date, formatter);
    	return scheduleService.getShortestPath(Date, from, to);
    }
}
