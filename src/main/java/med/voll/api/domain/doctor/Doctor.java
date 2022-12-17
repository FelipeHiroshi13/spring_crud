package med.voll.api.domain.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.adress.Adress;

@Table (name = "doctors")
@Entity (name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    @Embedded
    private Adress adress;

    private Boolean active;


    public Doctor(DataRegisterDoctor data) {
        this.active = true;
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.crm = data.crm();
        this.speciality = data.speciality();
        this.adress =  new Adress(data.adress());
    }

    public void atualizarInformacoes(DataUpdateDoctor data) {
        if(data.name() != null){
            this.name = data.name();
        }
        if(data.phone() != null){
            this.name = data.phone();
        }
        if(data.adress() != null){
            this.adress.atualizarInformacoes(data.adress());
        }
    }

    public void inactivate() {
        this.active = false;
    }
}
