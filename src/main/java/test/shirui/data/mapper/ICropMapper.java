package test.shirui.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import test.shirui.data.entity.CropEntity;
import test.shirui.data.model.CropModel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICropMapper extends IBaseMapper<CropModel, CropEntity> {

//    @Mapping(target = "", source = "")
/*    CropModel entityToModel(CropEntity cropEntity);

    CropEntity modelToEntity(CropModel cropModel);

    List<CropModel> entitiesToModels(List<CropEntity> cropEntities);

    List<CropEntity> modelsToEntities(List<CropModel> cropModels);*/

    ICropMapper INSTANCE = Mappers.getMapper(ICropMapper.class);

}
