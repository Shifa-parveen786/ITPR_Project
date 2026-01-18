package com.project.reportcardmanagement.service.impl;

import java.util.List;
import com.project.reportcardmanagement.dao.ScheduleDAO;
import com.project.reportcardmanagement.dao.impl.ScheduleDAOImpl;
import com.project.reportcardmanagement.model.Schedule;
import com.project.reportcardmanagement.service.ScheduleService;

public class ScheduleServiceImpl implements ScheduleService {

    ScheduleDAO dao = new ScheduleDAOImpl();

    public boolean addSchedule(Schedule s) throws Exception {
        return dao.addSchedule(s);
    }

    public List<Schedule> viewScheduleByExam(String examType) throws Exception {
        return dao.viewScheduleByExam(examType);
    }
}