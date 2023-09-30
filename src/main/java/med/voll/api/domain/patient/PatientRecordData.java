package med.voll.api.domain.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.addres.AddresData;

public record PatientRecordData(
                                @NotBlank
                                String nombre,
                                @NotBlank
                                @Email
                                String email,
                                @NotBlank
                                String telefono,
                                @NotBlank
                                String documentoIdentidad,
                                @NotNull
                                @Valid
                                AddresData direccion) {

}
