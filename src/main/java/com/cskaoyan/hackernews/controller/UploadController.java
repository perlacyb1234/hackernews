package com.cskaoyan.hackernews.controller;

import com.cskaoyan.hackernews.service.AliUploadService;
import javafx.collections.ObservableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Cyb
 * Date 2019/4/11/011  Time 19:43
 */
@Controller
public class UploadController {
    @Autowired
    AliUploadService aliUploadService;
    @RequestMapping("uploadImage")
    @ResponseBody
    public Map uploadImage(MultipartFile file) throws IOException {
        /*String realPath = UploadController.class.getClassLoader().getResource("static").getPath();
        String filename = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String finalName = uuid+filename;*/
        /*int code = file.hashCode();
        int d1 = code & 0xf;//得到一级目录
        int d2 = 0;
        String path = "/"+d1;
        for (int i = 0; i <15 ; i++) {
            code = code>>>1;//无符号右移一位
            d2 = code & 0xf;//得到二级目录 最多可得到十六级目录,可以避免重名
            path += "/" + d2;
        }
        String dirPath = realPath + path;*/

        /*File directory = new File(realPath);
        if (!directory.exists()){
            directory.mkdirs();
        }
        String finalPath = realPath+ "/" +finalName;
        File newFile = new File(finalPath);
        newFile.createNewFile();
        file.transferTo(newFile);
        Map map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("msg","http://localhost:8080/" + finalName);*/
        String upload = aliUploadService.upload(file);
        Map map = new HashMap();
        map.put("code",0);
        map.put("msg",upload);
        return map;
    }
}
