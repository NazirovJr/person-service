package liga.medical.personservice.core.service.implement;

import liga.medical.personservice.core.model.AddressEntity;
import liga.medical.personservice.core.repository.AddressRepository;
import liga.medical.personservice.core.service.interfaces.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AddressServiceImp implements AddressService {


    private AddressRepository addressRepository;

    @Override
    public AddressEntity findById(Long id) {
        log.info("Received address id = " + id);
        return addressRepository.findById(id);
    }

    @Override
    public int insert(AddressEntity e) {
        log.info("Received address = " + e);
        return addressRepository.insert(e);
    }

    @Override
    public List<AddressEntity> findByIds(List<Long> e) {
        log.info("Received list of address = " + e);
        return addressRepository.findByIds(e);
    }

    @Override
    public int insertAll(List<AddressEntity> eList) {
        log.info("Received list of address for inserting = " + eList);
        return addressRepository.insertAll(eList);
    }

    @Override
    public Boolean updateById(AddressEntity e) {
        log.info("Received address for updating = " + e);
        return addressRepository.updateById(e);
    }

    @Override
    public Boolean deleteById(Long id) {
        log.info("Received address id for deleting" + id);
        return addressRepository.deleteById(id);
    }
}
