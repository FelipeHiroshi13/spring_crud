package med.voll.api.domain.adress;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AdressData(
        @NotBlank
        String street,
        @NotBlank
        String neighborhood,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String zip,
        @NotBlank
        String city,
        @NotBlank
        String postal,
        String complement,
        String number) {


}
