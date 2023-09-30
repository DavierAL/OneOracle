package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.addres.AddresData;
import med.voll.api.domain.medico.*;
import med.voll.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public ResponseEntity<DataResponseMedico> registrarMedico(@RequestBody @Valid MedicalRecordData datosRegistroMedico,
                                          UriComponentsBuilder uriComponentsBuilder) {
        Medico medico = medicoRepository.save(new Medico(datosRegistroMedico));
        DataResponseMedico dataResponseMedico = new DataResponseMedico((medico.getId()), medico.getNombre(),
                medico.getEmail(), medico.getTelefono(), medico.getEspecialidad().toString(),
                new AddresData(medico.getDireccion().getCalle(),medico.getDireccion().getDistrito(),
                        medico.getDireccion().getCiudad(),medico.getDireccion().getNumero().toString(),
                        medico.getDireccion().getComplemento()));
        URI url = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(url).body(dataResponseMedico);
    }

    @GetMapping
    public ResponseEntity<Page<DataListMedico>>  listadoMedico(@PageableDefault(size = 20) Pageable paginacion) {
        //return medicoRepository.findAll(paginacion).map(DataListMedico::new);
        return ResponseEntity.ok(medicoRepository.findByActivoTrue(paginacion).map(DataListMedico::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actulizarMedico(@RequestBody @Valid UpdateMedicalData updateMedicalData) {
        Medico medico = medicoRepository.getReferenceById((updateMedicalData.id()));
        medico.actulizarDatos(updateMedicalData);
        return ResponseEntity.ok(new DataResponseMedico(medico.getId(), medico.getNombre(),
                medico.getEmail(), medico.getTelefono(), medico.getEspecialidad().toString(),
                new AddresData(medico.getDireccion().getCalle(),medico.getDireccion().getDistrito(),
                        medico.getDireccion().getCiudad(),medico.getDireccion().getNumero().toString(),
                        medico.getDireccion().getComplemento())));
    }

    //DELETE LOGICO
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteMedico(@PathVariable  Long id){
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desactivarMedico();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DataResponseMedico> retornaDatosMedico(@PathVariable  Long id){
        Medico medico = medicoRepository.getReferenceById(id);
        var datosMedico = new DataResponseMedico((medico.getId()), medico.getNombre(),
                medico.getEmail(), medico.getTelefono(), medico.getEspecialidad().toString(),
                new AddresData(medico.getDireccion().getCalle(),medico.getDireccion().getDistrito(),
                        medico.getDireccion().getCiudad(),medico.getDireccion().getNumero().toString(),
                        medico.getDireccion().getComplemento()));
        return ResponseEntity.ok(datosMedico);
    }
}
