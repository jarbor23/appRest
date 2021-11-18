package co.com.robin.food.model.encuesta;

import co.com.robin.food.model.pregunta.Pregunta;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Encuesta implements Serializable {
    private long idEncuesta;
    private String titulo;
    private String descripcion;
    private List<Pregunta> listaPreguntas;

}
