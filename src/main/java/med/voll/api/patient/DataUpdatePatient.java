package med.voll.api.patient;

import jakarta.validation.constraints.NotNull;
import med.voll.api.addres.AddresData;

public record DataUpdatePatient(@NotNull
                                Long id,
                                String nombre,
                                String telefono,
                                AddresData direccion) {

}
