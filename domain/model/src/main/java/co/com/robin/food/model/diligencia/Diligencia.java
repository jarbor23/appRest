package co.com.robin.food.model.diligencia;

import co.com.robin.food.model.encuesta.Encuesta;
import lombok.*;

import java.util.List;

@Data
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Diligencia {
    private long idDiligencia;
    private Usuario usuario;
    private Encuesta encuesta;
    private List<RespuestaPregunta> respuestasDiligenciadas;

}
