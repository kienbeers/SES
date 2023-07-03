package com.ses.uploadfile.util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class MyUploadForm {
    private String decription;
    private MultipartFile[] fileDatas;

}
