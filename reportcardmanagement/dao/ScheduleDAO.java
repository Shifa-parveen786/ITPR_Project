package com.project.reportcardmanagement.dao;

import java.util.List;
import com.project.reportcardmanagement.model.Schedule;

public interface ScheduleDAO {

    boolean addSchedule(Schedule schedule) throws Exception;

    List<Schedule> viewScheduleByExam(String examType) throws Exception;
}