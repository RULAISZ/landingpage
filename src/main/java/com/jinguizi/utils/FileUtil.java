package com.jinguizi.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @Title: landingpage
 * @description:
 * @Author: liuzhiwen
 * @Create: 2021-02-08 15:53
 **/
public class FileUtil {
    // An highlighted block
    public static void approvalFile(MultipartFile filecontent, String fileName, String path) {
        OutputStream os = null;
        InputStream inputStream = null;
        try {
            inputStream = filecontent.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // 2、保存到临时文件
            // 1K的数据缓冲
            byte[] bs = new byte[10240];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件
            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            String uploadDir = tempFile.getPath() + File.separator + fileName;
            os = new FileOutputStream(uploadDir);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
