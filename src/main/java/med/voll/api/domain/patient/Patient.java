package med.voll.api.domain.patient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.addres.Direccion;

@Table(name = "paciente")
@Entity(name = "Patient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String documento;
    private String telefono;
    private Boolean activo;

    @Embedded
    private Direccion direccion;

    public Patient(PatientRecordData datos) {
        this.activo = true;
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.documento = datos.documentoIdentidad();
        this.telefono = datos.telefono();
    }

    public void eliminar() {
    }
}
