package med.voll.api.domain.patient;

public record DataListPatient(Long id, String nombre, String email, String documento) {

    public DataListPatient(Patient patient) {
        this(patient.getId(), patient.getNombre(), patient.getEmail(), patient.getDocumento());
    }
}
