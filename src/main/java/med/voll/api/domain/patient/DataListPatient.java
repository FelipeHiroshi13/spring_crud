package med.voll.api.domain.patient;

public record DataListPatient(
        String name,
        String email,
        String cpf
) {
    public DataListPatient(Patient patient){
        this(patient.getName(), patient.getEmail(), patient.getCpf());
    }
}
