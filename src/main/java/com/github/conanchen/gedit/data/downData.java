package com.github.conanchen.gedit.data;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhouZeshao on 2018/1/26.
 */
public class downData {
    public static void main(String[] args) throws IOException {
        String path = "D:/workspace/gedit-cloud-district/src/main/java/com/github/conanchen/gedit/data/";
        BufferedReader reader = new BufferedReader(new FileReader("D:/workspace/gedit-cloud-district/src/main/java/com/github/conanchen/gedit/data/district.csv"));//换成你的文件名
        reader.readLine();//第一行信息，为标题信息，不用，如果需要，注释掉
        String line = null;
        List<String> codeList = new ArrayList<>();
//        List<String> fileLis = getFileList(path);
//        System.out.println(fileLis);
//        while((line = reader.readLine()) != null) {
//            String item[] = line.split("，");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
//            String last = item[item.length - 1];//这就是你要的数据了
//            System.out.println(last);
//            String[] cityStr = last.split(",");
//            String adcode = cityStr[1];
//            codeList.add(adcode);
//            System.out.println(adcode);
//            String url = "https://restapi.amap.com/v3/config/district?keywords="+adcode+"&subdistrict=1&key=dc0b8c635b9ea4c1bd0d35716fd01f96";
//            String jsonString;
//            try{
//                jsonString = doGet(url);
//            }catch (Exception e){
//                break;
//            }
//            try {Thread.sleep(500);} catch (InterruptedException e) {}
//            JsonObject returnData = new JsonParser().parse(jsonString).getAsJsonObject();
//            if(!returnData.get("status").equals("1") && !returnData.get("info").equals("ok")){
//                System.out.println("the error is :"+returnData.get("info")+", the last adcode:" + adcode);
//            }
//            boolean flag = createJsonFile( jsonString, adcode);
//            if(flag){
//                System.out.println("json file create result:"+flag);
//            }
//        }
    }



}
