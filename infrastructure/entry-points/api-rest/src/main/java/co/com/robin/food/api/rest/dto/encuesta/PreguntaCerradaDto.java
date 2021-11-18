package co.com.robin.food.api.rest.dto.encuesta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreguntaCerradaDto {
    private long idPregunta;
    @NotEmpty
    private String titulo;
    @NotEmpty
    @Valid
    @Size(min = 2)
    private List<RespuestaCerradaDto> listaRespuestasCerradas;
}
