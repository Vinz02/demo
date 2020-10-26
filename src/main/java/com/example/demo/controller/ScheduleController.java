//package com.example.demo.controller;
//
//import com.example.demo.model.Schedule;
//import com.example.demo.repository.ScheduleRespository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Date;
//import java.util.List;
//
//@RestController
//@RequestMapping("/schedule")
//public class ScheduleController {
//
//    @Autowired
//    ScheduleRespository scheduleRespository;
//
//    @GetMapping("/get/{tid}")
//    @ResponseBody
//    public Schedule get(@PathVariable Long tid)
//    {
//        var abc = scheduleRespository.findById(tid);
//        return abc.get();
//    }
//
//    @GetMapping("/get/shortest")
//    @ResponseBody
//    public List<Schedule> getShortestPath(@PathVariable Date date, )
//    {
//
//    }
//
//    @GetMapping("/get/cheapest")
//    @ResponseBody
//    public List<Schedule>  getCheaptestPath(@PathVariable Date date)
//    {
//
//    }
//
//    @DeleteMapping("/delete/{tid}")
//    @ResponseBody
//    public void delete(@PathVariable Long tid)
//    {
//        scheduleRespository.deleteById(tid);
//    }
//}
