package med.voll.api.domain.patient;

import med.voll.api.domain.addres.Direccion;

public record DatosDetalladoPaciente(String nombre, String email, String telefono, String documentoIdentidad, Direccion direccion) {
        public DatosDetalladoPaciente(Patient paciente) {
            this(paciente.getNombre(), paciente.getEmail(), paciente.getTelefono(), paciente.getDocumento(), paciente.getDireccion());
        }
    }

