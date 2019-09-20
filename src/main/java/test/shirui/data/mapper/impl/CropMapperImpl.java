package test.shirui.data.mapper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.shirui.data.entity.CropEntity;
import test.shirui.data.mapper.ICropMapper;
import test.shirui.data.model.CropModel;

import java.util.ArrayList;
import java.util.List;

@Component
public class CropMapperImpl{


    public CropModel entityToModel(CropEntity cropEntity) {
        if(cropEntity == null) {
            return null;
        }
        CropModel cropModel = ICropMapper.INSTANCE.entityToModel(cropEntity);
        //url暂时考虑用；拼接
        String[] arr = cropEntity.getUrl().split(";");
        List<String> list = new ArrayList<String>();
        for(String s : arr) {
            list.add(s);
        }
        cropModel.setUrls(list);
        return cropModel;
    }

    public CropEntity modelToEntity(CropModel cropModel) {
        if(cropModel == null) {
            return null;
        }
        CropEntity cropEntity = ICropMapper.INSTANCE.modelToEntity(cropModel);
        cropEntity.setUrl(cropModel.getUrls().toString());
        return cropEntity;
    }

    public List<CropModel> entitiesToModels(List<CropEntity> cropEntities) {
        if(cropEntities == null) {
            return null;
        }
        List<CropModel> cropModels = new ArrayList<CropModel>();
        for(CropEntity cropEntity : cropEntities) {
            cropModels.add(this.entityToModel(cropEntity));
        }
        return cropModels;
    }

    public List<CropEntity> modelsToEntities(List<CropModel> cropModels) {
        if (cropModels == null) {
            return null;
        }
        List<CropEntity> cropEntities = new ArrayList<CropEntity>();
        for(CropModel cropModel : cropModels) {
            cropEntities.add(this.modelToEntity(cropModel));
        }
        return cropEntities;
    }


}
