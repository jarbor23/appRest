package co.com.robin.food.model.respuesta;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Respuesta implements Serializable {
    private long idRespuesta;
    private String descripcionRespuesta;
}
