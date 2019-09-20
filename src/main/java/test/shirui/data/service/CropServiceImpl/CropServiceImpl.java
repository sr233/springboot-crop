package test.shirui.data.service.CropServiceImpl;

import com.corundumstudio.socketio.SocketIOClient;
import com.sun.scenario.effect.Crop;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.SQLQuery;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.util.StringUtils;
import test.shirui.data.entity.CropEntity;
import test.shirui.data.mapper.ICropMapper;
import test.shirui.data.mapper.impl.CropMapperImpl;
import test.shirui.data.model.CropCerteria;
import test.shirui.data.model.CropModel;
import test.shirui.data.repository.CropRepository;
import test.shirui.data.repository.impl.CropRepositoryImpl;
import test.shirui.data.service.ICropService;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
//@Lazy
public class CropServiceImpl implements ICropService {

    @Autowired
    private CropMapperImpl cropMapper;
    @Autowired
    private CropRepository cropRepository;
    @Autowired
    private CropRepositoryImpl cropRepositoryImpl;
    @Autowired
    private EntityManager em;
    @Autowired
    private NamedParameterJdbcTemplate nameJdbcTemplate;

    @Override
//    @Pointcut("execution()")
//    @Before("@annotation")
    public Map<String, Object> findAll(CropCerteria cropCerteria, Pageable pageable) {
        List<CropEntity> cropEntities = cropRepository.findAll();
//        List<CropEntity> cropEntities = cropRepositoryImpl.findAllByHealths(cropCerteria.getHealth());
        List<CropModel> cropModels = cropMapper.entitiesToModels(cropEntities);
        ICropMapper.INSTANCE.entitiesToModels(cropEntities);
        Map<String, Object> map = new HashMap<>();
        map.put("data", cropModels);
        map.put("msg", "查询成功");
        map.put("count", cropModels.size());
//        Query query = em.createNativeQuery("select * from crop");
//        query.unwrap(NativeQuery.class).setResultTransformer(Transformers.aliasToBean(Crop.class));
//        query.getResultList();
        return map;
    }

    @Override
    public Map<String, Object> findById(String id) {
        CropEntity cropEntity = cropRepository.findById(Integer.valueOf(id));
        CropModel cropModel = cropMapper.entityToModel(cropEntity);
        Map<String, Object> map = new HashMap<>();
        map.put("data", cropModel);
        map.put("msg", "查询成功");
        return map;
    }

    @Override
    @Transactional() //isolation=Isolation.REPEATABLE_READ Transactional.TxType.REQUIRED propagation=Propagation.REQUIRED
//    @Lock(LockModeType.PESSIMISTIC_READ)
//    @Lock(LockModeType.OPTIMISTIC)
    public Map<String, Object> deleteById(String id) {
        return null;
    }

    @Override
    public Map<String, Object> add(CropModel cropModel) {
        return null;
    }

    // 分页查询所有findAll(Specification, Pageable)
    private Specification<CropEntity> getSpecification(CropCerteria cropCerteria) {
        return new Specification<CropEntity>() {

            @Override
            public Predicate toPredicate(Root<CropEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                Predicate predicate = criteriaBuilder.conjunction();
                List<Expression<Boolean>> expressions = predicate.getExpressions();
                try{
                    if(!StringUtils.isEmpty(cropCerteria.getKeyWord())) {
//                        expressions.add()
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        };

    }

}
