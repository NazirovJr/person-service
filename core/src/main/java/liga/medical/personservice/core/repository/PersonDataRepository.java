package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.PersonDataEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PersonDataRepository {

    @Select("select * from contact where id = #{personId}")
    PersonDataEntity findById(Long personId);

    @Insert("insert into person_data (last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id) " +
            "values(#{lastName}, #{firstName}, #{birthDt}, #{age}, #{sex}, #{contactId}, #{medicalCardId}, #{parentId})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
     int insert(PersonDataEntity personDataEntity);

    List<PersonDataEntity> findByIds(@Param("personIds") List<Long> personIds);

    int insertAll(@Param("personDataList") List<PersonDataEntity> personDataEntityList);

    Boolean updateById(@Param("personDataEntity") PersonDataEntity personDataEntity);

    Boolean deleteById(@Param("personId") Long personId);
}
