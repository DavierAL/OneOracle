package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.addres.AddresData;

public record UpdateMedicalData(@NotNull Long id, String nombre, String documento, AddresData direccion) {

}
