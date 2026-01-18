package com.project.reportcardmanagement.service;

import com.project.reportcardmanagement.model.ReportCard;

public interface ReportCardService {

    // Generate report card for given student
    ReportCard generateReportCard(String studentId);
}