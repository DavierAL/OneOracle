package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.addres.Direccion;

@Table(name = "medico")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    private Boolean activo;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    @Embedded
    private Direccion direccion;

    public Medico(MedicalRecordData datosRegistroMedico) {
        this.activo = true;
        this.nombre = datosRegistroMedico.nombre();
        this.email = datosRegistroMedico.email();
        this.telefono = datosRegistroMedico.telefono();
        this.documento = datosRegistroMedico.documento();
        this.especialidad = datosRegistroMedico.especialidad();
        this.direccion = new Direccion(datosRegistroMedico.direccion());
    }

    public void actulizarDatos(UpdateMedicalData updateMedicalData) {
        if (updateMedicalData.nombre() != null) {
            this.nombre = updateMedicalData.nombre();
        }
        if (updateMedicalData.documento() != null) {
            this.documento = updateMedicalData.documento();
        }
        if (updateMedicalData.direccion() != null) {
            this.direccion = direccion.actualizarDatos(updateMedicalData.direccion());
        }
    }

    public void desactivarMedico() {
        this.activo = false;
    }
}
