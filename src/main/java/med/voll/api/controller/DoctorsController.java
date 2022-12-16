package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("doctors")
public class DoctorsController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DataRegisterDoctor data) {
        repository.save(new Doctor(data));
    }


    @GetMapping
    public Page<DataListDoctor> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination){
        return repository.findAllByActiveTrue(pagination).map(DataListDoctor::new);
    }

    @PutMapping
    @Transactional
    public void udpate(@RequestBody @Valid DataUpdateDoctor data){
        Doctor doctor = repository.getReferenceById(data.id());
        doctor.atualizarInformacoes(data);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void inactivate(@PathVariable Long id){
        Doctor doctor = repository.getReferenceById(id);
        doctor.inactivate();
    }

}
