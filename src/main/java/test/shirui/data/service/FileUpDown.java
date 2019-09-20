package test.shirui.data.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

public interface FileUpDown{

    public Map<String, Object> fileHandle(MultipartFile file);

    public ResponseEntity downloadFile(String fileName);
}