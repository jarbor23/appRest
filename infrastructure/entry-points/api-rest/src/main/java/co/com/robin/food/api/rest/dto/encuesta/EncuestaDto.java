package co.com.robin.food.api.rest.dto.encuesta;

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
public class EncuestaDto {
    private long idEncuesta;
    @NotEmpty
    private String titulo;
    private String descripcion;
    @Valid
    private List<PreguntaAbiertaDto> listaPreguntasAbirtas ;
    @Valid
    private List<PreguntaCerradaDto> listaPreguntasCerradas;
}
