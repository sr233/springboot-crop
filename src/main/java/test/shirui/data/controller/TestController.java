package test.shirui.data.controller;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import test.shirui.data.model.TestModel;
import test.shirui.data.util.ModelStringConvert;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.List;

@RestController
@RequestMapping("/test")
@PropertySource("classpath:bootstrap.properties")
@Api("测试")
public class TestController {

    @Value("${test}")
    String t;

    @Autowired
    private TestModel testModel;

    @ApiOperation(notes = "test", value = "测试", httpMethod = "POST")
    @RequestMapping(value = "test", method = RequestMethod.POST)
    public Object test(@ApiParam("TestModel") @RequestBody String s) {
//        try {
        String t1 = t;
        String s1 = testModel.getName();
        return ModelStringConvert.stringToModel(s);
//            List<TestModel> testModels = new ModelStringConvert().stringToModelList(s, TestModel.class);
//            return testModels;
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
    }
}
