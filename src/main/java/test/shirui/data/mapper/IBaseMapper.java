package test.shirui.data.mapper;

import java.util.List;

public interface IBaseMapper<M, E> {

    E modelToEntity(M model);

    M entityToModel(E entity);

    List<E> modelsToEntities(List<M> models);

    List<M> entitiesToModels(List<E> entities);

}
