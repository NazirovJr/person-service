package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.AddressEntity;
import liga.medical.personservice.core.model.MedicalCardEntity;
import liga.medical.personservice.core.repository.AddressRepository;
import liga.medical.personservice.core.repository.MedicalCardRepository;
import liga.medical.personservice.dto.AddressDto;
import liga.medical.personservice.dto.MedicalCardDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/address")
public class AddressController {

    //fixme в домашке здесь должен быть интерфейс сервиса
    @Autowired
    private AddressRepository addressRepository;

    //fixme в домашке он должен быть бином
    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/save")
    void saveNewAddress(@RequestBody @Valid AddressRepository address) {
        AddressEntity addressEntity = modelMapper.map(address, AddressEntity.class);
        addressRepository.insert(addressEntity);
    }

    @PostMapping("/save-all")
    void saveNewAddress(@RequestBody @Valid List<AddressDto> address) {
        List<AddressEntity> addressEntityList = address.stream()
                .map(el -> modelMapper.map(el, AddressEntity.class))
                .collect(Collectors.toList());
        addressRepository.insertAll(addressEntityList);
    }

    @GetMapping("/{id}")
    AddressDto getAddressById(@PathVariable Long id) {
        AddressEntity address = addressRepository.findById(id);
        return modelMapper.map(address, AddressDto.class);
    }

    @GetMapping("")
    List<AddressDto> getAddressByIds(@RequestParam List<Long> ids) {
        List<AddressEntity> address = addressRepository.findByIds(ids);
        return address.stream()
                .map(el -> modelMapper.map(el, AddressDto.class))
                .collect(Collectors.toList());
    }
}
