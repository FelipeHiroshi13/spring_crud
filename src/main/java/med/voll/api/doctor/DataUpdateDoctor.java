package med.voll.api.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.adress.AdressData;

public record DataUpdateDoctor(
        @NotNull
        Long id,
        String name,
        String phone,
        AdressData adress) {
}
