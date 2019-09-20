package test.shirui.data.test;

import com.alibaba.fastjson.JSON;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Value;
import test.shirui.data.controller.Test;
import test.shirui.data.model.TestModel;
import test.shirui.data.util.ModelStringConvert;
import test.shirui.data.util.ThreadPoolManager;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Test1 {


    public static void main(String[] args) throws Exception {
        try {
            TestModel testModel = ModelStringConvert.stringToModel1("{\"name\":\"111\"}", TestModel.class);
            System.out.println("11");
            Document document = new SAXReader().read(new File("D:\\Workplcae_Idea\\demo\\src\\main\\resources\\logback.xml"));
            Element element = document.getRootElement();
            element = element.element("appender").element("encoder").element("pattern");
            System.out.println(element.getText());
            for (int i=0; i<5; i++) {
                ThreadPoolManager.getInstance().addExecuteTask(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName());
                        System.out.println("1");
                    }
                });
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println("2");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
