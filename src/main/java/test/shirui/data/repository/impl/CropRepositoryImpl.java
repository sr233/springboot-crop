package test.shirui.data.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import test.shirui.data.entity.CropEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CropRepositoryImpl {

    @Autowired
    private NamedParameterJdbcTemplate  namedParameterJdbcTemplate;

    public List<CropEntity> findAllByHealths(List<String> healths) {
        StringBuffer sb = new StringBuffer();
        sb.append("select c.id_crop as id,name_crop as name,intro as introduction,feature,url,envir as environment,location,nutrition \n" +
                "from crop c\n" +
                "where c.id_health in");
        if(healths.size() == 0) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("healths", healths);
        sb.append("(select k.id_health from kind_health k where name in (:healths))");
        List<CropEntity> cropEntities = namedParameterJdbcTemplate.query(sb.toString(), map, new BeanPropertyRowMapper<CropEntity>(CropEntity.class));
        return cropEntities; // NamedParameterJdbcTemplate的查询，查询出的属性量应小于等于实体属性
    }
}
