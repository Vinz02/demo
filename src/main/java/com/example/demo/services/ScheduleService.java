package com.example.demo.services;

import com.example.demo.helper.ScheduleServiceHelper;
import com.example.demo.model.Schedule;
import com.example.demo.repository.ScheduleRespository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService 
{
	@Autowired
	ScheduleRespository scheduleRespository;
	
	@Autowired
	ScheduleServiceHelper scheduleServiceHelper;
	
    public List<Schedule> getShortestPath(LocalDateTime date, String from, String to)
    {
    	List<Schedule> start = null;
    	List<Schedule> start2 = null;
    	var x = new ArrayList<Schedule>();
    	var y = new ArrayList<Schedule>();
    	var z = new ArrayList<ArrayList<Schedule>>();
    	
    	start = scheduleRespository.findByStartTimeAndStartLoc(date, from);
		for(Schedule i:start)
		{
			if(i.getEndLoc().equals(to))
			{
				x.add(i);
			}
			else
			{
				y.add(i);
			}
		}
		if(!x.isEmpty())
		{
			return scheduleServiceHelper.getShortestZero(x);
		}
		else if(!y.isEmpty())
		{
			for(Schedule i:y)
    		{
    			start2 = scheduleRespository.findByStartTimeAndStartLoc(i.endTime, i.endLoc);
    			var c = new ArrayList<Schedule>();
    			for(Schedule j:start2)
        		{
        			if(j.getEndLoc().equals(to))
        			{
        				c.add(i);
        				c.add(j);
        			}
        		}
    			if(!c.isEmpty())
    				z.add(c);
    		}
			return scheduleServiceHelper.getShortestOne(z);
		}
		return null;
    }


    public List<Schedule> getCheapestPath(String date, String from, String to)
    {
        List<Schedule> cheapestTravel = new ArrayList<>();
        return  cheapestTravel;
    }
}
