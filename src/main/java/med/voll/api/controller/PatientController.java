package med.voll.api.controller;

import med.voll.api.patient.PatientRecordData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PatientController {

    @PostMapping
    public void register(@RequestBody PatientRecordData datos) {
        System.out.println("datos recibidos: " + datos);
    }
}
