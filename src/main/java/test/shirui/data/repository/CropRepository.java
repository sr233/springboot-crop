package test.shirui.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.shirui.data.entity.CropEntity;

import java.util.List;
import java.util.Map;

@Repository
public interface CropRepository extends JpaRepository<CropEntity, String>, JpaSpecificationExecutor<CropEntity> {

//    @Query(value = "", nativeQuery = true)
//    List<CropEntity> findAllOrderByIdDesc();  整型貌似不能排序。。
    
    CropEntity findById(Integer id); //jpa规范字段名和实体统一

    String findNameById(String id);
}
