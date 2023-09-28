package med.voll.api.medico;

import med.voll.api.addres.AddresData;

public record DataResponseMedico(Long id, String nombre, String email, String telefono, String documento,
                                 AddresData direccion) {
}
