package co.com.robin.food.model.respuesta.gateways;

import co.com.robin.food.model.diligencia.RespuestaPregunta;

public interface RespuestaRepository {
    RespuestaPregunta createRespuesta(RespuestaPregunta respuesta);
}
