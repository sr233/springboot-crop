package test.shirui.data.util;

import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.corba.se.spi.ior.ObjectKey;
import test.shirui.data.controller.Test;
import test.shirui.data.model.CropModel;
import test.shirui.data.model.TestModel;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;


/**
 * 模型和字符串转换
 * 转模型时类反射
 */

public class ModelStringConvert {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String modelTOString(Object model) {
        String s = new Gson().toJson(model);
//        objectMapper.writeValueAsString(model);
        return s;
    }

    public static Object stringToModel(String s) {
        Object cropModel = new Gson().fromJson(s, Object.class);// 反序列化
        return cropModel;
    }

    public static <T> T stringToModel1(String s, Class<T> t) throws IOException {
        TypeFactory factory = objectMapper.getTypeFactory();
        JavaType objectOfT = factory.constructType(t);
        return objectMapper.readValue(s, objectOfT);
    }

    public <T> List<T> stringToModelList(String s, Class<T> t) throws IOException {
        TypeFactory factory = objectMapper.getTypeFactory();
        JavaType listOfT = factory.constructCollectionType(List.class, t);
        return objectMapper.readValue(s, listOfT);
    }
}
