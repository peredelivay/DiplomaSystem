package com.mirea.diploma.practice.service;

import com.mirea.diploma.practice.dto.BlockDto;
import com.mirea.diploma.practice.repository.BlockRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.util.Units;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final BlockRepository blockRepo;
    private final PracticeServiceImpl srv;
    /**
     * Считывает все блоки версии, сортирует по orderNumber и собирает DOCX.
     */
    public byte[] generateVersionReport(Long versionId) throws Exception {
        List<BlockDto> blocks = srv.listBlocks(versionId);

        try (XWPFDocument doc = new XWPFDocument();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            for (BlockDto block : blocks) {
                XWPFParagraph p = doc.createParagraph();
                XWPFRun run = p.createRun();
                p.setIndentationFirstLine(720);
                p.setSpacingBefore(0);
                p.setSpacingAfter(0);
                p.setSpacingBetween(1.5);
                p.setAlignment(ParagraphAlignment.BOTH);

                switch (block.getContentType()) {
                    case "TITLE1" -> {
                        p.setStyle("Heading1");
                        run.setBold(true);
                        run.setFontSize(14);
                        run.setFontFamily("Times New Roman");
                    }
                    case "TITLE2" -> {
                        p.setStyle("Heading2");
                        run.setBold(true);
                        run.setFontSize(14);
                        run.setFontFamily("Times New Roman");
                    }
                    case "TITLE3" -> {
                        p.setStyle("Heading3");
                        run.setBold(true);
                        run.setFontSize(14);
                    }
                    case "TEXT" -> {
                        p.setStyle("BodyText");
                        run.setFontSize(14);
                        run.setFontFamily("Times New Roman");
                    }
                    default -> {
                        p.setStyle("BodyText");
                        run.setFontSize(14);
                    }
                }

                run.setText(block.getContent());
            }

            doc.write(out);
            return out.toByteArray();
        }
    }
}
