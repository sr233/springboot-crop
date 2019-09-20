package test.shirui.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import test.shirui.data.model.CropModel;
import test.shirui.data.model.TestModel;

@Configuration
public class BeanTest {


//    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    @Bean
    public TestModel testModel() {
        TestModel testModel = new TestModel();
        testModel.setName("123");
        return testModel;
    }


    public static void main(String[] args) {
        System.out.println("1");
    }

}
