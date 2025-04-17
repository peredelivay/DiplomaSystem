package com.mirea.diploma.practice.service;

import com.mirea.diploma.practice.dto.PracticeReportDto;
import com.mirea.diploma.practice.model.PracticeReport;
import com.mirea.diploma.practice.model.PracticeVersion;
import com.mirea.diploma.practice.model.Block;
import com.mirea.diploma.practice.repository.PracticeReportRepository;
import com.mirea.diploma.practice.repository.PracticeVersionRepository;
import com.mirea.diploma.practice.repository.BlockRepository;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class PracticeServiceImpl implements PracticeService {
    private final PracticeReportRepository reportRepository;
    private final PracticeVersionRepository versionRepository;
    private final BlockRepository blockRepository;
    public PracticeServiceImpl(PracticeReportRepository reportRepository, PracticeVersionRepository versionRepository, BlockRepository blockRepository) {
        this.reportRepository = reportRepository;
        this.versionRepository = versionRepository;
        this.blockRepository = blockRepository;
    }
    @Override
    public List<PracticeReport> getAllPractices() {
        return reportRepository.findAll();
    }
    @Override
    public PracticeReport createPractice(PracticeReportDto dto) {
        PracticeReport report = new PracticeReport();
        report.setStudentId(dto.getStudentId());
        report.setSupervisorId(dto.getSupervisorId());
        report.setStatus("DRAFT");
        report.setCreatedAt(new Date());
        return reportRepository.save(report);
    }
    @Override
    public PracticeReport submitPractice(Long id) {
        PracticeReport report = reportRepository.findById(id).orElseThrow();
        report.setStatus("SUBMITTED");
        return reportRepository.save(report);
    }
    @Override
    public PracticeVersion createVersion(Long reportId, PracticeVersion version) {
        PracticeReport report = reportRepository.findById(reportId).orElseThrow();
        version.setPracticeReport(report);
        version.setCreatedAt(new Date());
        return versionRepository.save(version);
    }
    @Override
    public Block addBlock(Long versionId, Block block) {
        PracticeVersion version = versionRepository.findById(versionId).orElseThrow();
        block.setPracticeVersion(version);
        return blockRepository.save(block);
    }
}
