package com.ses.downloadfile.controller;

import com.ses.downloadfile.util.MediaTypeUtil;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.http.HttpResponse;
import java.nio.file.Files;

@Controller
public class Example3Controller {
    private static final String DIRECTORY = "E:\\Test";
    private static final String DEFAUTL_FILE_NAME = "java-tutorial.pdf";

    @Autowired
    private ServletContext servletContext;

    @GetMapping("/download3")
    public void dowloadFile3(HttpServletResponse response, @RequestParam(defaultValue = DEFAUTL_FILE_NAME)String fileName) throws Exception {
        MediaType mediaType = MediaTypeUtil.getMediaTypeForFileName(this.servletContext, fileName);
        System.out.println("FileName" + fileName);
        System.out.println("mediaTipe" + mediaType);

        File file = new File(DIRECTORY + "/" + fileName);

        response.setContentType(mediaType.getType());

        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename" + fileName);
        response.setContentLength((int) file.length());

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
        byte[] buffer = new byte[1024];
        int bytesRead = 0;

        while((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        outputStream.flush();
        inputStream.close();
    }

}
