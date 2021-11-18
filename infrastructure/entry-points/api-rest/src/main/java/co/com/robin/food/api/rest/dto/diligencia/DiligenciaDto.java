package co.com.robin.food.api.rest.dto.diligencia;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiligenciaDto {
    private long idDiligencia;
    private long idEcuesta;
    private String codigoUsuario;
    private List<RespuestaPreguntaAbiertaDto>  listaRespuestasPreguntasAbirtas;
    private List<RespuestaPreguntaCerradaDto> listaRespuestaPreguntaCerrada;

}
