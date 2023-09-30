package med.voll.api.domain.patient;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.addres.AddresData;

public record DataUpdatePatient(@NotNull
                                Long id,
                                String nombre,
                                String telefono,
                                AddresData direccion) {

}
