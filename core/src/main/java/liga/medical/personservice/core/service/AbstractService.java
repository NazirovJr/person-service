package liga.medical.personservice.core.service;


import java.util.List;

public interface AbstractService<Entity> {

    Entity findById(Long id);

    int insert(Entity e);

    List<Entity> findByIds(List<Long> e);

    int insertAll(List<Entity> eList) ;

    Boolean updateById(Entity e);

    Boolean deleteById(Long id);


}
