package com.ses.downloadfile.controller;

import com.ses.downloadfile.util.MediaTypeUtil;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class Example2Controller {
    private  static final String DIRECTORY = "E:\\Test";
    private static final String DEFAULT_FILE_NAME = "java-tutorial.pdf";

    @Autowired
    private ServletContext servletContext;

    @GetMapping("download2")
    public ResponseEntity<ByteArrayResource> dowloadFile2(
            @RequestParam(defaultValue = DEFAULT_FILE_NAME) String fileName) throws IOException {
        MediaType mediaType = MediaTypeUtil.getMediaTypeForFileName(this.servletContext, fileName);
        System.out.println("fileName: " + fileName);
        System.out.println("mediaType: " + mediaType);

        Path path = Paths.get(DIRECTORY + "/" + DEFAULT_FILE_NAME);
        byte[] data = Files.readAllBytes(path);
        ByteArrayResource resource = new ByteArrayResource(data);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" +
                        path.getFileName().toString())
                .contentType(mediaType)
                .contentLength(data.length).body(resource);
    }

}
