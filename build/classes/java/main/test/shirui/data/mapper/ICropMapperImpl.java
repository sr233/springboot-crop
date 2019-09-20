package test.shirui.data.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import test.shirui.data.entity.CropEntity;
import test.shirui.data.model.CropModel;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class ICropMapperImpl implements ICropMapper {

    @Override
    public CropEntity modelToEntity(CropModel model) {
        if ( model == null ) {
            return null;
        }

        CropEntity cropEntity = new CropEntity();

        cropEntity.setId( model.getId() );
        cropEntity.setName( model.getName() );
        cropEntity.setIntroduction( model.getIntroduction() );
        cropEntity.setFeature( model.getFeature() );
        cropEntity.setEnvironment( model.getEnvironment() );
        cropEntity.setLocation( model.getLocation() );
        cropEntity.setNutrition( model.getNutrition() );

        return cropEntity;
    }

    @Override
    public CropModel entityToModel(CropEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CropModel cropModel = new CropModel();

        cropModel.setId( entity.getId() );
        cropModel.setName( entity.getName() );
        cropModel.setIntroduction( entity.getIntroduction() );
        cropModel.setFeature( entity.getFeature() );
        cropModel.setEnvironment( entity.getEnvironment() );
        cropModel.setLocation( entity.getLocation() );
        cropModel.setNutrition( entity.getNutrition() );

        return cropModel;
    }

    @Override
    public List<CropEntity> modelsToEntities(List<CropModel> models) {
        if ( models == null ) {
            return null;
        }

        List<CropEntity> list = new ArrayList<CropEntity>();
        for ( CropModel cropModel : models ) {
            list.add( modelToEntity( cropModel ) );
        }

        return list;
    }

    @Override
    public List<CropModel> entitiesToModels(List<CropEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CropModel> list = new ArrayList<CropModel>();
        for ( CropEntity cropEntity : entities ) {
            list.add( entityToModel( cropEntity ) );
        }

        return list;
    }
}
