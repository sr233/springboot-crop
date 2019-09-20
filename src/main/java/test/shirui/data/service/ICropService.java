package test.shirui.data.service;

import org.springframework.data.domain.Pageable;
import test.shirui.data.model.CropCerteria;
import test.shirui.data.model.CropModel;

import java.util.List;
import java.util.Map;

public interface ICropService {

    public Map<String, Object> findAll(CropCerteria cropCerteria, Pageable pageable);//可条件，可分页，为空全查

    public Map<String, Object> findById(String id);

    public Map<String, Object> deleteById(String id);

    public Map<String, Object> add(CropModel cropModel);

}
