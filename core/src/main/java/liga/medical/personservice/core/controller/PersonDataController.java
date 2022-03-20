package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.PersonDataEntity;
import liga.medical.personservice.core.repository.PersonDataRepository;
import liga.medical.personservice.dto.PersonDataDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/person-data")
public class PersonDataController {

    //fixme в домашке здесь должен быть интерфейс сервиса
    @Autowired
    private PersonDataRepository personDataRepository;

    //fixme в домашке он должен быть бином
    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/save")
    void saveNewPersonData(@RequestBody @Valid PersonDataDto personData) {
        PersonDataEntity personDataEntity = modelMapper.map(personData, PersonDataEntity.class);
        personDataRepository.insert(personDataEntity);
    }

    @PostMapping("/save-all")
    void saveNewPersonData(@RequestBody @Valid List<PersonDataDto> personData) {
        List<PersonDataEntity> personDataEntityList = personData.stream()
                .map(el -> modelMapper.map(el, PersonDataEntity.class))
                .collect(Collectors.toList());
        personDataRepository.insertAll(personDataEntityList);
    }

    @GetMapping("/{id}")
    PersonDataDto getPersonDataById(@PathVariable Long id) {
        PersonDataEntity personDataEntity = personDataRepository.findById(id);
        return modelMapper.map(personDataEntity, PersonDataDto.class);
    }

    @GetMapping("")
    List<PersonDataDto> getPersonDataByIds(@RequestParam List<Long> ids) {
        List<PersonDataEntity> personData = personDataRepository.findByIds(ids);
        return personData.stream()
                .map(el -> modelMapper.map(el, PersonDataDto.class))
                .collect(Collectors.toList());
    }
}
