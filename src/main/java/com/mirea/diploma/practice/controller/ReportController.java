package com.mirea.diploma.practice.controller;

import com.mirea.diploma.practice.dto.BlockDto;
import com.mirea.diploma.practice.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/versions/{versionId}/report")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    /**
     * Сгенерировать и скачать DOCX-отчет для указанной версии.
     */
    @GetMapping(value = "/docx", produces =
            "application/vnd.openxmlformats-officedocument.wordprocessingml.document")
    public ResponseEntity<byte[]> downloadReport(@PathVariable Long versionId) {
        try {
            byte[] docx = reportService.generateVersionReport(versionId);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(
                    ContentDisposition.attachment()
                            .filename("report_version_" + versionId + ".docx")
                            .build()
            );
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(docx);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
