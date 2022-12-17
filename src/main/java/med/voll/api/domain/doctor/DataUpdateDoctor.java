package med.voll.api.domain.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.adress.AdressData;

public record DataUpdateDoctor(
        @NotNull
        Long id,
        String name,
        String phone,
        AdressData adress) {
}
