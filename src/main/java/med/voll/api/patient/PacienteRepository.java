package med.voll.api.patient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Patient, Long> {
}
