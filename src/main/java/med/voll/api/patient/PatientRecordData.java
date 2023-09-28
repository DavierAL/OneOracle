package med.voll.api.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.addres.AddresData;

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
