package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Mapper
public interface RoleRepository {

    Optional<Role> findById(Long id);

    Set<Role> findByIds(List<Long> ids);

    Optional<Role> findByAuthority(String value);

    Set<Role> findAll();

    void insertAll(Set<Role> roles);
}
