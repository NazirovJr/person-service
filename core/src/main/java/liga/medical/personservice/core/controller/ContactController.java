package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.ContactEntity;
import liga.medical.personservice.core.model.MedicalCardEntity;
import liga.medical.personservice.core.repository.ContactRepository;
import liga.medical.personservice.core.repository.MedicalCardRepository;
import liga.medical.personservice.dto.ContactDto;
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
@RequestMapping("/contact")
public class ContactController {

    //fixme в домашке здесь должен быть интерфейс сервиса
    @Autowired
    private ContactRepository contactRepository;

    //fixme в домашке он должен быть бином
    private final ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/save")
    void saveNewContact(@RequestBody @Valid ContactDto contact) {
        ContactEntity contactEntity = modelMapper.map(contact, ContactEntity.class);
        contactRepository.insert(contactEntity);
    }

    @PostMapping("/save-all")
    void saveNewContact(@RequestBody @Valid List<ContactDto> contact) {
        List<ContactEntity> contactEntityList = contact.stream()
                .map(el -> modelMapper.map(el, ContactEntity.class))
                .collect(Collectors.toList());
        contactRepository.insertAll(contactEntityList);
    }


    @GetMapping("/{id}")
    ContactDto getContactById(@PathVariable Long id) {
        ContactEntity contact = contactRepository.findById(id);
        return modelMapper.map(contact, ContactDto.class);
    }


    @GetMapping("")
    List<ContactDto> getContactByIds(@RequestParam List<Long> ids) {
        List<ContactEntity> contact = contactRepository.findByIds(ids);
        return contact.stream()
                .map(el -> modelMapper.map(el, ContactDto.class))
                .collect(Collectors.toList());
    }
}
