package co.com.robin.food.api.rest.dto.diligencia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class RespuestaPreguntaDto {
    private long idPregunta;
}
