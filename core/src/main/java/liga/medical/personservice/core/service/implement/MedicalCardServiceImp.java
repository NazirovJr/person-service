package liga.medical.personservice.core.service.implement;

import liga.medical.personservice.core.model.MedicalCardEntity;
import liga.medical.personservice.core.repository.MedicalCardRepository;
import liga.medical.personservice.core.service.interfaces.MedicalCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MedicalCardServiceImp implements MedicalCardService {

    private MedicalCardRepository medicalCardRepository;

    @Override
    public MedicalCardEntity findById(Long id) {
        log.info("Received id = " + id);
        return medicalCardRepository.findById(id);
    }

    @Override
    public int insert(MedicalCardEntity e) {
        log.info("Received medical card = " + e);
        return medicalCardRepository.insert(e);
    }

    @Override
    public List<MedicalCardEntity> findByIds(List<Long> e) {
        log.info("Received = " + e);
        return medicalCardRepository.findByIds(e);
    }

    @Override
    public int insertAll(List<MedicalCardEntity> eList) {
        log.info("Received medical card list = " + eList);
        return medicalCardRepository.insertAll(eList);
    }

    @Override
    public Boolean updateById(MedicalCardEntity e) {
        log.info("Received medical card = "  + e + "for update");
        return medicalCardRepository.updateById(e);
    }

    @Override
    public Boolean deleteById(Long id) {
        log.info("Received medical card id = " + id);
        return medicalCardRepository.deleteById(id);
    }
}
