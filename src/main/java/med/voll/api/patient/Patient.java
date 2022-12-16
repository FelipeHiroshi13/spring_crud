package med.voll.api.patient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.adress.Adress;

@Table (name = "patients")
@Entity (name = "patients")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String cpf;

    @Embedded
    private Adress adress;

    public Patient(DataRegisterPatient dados) {
        this.name = dados.name();
        this.email = dados.email();
        this.phone = dados.phone();
        this.cpf = dados.cpf();
        this.adress = new Adress(dados.adress());
    }
}
