package med.voll.api.adress;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Adress {

    private String street;
    private String neighborhood;
    private String zip;
    private String number;
    private String complement;
    private String city;
    private String postal;

    public Adress(AdressData adress) {
        this.street = adress.street();
        this.neighborhood = adress.neighborhood();
        this.zip = adress.zip();
        this.number = adress.number();
        this.complement = adress.complement();
        this.city = adress.city();
        this.postal = adress.postal();
    }

    public void atualizarInformacoes(AdressData dados) {
        if (dados.street() != null) {
            this.street = dados.street();
        }
        if (dados.neighborhood() != null) {
            this.neighborhood = dados.neighborhood();
        }
        if (dados.zip() != null) {
            this.zip = dados.zip();
        }
        if (dados.postal() != null) {
            this.postal = dados.postal();
        }
        if (dados.city() != null) {
            this.city = dados.city();
        }
        if (dados.number() != null) {
            this.number = dados.number();
        }
        if (dados.complement() != null) {
            this.complement = dados.complement();
        }
    }
}
