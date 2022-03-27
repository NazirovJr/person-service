package liga.medical.personservice.core.service.interfaces;

import liga.medical.personservice.core.model.PersonDataEntity;
import liga.medical.personservice.core.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public interface PersonDataService extends AbstractService<PersonDataEntity> {

    PersonDataEntity loadUserByUsername(String s);

    boolean isExists(String email);
}
