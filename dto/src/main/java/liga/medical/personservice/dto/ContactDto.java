package liga.medical.personservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String email;

    private String profileLink;
}
