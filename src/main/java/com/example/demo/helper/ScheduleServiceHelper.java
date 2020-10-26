package com.example.demo.helper;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.Schedule;

@Component
public class ScheduleServiceHelper 
{
	public List<Schedule> getShortestZero(List<Schedule> list)
	{
		Long min = Long.MAX_VALUE;
		Schedule a = null;
		for(Schedule i : list)
		{
			if(dif(i.getEndTime(), i.getStartTime())<min)
			{
				a = i;
				min = dif(i.getEndTime(), i.getStartTime());
			}
		}
		var ans = new ArrayList<Schedule>();
		ans.add(a);
		return ans;
	}
	
	public List<Schedule> getShortestOne(List<ArrayList<Schedule>> list)
	{
		var ans = new ArrayList<Schedule>();
		Long min = Long.MAX_VALUE;
		for(ArrayList<Schedule> i: list)
		{
			if(dif(i.get(1).getEndTime(), i.get(0).getStartTime())<min)
			{
				ans = i;
				min = dif(i.get(1).getEndTime(), i.get(0).getStartTime());
			}
		}
		return ans;
	}
	
	private long dif(LocalDateTime st,LocalDateTime en)
	{
		return ChronoUnit.SECONDS.between(en,st);
	}
}
