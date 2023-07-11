package com.ses.downloadfile.util;

import jakarta.servlet.ServletContext;
import org.springframework.http.MediaType;

public class MediaTypeUtil {
    public static MediaType getMediaTypeForFileName(ServletContext servletContext, String fileName) {
        String mineType = servletContext.getMimeType(fileName);

        try {
            MediaType mediaType = MediaType.parseMediaType(mineType);
            return mediaType;
        }catch (Exception e) {
            return MediaType.APPLICATION_OCTET_STREAM;
        }
    }
}
