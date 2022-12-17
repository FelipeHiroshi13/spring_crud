package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.patient.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("patients")
public class PatientsController {

    @Autowired
    PacienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid DataRegisterPatient data, UriComponentsBuilder uriBuilder) {
        var patient =  new Patient(data);
        repository.save(patient);

        var uri = uriBuilder.path("/patients/{id}").buildAndExpand(patient.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataDetailPatient(patient));
    }

    @GetMapping
    public ResponseEntity<Page<DataListPatient>> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination){
        var page = repository.findAll(pagination).map(DataListPatient::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity showDetails(@PathVariable Long id){
        Patient patient = repository.getReferenceById(id);

        return ResponseEntity.ok(new DataDetailPatient(patient));
    }

}
