package com.summer.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class FileUploadController {
    SimpleDateFormat sdf = new SimpleDateFormat("yyy/MM/dd/");
    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest req){
        //规划上传文件的保存路径为项目运行目录下的uploadFile文件夹，并在文件夹中通过日期对上传文件归类保存
        String realPath = req.getSession().getServletContext().getRealPath("/uploadFile");
        String format = sdf.format(new Date());
        File folder = new File(realPath+format);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
        //对文件进行重命名，避免文件重名
        String oldName = uploadFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."),oldName.length());
        try{
            //文件的保存操作
            uploadFile.transferTo(new File(folder,newName));
            //生成文件访问路径
            String filePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+"/uploadFile"+format+newName;
            return filePath;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "上传失败";
    }
}
