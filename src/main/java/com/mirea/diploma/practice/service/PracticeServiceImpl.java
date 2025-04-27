package com.mirea.diploma.practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mirea.diploma.practice.dto.*;
import com.mirea.diploma.practice.model.*;
import com.mirea.diploma.practice.repository.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PracticeServiceImpl implements PracticeService {
    private final PracticeRepository practiceRepo;
    private final VersionRepository versionRepo;
    private final BlockRepository blockRepo;

    @Override
    public List<PracticeDto> listForStudent(Long studentId) {
        return practiceRepo.findByStudentId(studentId).stream().map(p ->
                PracticeDto.builder()
                        .id(p.getId())
                        .studentId(p.getStudent().getId())
                        .practiceName(p.getPracticeName())
                        .versionsAmount(p.getVersionsAmount())
                        .lastModified(p.getLastModified())
                        .build()
        ).collect(Collectors.toList());
    }

    @Override
    public PracticeDto createPractice(PracticeDto dto) {
        Practice p = Practice.builder()
                .student(new com.mirea.diploma.auth.model.User() {{ setId(dto.getStudentId()); }})
                .practiceName(dto.getPracticeName())
                .versionsAmount(0)
                .lastModified(LocalDateTime.now())
                .build();
        Practice saved = practiceRepo.save(p);
        return dto.toBuilder().id(saved.getId()).build();
    }

    @Override
    public PracticeDto updatePractice(Long id, PracticeDto dto) {
        Practice p = practiceRepo.findById(id).orElseThrow();
        p.setPracticeName(dto.getPracticeName());
        p.setLastModified(LocalDateTime.now());
        Practice upd = practiceRepo.save(p);
        return dto.toBuilder().id(upd.getId()).lastModified(upd.getLastModified()).build();
    }

    @Override
    public List<VersionDto> listVersions(Long practiceId) {
        return versionRepo.findByPracticeIdOrderByVersionNumber(practiceId).stream().map(v ->
                VersionDto.builder()
                        .id(v.getId())
                        .versionNumber(v.getVersionNumber())
                        .uploadTime(v.getUploadTime())
                        .build()
        ).collect(Collectors.toList());
    }

    @Override
    public VersionDto createVersion(Long practiceId, VersionDto dto) {
        Practice p = practiceRepo.findById(practiceId).orElseThrow();
        Version v = Version.builder()
                .practice(p)
                .versionNumber(dto.getVersionNumber())
                .uploadTime(LocalDateTime.now())
                .build();
        Version saved = versionRepo.save(v);
        p.setVersionsAmount(p.getVersionsAmount() + 1);
        p.setLastModified(LocalDateTime.now());
        practiceRepo.save(p);
        return dto.toBuilder().id(saved.getId()).uploadTime(saved.getUploadTime()).build();
    }

    @Override
    public List<BlockDto> listBlocks(Long versionId) {
        return blockRepo.findByVersionIdOrderByOrderNumber(versionId).stream().map(b ->
                BlockDto.builder()
                        .id(b.getId())
                        .orderNumber(b.getOrderNumber())
                        .contentType(b.getContentType())
                        .content(b.getContent())
                        .build()
        ).collect(Collectors.toList());
    }

    @Override
    public BlockDto addBlock(Long versionId, BlockDto dto) {
        Version v = versionRepo.findById(versionId).orElseThrow();
        Block b = Block.builder()
                .version(v)
                .orderNumber(dto.getOrderNumber())
                .contentType(dto.getContentType())
                .content(dto.getContent())
                .build();
        Block saved = blockRepo.save(b);
        v.setUploadTime(LocalDateTime.now());
        versionRepo.save(v);
        return dto.toBuilder().id(saved.getId()).build();
    }
}