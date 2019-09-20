package test.shirui.data.controller;


import com.sun.scenario.effect.Crop;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import test.shirui.data.model.CropCerteria;
import test.shirui.data.service.FileUpDown;
import test.shirui.data.service.ICropService;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/crop")
//@Scope(value=WebApplicationContext.SCOPE_SESSION)
@Api("作物")
public class CropController {

    @Autowired
    private ICropService cropService;

    @Autowired
    private FileUpDown fileUpDown;

    @ApiOperation(value = "条件查询所有农作物", httpMethod = "POST")
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public Map<String, Object> findAll( @ApiParam(value = "description") @RequestBody CropCerteria model ) {
        return cropService.findAll(model, null);
    }

    @ApiOperation(value = "根据id查询作物信息", httpMethod = "GET")
    @ApiImplicitParam(paramType = "path", name = "id", value = "作物ID", required = true, dataType = "String")
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public Map<String, Object> findById(@PathVariable("id") String id) {
        return cropService.findById(id);
    }

    @ApiOperation(value = "上传文件", httpMethod = "POST")
    @CrossOrigin
    @RequestMapping(value = "/uploadFile", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    public Map<String, Object> uploadFile(@RequestBody MultipartFile file){
        try {
//            String fileName = file.getOriginalFilename();
            return fileUpDown.fileHandle(file);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> map = new HashMap<>();
            return map;
        }
    }

//    @RequestParam ?get方法
    @ApiOperation(value = "文件下载",httpMethod = "GET")
    @RequestMapping(value = "/download/{fileName}", method = RequestMethod.GET)
    public ResponseEntity<?> downloadFile(@PathVariable("fileName") String fileName) {
        return fileUpDown.downloadFile(fileName);

    }
}
