package liga.medical.personservice.core.service.implement;

import liga.medical.personservice.core.model.PersonDataEntity;
import liga.medical.personservice.core.repository.PersonDataRepository;
import liga.medical.personservice.core.service.interfaces.PersonDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonDataServiceImp implements PersonDataService {

    private PersonDataRepository personDataRepository;

    @Override
    public PersonDataEntity findById(Long id) {
        log.info("Received id = " + id);
        return personDataRepository.findById(id);
    }

    @Override
    public int insert(PersonDataEntity e) {
        log.info("Received person data =  " + e);
        return personDataRepository.insert(e);
    }

    @Override
    public List<PersonDataEntity> findByIds(List<Long> e) {
        log.info("Received = " + e);
        return personDataRepository.findByIds(e);
    }

    @Override
    public int insertAll(List<PersonDataEntity> eList) {
        log.info("Received person data list = " + eList);
        return personDataRepository.insertAll(eList);
    }

    @Override
    public Boolean updateById(PersonDataEntity e) {
        log.info("Received = " + e);
        return personDataRepository.updateById(e);
    }

    @Override
    public Boolean deleteById(Long id) {
        log.info("Received id = " + id);
        return personDataRepository.deleteById(id);
    }

    @Override
    public PersonDataEntity loadUserByUsername(String s) {
        return personDataRepository.findByEmail(s)
                .orElseThrow(() -> new UsernameNotFoundException(s));
    }

    @Override
    public boolean isExists(String email) {
        return personDataRepository.findByEmail(email)
                .isPresent();
    }
}
