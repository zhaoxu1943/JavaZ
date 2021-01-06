package com.concentration.controller;


import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FireWallRestApIController {

    @Autowired
    private RestTemplate restTemplate;

    private static String url = "https://172.21.5.152:8080";

    @GetMapping(value = "/getcode")
    public String getCode() {
//        template.getForObject("https://172.21.5.152:8080/image.php",String.class);
         String str = restTemplate.getForObject(url+"/image.php",String.class);
        return str.substring(str.length()-4,str.length());
        //String sessionId =
    }
//
//    @PostMapping(value = "/gettoken")
//    public String getToken(@Param("username")String username,@Param("password") String password
//            @Param){
//        String userName = "superman";
//        String passWord = "zGstbPV+//sqzQNXT+zHWg==";
//        String code = getCode();
//        String passWordLength = "6";
//        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
//        HttpHeaders headers = new HttpHeaders();
//        map.add("name", userName);
//        map.add("code",code);
//        map.add("password",passWord);
//        map.add("pwdlen",passWordLength);
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
//
//        ResponseEntity<String> response = restTemplate.postForEntity(url,request,String.class);
//        return response.getBody();
//
//
//    }

}
