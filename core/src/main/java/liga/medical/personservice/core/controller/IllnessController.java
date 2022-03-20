package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.IllnessEntity;
import liga.medical.personservice.core.repository.IllnessRepository;
import liga.medical.personservice.dto.IllnessDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/illness")
public class IllnessController {

    //fixme в домашке здесь должен быть интерфейс сервиса
    @Autowired
    private IllnessRepository illnessRepository;

    //fixme в домашке он должен быть бином
    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/save")
    void saveNewIllness(@RequestBody @Valid IllnessRepository illness) {
        IllnessEntity illnessEntity = modelMapper.map(illness, IllnessEntity.class);
        illnessRepository.insert(illnessEntity);
    }

    @PostMapping("/save-all")
    void saveNewIllness(@RequestBody @Valid List<IllnessDto> illness) {
        List<IllnessEntity> illnessEntityList = illness.stream()
                .map(el -> modelMapper.map(el, IllnessEntity.class))
                .collect(Collectors.toList());
        illnessRepository.insertAll(illnessEntityList);
    }

    @GetMapping("/{id}")
    IllnessDto getIllnessById(@PathVariable Long id) {
        IllnessEntity illness = illnessRepository.findById(id);
        return modelMapper.map(illness, IllnessDto.class);
    }

    @GetMapping("")
    List<IllnessDto> getIllnessByIds(@RequestParam List<Long> ids) {
        List<IllnessEntity> illness = illnessRepository.findByIds(ids);
        return illness.stream()
                .map(el -> modelMapper.map(el, IllnessDto.class))
                .collect(Collectors.toList());
    }
}
