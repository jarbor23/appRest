package co.com.robin.food.model.pregunta;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
public  class Pregunta implements Serializable {
    private long idPregunta;
    private String titulo;
    private String descripcion;
}
