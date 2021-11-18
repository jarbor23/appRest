package co.com.robin.food.model.pregunta;

import co.com.robin.food.model.respuesta.Respuesta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PreguntaCerrada extends Pregunta implements Serializable {
    private List<Respuesta> listadoRespuesta;

}
