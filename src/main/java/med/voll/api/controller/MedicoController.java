package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public void registrarMedico(@RequestBody @Valid MedicalRecordData datosRegistroMedico) {
        System.out.println("El request llega correctamente");
        medicoRepository.save(new Medico(datosRegistroMedico));
    }

    @GetMapping
    public Page<DataListMedico> listadoMedico(@PageableDefault(size = 20) Pageable paginacion) {
        //return medicoRepository.findAll(paginacion).map(DataListMedico::new);
        return medicoRepository.findByActivoTrue(paginacion).map(DataListMedico::new);
    }

    @PutMapping
    @Transactional
    public void actulizarMedico(@RequestBody @Valid UpdateMedicalData updateMedicalData) {
        Medico medico = medicoRepository.getReferenceById((updateMedicalData.id()));
        medico.actulizarDatos(updateMedicalData);
    }

    //DELETE LOGICO
    @DeleteMapping("/{id}")
    @Transactional
    public void deleteMedico(@PathVariable  Long id){
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desactivarMedico();
    }

    //DELETE EN BASE DE DATOS
    // @DeleteMapping("/{id}")
    // @Transactional
    //public void deleteMedico(@PathVariable  Long id){
    //   Medico medico = medicoRepository.getReferenceById(id);
    //     medicoRepository.delete(medico);
    //}
}
