package co.com.robin.food.model.diligencia;

import lombok.*;

@Data
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private long id;
    private String codigoUsuario;
    private String nombre;
    private String apellido;
}
