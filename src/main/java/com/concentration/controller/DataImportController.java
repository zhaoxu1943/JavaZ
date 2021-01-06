package com.concentration.controller;

import com.concentration.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxu
 * @className DataImportController
 * @projectName JavaConcentration
 * @date 2020/4/28 10:20
 */
@Controller
public class DataImportController {


    @PostMapping("/import/jdbc")
    @ResponseBody
    //@ResponseBody的作用是在返回时,将java对象转为json格式的数据
    public List<Object> jdbcImport(@RequestParam("file") MultipartFile file) throws Exception {
        BufferedReader br;
        List<Object> result = new ArrayList<>();
        if(!FileUtil.isSqlFile(file.getOriginalFilename())){
            result.add("非sql文件!");
        }

        try {
            String line;
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                result.add(line);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


        return result;

    }
}
