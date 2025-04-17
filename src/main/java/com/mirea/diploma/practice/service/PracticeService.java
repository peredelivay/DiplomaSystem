package com.mirea.diploma.practice.service;

import com.mirea.diploma.practice.dto.PracticeReportDto;
import com.mirea.diploma.practice.model.PracticeReport;
import com.mirea.diploma.practice.model.PracticeVersion;
import com.mirea.diploma.practice.model.Block;
import java.util.List;

public interface PracticeService {
    List<PracticeReport> getAllPractices();
    PracticeReport createPractice(PracticeReportDto dto);
    PracticeReport submitPractice(Long id);
    PracticeVersion createVersion(Long reportId, PracticeVersion version);
    Block addBlock(Long versionId, Block block);
}
