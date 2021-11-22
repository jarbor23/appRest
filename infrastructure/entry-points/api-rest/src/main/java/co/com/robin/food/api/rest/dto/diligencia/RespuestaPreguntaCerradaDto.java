package co.com.robin.food.api.rest.dto.diligencia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class RespuestaPreguntaCerradaDto {
    private long idPregunta;
    @NotEmpty
    private long idRespuesta;
}
