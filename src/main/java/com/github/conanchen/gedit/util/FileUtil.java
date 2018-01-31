package com.github.conanchen.gedit.util;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ZhouZeshao on 2018/1/26.
 * 文件相关的操作类
 */
public class FileUtil {
    /**
     * 将文件夹显得所有文件获取出来,并将文件名获取存入一个list
     * @param strPath 需要处理的文件夹名称
     * @param filePrefix 获取文件的后缀名
     * @param flag 是否需要去除后缀
     * @return
     */
    public static List<String> getFileList(String strPath,String filePrefix,boolean flag) {
        List<String> filelist = new ArrayList<>();
        File dir = new File(strPath);
        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if (files[i].isDirectory()) { // 判断是文件还是文件夹
                    getFileList(files[i].getAbsolutePath(),filePrefix,flag); // 获取文件绝对路径
                } else if (fileName.endsWith(filePrefix)) { // 判断文件名是否以.json结尾
                    if(flag){
                        String prefix = fileName.substring(fileName.lastIndexOf("."));
                        filelist.add(fileName.substring(0,fileName.length() - prefix.length()));
                    }else{
                        filelist.add(fileName.toString());
                    }
                } else {
                    continue;
                }
            }

        }
        return filelist;
    }

    /**
     * 创建一个新文件文件,
     * 如果已有一个相同的文件
     * 则会删除旧文件，并新建
     * @param fileString 需要写入文件的内容
     * @param fileName 文件的名称
     * @param prefix 文件的后缀名(这里不会验证文件的后缀名是否正确,请注意。另外，这里需要'.'符号).
     * @param filePath 文件存储的绝对路径
     * @return
     */
    public static boolean createFile(String fileString, String fileName,String prefix,String filePath) {
        // 标记文件生成是否成功
        boolean flag = true;
        // 拼接文件完整路径
        String fullPath = filePath+fileName+prefix;
        // 生成json格式文件
        try {
            // 保证创建一个新文件
            File file = new File(fullPath);
            if (!file.getParentFile().exists()) { // 如果父目录不存在，创建父目录
                file.getParentFile().mkdirs();
            }
            if (file.exists()) { // 如果已存在,删除旧文件
                file.delete();
            }
            file.createNewFile();
            // 格式化json字符串,如果不需要请注释即可
//            jsonString = formatJson(jsonString);
            // 将格式化后的字符串写入文件
            Writer write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            write.write(fileString);
            write.flush();
            write.close();
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        // 返回是否成功的标记
        return flag;
    }

    /**
     * 获取文件的内容，暂时仅仅支持CSV文件
     * 这里会将文件的内容以map形式返回
     * @param filePath 文件的路径
     * @param num 需要经文件中该行数据的第几个值作为key,
     *            需要注意的是：如果文件中有key是重复的,那么可能会造成数据的覆盖
     * @return
     */
    public Map<String,String> getCSVFileToMap(String filePath,Integer num) throws IOException {
        Map<String,String> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        reader.readLine();//第一行信息，为标题信息，不用，如果需要，注释掉
        String line = null;
        while((line = reader.readLine()) != null) {
            String item[] = line.split("，");
            String last = item[item.length - 1];
            String[] cityStr = last.split(",");
            String key = cityStr[num];
            map.put(key,cityStr.toString());
        }
        return map;
    }
}
