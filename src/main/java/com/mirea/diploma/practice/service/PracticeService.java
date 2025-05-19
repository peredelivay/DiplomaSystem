package com.mirea.diploma.practice.service;

import com.mirea.diploma.practice.dto.*;
import java.util.List;

public interface PracticeService {
    List<PracticeDto> listForStudent(Long studentId);
    PracticeDto createPractice(PracticeDto dto);

    PracticeDto updatePractice(Long id, PracticeDto dto);
    List<VersionDto> listVersions(Long practiceId);
    VersionDto createVersion(Long practiceId, VersionDto dto);
    List<BlockDto> listBlocks(Long versionId);
    BlockDto addBlock(Long versionId, BlockDto dto);
    ChangeStatusDto changeStatusOfPractice(Long pracId, ChangeStatusDto dto);

    CommentDto commentVersion(Long id, CommentDto dto);
}