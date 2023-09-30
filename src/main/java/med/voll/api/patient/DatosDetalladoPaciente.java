package med.voll.api.patient;

import med.voll.api.addres.AddresData;
import med.voll.api.addres.Direccion;

public record DatosDetalladoPaciente(String nombre, String email, String telefono, String documentoIdentidad, Direccion direccion) {
        public DatosDetalladoPaciente(Patient paciente) {
            this(paciente.getNombre(), paciente.getEmail(), paciente.getTelefono(), paciente.getDocumento(), paciente.getDireccion());
        }
    }

