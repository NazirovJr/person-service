package liga.medical.personservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    @NotBlank
    private Long contactId;

    @NotBlank
    private Long countryId;

    @NotBlank
    private String city;

    @NotBlank
    private Integer index;

    private String street;

    private String building;

    private String flat;

}
