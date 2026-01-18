package com.project.reportcardmanagement.service.impl;

import java.util.List;
import com.project.reportcardmanagement.dao.SubjectDAO;
import com.project.reportcardmanagement.dao.impl.SubjectDAOImpl;
import com.project.reportcardmanagement.model.Subject;
import com.project.reportcardmanagement.service.SubjectService;

public class SubjectServiceImpl implements SubjectService {

    private SubjectDAO dao = new SubjectDAOImpl();

    @Override
    public boolean addSubject(Subject s) throws Exception {
        return dao.addSubject(s);
    }

    @Override
    public boolean updateSubject(Subject s) throws Exception {
        return dao.updateSubject(s);
    }

    @Override
    public boolean deleteSubject(String subjectCode) throws Exception {
        return dao.deleteSubject(subjectCode);
    }

    @Override
    public Subject getSubjectByCode(String subjectCode) throws Exception {
        return dao.getSubjectByCode(subjectCode);
    }

    @Override
    public List<Subject> getAllSubjects() throws Exception {
        return dao.getAllSubjects();
    }
}