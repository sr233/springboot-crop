package test.shirui.data.service.SpecialServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import test.shirui.data.service.FileUpDown;
import test.shirui.data.util.ThreadPoolManager;

import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileUpDownServiceImpl implements FileUpDown {

    @Value("${filePath}")
    private String filePath;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Map<String, Object> fileHandle(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("data", filePath);
        return map;
    }

    @Override
    public ResponseEntity downloadFile(String fileName) {
        return setFileDown(fileName);

    }

    public ResponseEntity<?> setFileDown(String fileName) {
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream bas = new ByteArrayOutputStream();
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(filePath + fileName));
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            int i = bufferedInputStream.read(buffer); // 将输入流读取的内容存储在字节数组中
            while (i != -1) {
                bas.write(buffer, 0, i); // 把buffer字节数组0-》i写到bas
                i = bufferedInputStream.read(buffer); // read方法有i++并返回
//                i = fileInputStream.read(buffer);
            }
            bas.flush();
            bufferedInputStream.close();
//            bas.close();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; fileName=" + URLEncoder.encode(fileName, "UTF-8"));
            return ResponseEntity.ok().headers(headers)
                    .contentLength(bas.toByteArray().length)
//                    .contentType(MediaType.parseMediaType(MediaType.APPLICATION_OCTET_STREAM_VALUE))
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(bas.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
