package co.com.robin.food.model.pregunta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class PreguntaAbierta extends Pregunta implements Serializable {
    int tamanoRespuesta;
}
