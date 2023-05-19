package com.ssafy.enjoytrip.util;

import com.ssafy.enjoytrip.board.model.dto.UploadFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FileUtil {
    private final String rootPath = System.getProperty("user.dir");
    private final String uploadPath = rootPath + "/upload/";
    // 확장자 추출
    public static String getExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    // 파일 하나 들어왔을 떄
    public UploadFile storeFile(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) return null;
        String originalFilename = multipartFile.getOriginalFilename();
        String storeFilename = UUID.randomUUID() + "." + getExt(originalFilename);
        multipartFile.transferTo(new File(uploadPath + storeFilename));
        return new UploadFile(originalFilename, storeFilename);
    }

    // 파일 여러개 들어왔을 떄
    public List<UploadFile> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
        List<UploadFile> uploadFiles = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            if (multipartFile.isEmpty()) continue;
            uploadFiles.add(storeFile(multipartFile));
        }
        return uploadFiles;
    }
}
