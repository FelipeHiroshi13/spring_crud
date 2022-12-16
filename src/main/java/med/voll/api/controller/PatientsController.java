package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.patient.DataRegisterPatient;
import med.voll.api.patient.DataListPatient;
import med.voll.api.patient.Patient;
import med.voll.api.patient.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patients")
public class PatientsController {

    @Autowired
    PacienteRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DataRegisterPatient data) {
        repository.save(new Patient(data));
    }

    @GetMapping
    public Page<DataListPatient> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination){
        return repository.findAll(pagination).map(DataListPatient::new);
    }
}
