package liga.medical.personservice.core.service.implement;

import liga.medical.personservice.core.model.IllnessEntity;
import liga.medical.personservice.core.repository.IllnessRepository;
import liga.medical.personservice.core.service.interfaces.IllnessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class IllnessServiceImp implements IllnessService {

    private IllnessRepository illnessRepository;

    @Override
    public IllnessEntity findById(Long id) {
        log.info("Received illness id = " + id);
        return illnessRepository.findById(id);
    }

    @Override
    public int insert(IllnessEntity e) {
        log.info("Received illness = " + e);
        return illnessRepository.insert(e);
    }

    @Override
    public List<IllnessEntity> findByIds(List<Long> e) {
        log.info("Received list of illness = " + e);
        return illnessRepository.findByIds(e);
    }

    @Override
    public int insertAll(List<IllnessEntity> eList) {
        log.info("Received list of illness for insert = " + eList);
        return illnessRepository.insertAll(eList);
    }

    @Override
    public Boolean updateById(IllnessEntity e) {
        log.info("Received illness for update = " + e);
        return illnessRepository.updateById(e);
    }

    @Override
    public Boolean deleteById(Long id) {
        log.info("Received illness id for deleting = " + id);
        return illnessRepository.deleteById(id);
    }
}
