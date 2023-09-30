package med.voll.api.domain.medico;

import med.voll.api.domain.addres.AddresData;

public record DataResponseMedico(Long id, String nombre, String email, String telefono, String documento,
                                 AddresData direccion) {
}
