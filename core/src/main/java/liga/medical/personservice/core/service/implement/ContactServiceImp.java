package liga.medical.personservice.core.service.implement;

import liga.medical.personservice.core.model.ContactEntity;
import liga.medical.personservice.core.repository.ContactRepository;
import liga.medical.personservice.core.service.interfaces.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ContactServiceImp implements ContactService {

    private ContactRepository contactRepository;

    @Override
    public ContactEntity findById(Long id) {
        log.info("Received contact id = " + id);
        return contactRepository.findById(id);
    }

    @Override
    public int insert(ContactEntity e) {
        log.info("Received contact = " + e);
        return contactRepository.insert(e);
    }

    @Override
    public List<ContactEntity> findByIds(List<Long> e) {
        log.info("Received list of contact = " + e);
        return contactRepository.findByIds(e);
    }

    @Override
    public int insertAll(List<ContactEntity> eList) {
        log.info("Received list of contact for inserting = " + eList);
        return contactRepository.insertAll(eList);
    }

    @Override
    public Boolean updateById(ContactEntity e) {
        log.info("Received contact = " + e);
        return contactRepository.updateById(e);
    }

    @Override
    public Boolean deleteById(Long id) {
        log.info("Received contact id = " + id + "for deleting");
        return contactRepository.deleteById(id);
    }
}
