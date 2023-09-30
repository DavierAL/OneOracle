package med.voll.api.controller;


import jakarta.validation.Valid;

import med.voll.api.patient.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid PatientRecordData datos, UriComponentsBuilder uriBuilder) {
        var paciente = new Patient(datos);
        repository.save(paciente);

        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalladoPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DataListPatient>> listar(@PageableDefault(size = 10, sort = {"nombre"})Pageable paginancion) {
        var page = repository.findAllByActivoTrue(paginancion).map(DataListPatient::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizar(@RequestBody @Valid DataUpdatePatient datos) {
        var paciente = repository.getReferenceById(datos.id());

        return ResponseEntity.ok(new DatosDetalladoPaciente(paciente));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity eliminar(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.eliminar();

        return ResponseEntity.noContent().build();
    }

    public ResponseEntity detallar(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        return  ResponseEntity.ok(new DatosDetalladoPaciente(paciente));
    }


}
