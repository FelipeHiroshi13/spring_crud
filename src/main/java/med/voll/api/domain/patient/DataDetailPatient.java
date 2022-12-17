package med.voll.api.domain.patient;

public record DataDetailPatient(Long id, String name, String cpf, String email) {

    public DataDetailPatient(Patient patient){
        this(patient.getId(), patient.getName(), patient.getCpf(), patient.getEmail());
    }
}
