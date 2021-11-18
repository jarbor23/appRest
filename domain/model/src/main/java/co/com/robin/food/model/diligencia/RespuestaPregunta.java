package co.com.robin.food.model.diligencia;

import co.com.robin.food.model.pregunta.Pregunta;
import co.com.robin.food.model.respuesta.Respuesta;
import lombok.*;

@Data
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaPregunta {
    private Pregunta pregunta;
    private Respuesta respuesta;
}
