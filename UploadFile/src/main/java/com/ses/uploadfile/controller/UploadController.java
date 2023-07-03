package com.ses.uploadfile.controller;

import com.ses.uploadfile.util.MyUploadForm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UploadController {

    @RequestMapping(value = "/")
    public String homePage() {
        return "index";
    }
    @GetMapping("/upload")
    public String uploadOneFileHandler(Model model) {
        MyUploadForm myUploadForm = new MyUploadForm();
        model.addAttribute("myUploadForm", myUploadForm);
        return "uploadOneFile";
    }
//    Xu ly up load
    @PostMapping("/upload")
    public String upLoadOneFile(Model model, HttpServletRequest request, @ModelAttribute("myUploadForm") MyUploadForm myUploadForm) {
        return this.doUpload(request, model, myUploadForm);
    }
    // GET: Hiển thị trang form upload
    @GetMapping("/uploadMultiFile")
    public String uploadMultiFileHandler(Model model) {
        MyUploadForm myUploadForm = new MyUploadForm();
        model.addAttribute("myUploadForm", myUploadForm);

        return "uploadMultiFile";
    }
    @PostMapping("/uploadMultiFile")
    public String uploadMultiFileHandlerPOST(HttpServletRequest request, //
                                             Model model, //
                                             @ModelAttribute("myUploadForm") MyUploadForm myUploadForm) {

        return this.doUpload(request, model, myUploadForm);

    }



    private String doUpload(HttpServletRequest request, Model model, MyUploadForm myUploadForm) {
        String decrip = myUploadForm.getDecription();
        //thư mục gốc
        String uploadRootPath = request.getServletContext().getRealPath("upload");
        System.out.println("uploadRootPath=" + uploadRootPath);
        File uploadRootDir = new File(uploadRootPath);
        if(!uploadRootDir.exists()) {
            uploadRootDir.mkdir();
        }
        MultipartFile[] fileDatas = myUploadForm.getFileDatas();
        List<File> uploadedFiles = new ArrayList<File>();
        List<String> failedFiles = new ArrayList<String>();

        for (MultipartFile fileData: fileDatas) {
            // Ten file goc
            String name = fileData.getOriginalFilename();
            System.out.println("Client file name: " + name);
            if(name != null && name.length() > 0) {
                try {
                    //Tao file server
                    File fileServer = new File(uploadRootDir.getAbsolutePath() + File.separator+ name);
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fileServer));
                    stream.write(fileData.getBytes());
                    stream.close();
                }catch (Exception e) {
                    System.out.println("Error write file" + name);
                    failedFiles.add(name);
                }
            }
        }
        model.addAttribute("description", decrip);
        model.addAttribute("uploadedFiles", uploadedFiles);
        model.addAttribute("failedFiles", failedFiles);
        return "uploadResult";

    }

}
