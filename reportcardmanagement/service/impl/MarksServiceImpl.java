package com.project.reportcardmanagement.service.impl;

import java.util.List;
import com.project.reportcardmanagement.dao.MarksDAO;
import com.project.reportcardmanagement.dao.impl.MarksDAOImpl;
import com.project.reportcardmanagement.model.Marks;
import com.project.reportcardmanagement.service.MarksService;

public class MarksServiceImpl implements MarksService {

    private MarksDAO dao = new MarksDAOImpl();

    public boolean addMarks(Marks m) throws Exception {
        return dao.addMarks(m);
    }

    public boolean updateMarks(Marks m) throws Exception {
        return dao.updateMarks(m);
    }

    public boolean deleteMarks(String studentId, String subjectCode) throws Exception {
        return dao.deleteMarks(studentId, subjectCode);
    }

    public List<Marks> getMarksByStudent(String studentId) throws Exception {
        return dao.getMarksByStudent(studentId);
    }
    public List<Marks> getAllMarks() throws Exception {
    	return dao.getAllMarks();
    }
}