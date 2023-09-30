package med.voll.api.domain.addres;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {

    private String calle;
    private Integer numero;
    private String complemento;
    private String distrito;
    private String ciudad;

    public Direccion(AddresData direccion) {
        this.calle = direccion.calle();
        this.numero = Integer.valueOf(direccion.numero());
        this.complemento = direccion.complemento();
        this.distrito = direccion.distrito();
        this.ciudad = direccion.ciudad();
    }

    public Direccion actualizarDatos(AddresData direccion) {
        this.calle = direccion.calle();
        this.numero = Integer.valueOf(direccion.numero());
        this.complemento = direccion.complemento();
        this.distrito = direccion.distrito();
        this.ciudad = direccion.ciudad();
        return this;
    }
}
