package co.com.robin.food.api.rest.dto.diligencia;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiligenciaDto {
    private long idDiligencia;

    @NotEmpty
    private long idEncuesta;

    @NotEmpty
    private String usuario;
    @Valid
    private List<RespuestaPreguntaAbiertaDto>  listaRespuestasPreguntasAbirtas;
    @Valid
    private List<RespuestaPreguntaCerradaDto> listaRespuestaPreguntaCerrada;

}
