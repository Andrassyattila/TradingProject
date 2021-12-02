package com.codecool.tradingproject.service;

import lombok.Lombok;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class AddPhotoService {
    @Value("${mailgun.adapter.send.url}")
    String defaultPath;

    private boolean isJobEnabled;

    //String defaultPath ="F:\\JAVASPRING\\el-proyecte-grande-prototype-general-Andrassyattila\\tradingproject\\src\\main\\resources\\static\\images\\products\\";

    public void saveImage(MultipartFile imageFile,Long id) throws Exception{
        String folder = defaultPath+id.toString();
        File pathAsFile = new File(folder);
        if(!Files.exists(Paths.get(folder))){
            pathAsFile.mkdir();
        }
        System.getenv("imagePath");
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder+ "\\" + imageFile.getOriginalFilename());
        System.out.println(path.toAbsolutePath());
        Files.write(path,bytes);
    }
}
