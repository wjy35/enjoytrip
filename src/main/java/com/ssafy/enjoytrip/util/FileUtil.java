package com.ssafy.enjoytrip.util;

import com.ssafy.enjoytrip.board.model.dto.FileInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
public class FileUtil {
    private static final String rootPath = System.getProperty("user.dir");
    private static final String uploadPath = rootPath + "/upload/";
    // 확장자 추출
    public static String getExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    // 파일 하나 들어왔을 떄
    public static FileInfo storeFile(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) return null;
        String originalFilename = multipartFile.getOriginalFilename();
        String storeFilename = UUID.randomUUID() + "." + getExt(originalFilename);
        log.info("storeFilename : {}", storeFilename , originalFilename);
        multipartFile.transferTo(new File(uploadPath + storeFilename));
        return new FileInfo(originalFilename, storeFilename, uploadPath + storeFilename);
    }

    // 파일 여러개 들어왔을 떄
    public static  List<FileInfo> storeFiles(List<MultipartFile> files) throws IOException {

        log.info("storeFiles : {}", files);
        List<FileInfo> fileInfos = new ArrayList<>();
        for (MultipartFile multipartFile : files) {
            if (multipartFile.isEmpty()) continue;
            fileInfos.add(storeFile(multipartFile));
        }
        return fileInfos;
    }
}
