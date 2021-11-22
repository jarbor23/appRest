package co.com.robin.food.model.diligencia.gateways;

import co.com.robin.food.model.diligencia.RespuestaPregunta;

import java.util.List;

public interface RespuestaPreguntaRepository {
    List<RespuestaPregunta> addRespuestasApreguntas(List<RespuestaPregunta> listaRespuestasApreguntas);
}
