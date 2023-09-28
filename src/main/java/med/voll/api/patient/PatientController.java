package med.voll.api.patient;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

public class PatientController {

    @Autowired
    private PatientRepository repository;

    public  void register(@RequestBody @Valid PatientRecordData datos) {
        repository.save(new Patient(datos));
    }
}
