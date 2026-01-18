package com.project.reportcardmanagement.service;

import java.util.List;
import com.project.reportcardmanagement.model.Schedule;

public interface ScheduleService {

    boolean addSchedule(Schedule schedule) throws Exception;

    List<Schedule> viewScheduleByExam(String examType) throws Exception;
}