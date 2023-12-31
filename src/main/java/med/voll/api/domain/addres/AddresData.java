package med.voll.api.domain.addres;

import jakarta.validation.constraints.NotBlank;

public record AddresData(
                         @NotBlank
                         String calle,
                         @NotBlank
                         String distrito,
                         @NotBlank
                         String ciudad,
                         @NotBlank
                         String numero,
                         @NotBlank
                         String complemento) {

}
