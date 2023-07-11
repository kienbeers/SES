package com.ses.downloadfile.controller;

import com.ses.downloadfile.util.MediaTypeUtil;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class Example1Controller {
    private  static final String DIRECTORY = "E:\\Test";
    private static final String DEFAULT_FILE_NAME = "java-tutorial.pdf";

    @Autowired
    private ServletContext servletContext;

    @RequestMapping("/download1")
    public ResponseEntity<InputStreamResource> downloadFile1(
            @RequestParam(defaultValue = DEFAULT_FILE_NAME) String fileName
    ) throws IOException {
        MediaType mediaType = MediaTypeUtil.getMediaTypeForFileName(this.servletContext , fileName);
        System.out.println("fileName: " + fileName);
        System.out.println("mediaType: " + mediaType);

        File file = new File(DIRECTORY + "/" + fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok().
                header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                        .contentType(mediaType)
                .contentLength(file.length()).body(resource);
    }
}
