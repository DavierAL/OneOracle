package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.addres.AddresData;

public record UpdateMedicalData(@NotNull Long id, String nombre, String documento, AddresData direccion) {

}
