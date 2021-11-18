package co.com.robin.food.api.rest.dto.encuesta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RespuestaCerradaDto {
    @NotEmpty
    private String descripcionRespuesta;
    private long idRepuesta;
}
