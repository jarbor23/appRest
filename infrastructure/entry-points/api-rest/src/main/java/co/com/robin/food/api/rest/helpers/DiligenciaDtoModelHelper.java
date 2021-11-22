package co.com.robin.food.api.rest.helpers;

import co.com.robin.food.api.rest.dto.diligencia.DiligenciaDto;
import co.com.robin.food.api.rest.dto.diligencia.RespuestaPreguntaAbiertaDto;
import co.com.robin.food.api.rest.dto.diligencia.RespuestaPreguntaCerradaDto;
import co.com.robin.food.model.diligencia.Diligencia;
import co.com.robin.food.model.diligencia.RespuestaPregunta;
import co.com.robin.food.model.diligencia.Usuario;
import co.com.robin.food.model.encuesta.Encuesta;
import co.com.robin.food.model.pregunta.Pregunta;
import co.com.robin.food.model.respuesta.Respuesta;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DiligenciaDtoModelHelper {
    public static Diligencia buildDiligencia(DiligenciaDto dto ){
        return Diligencia.builder()
                .encuesta(addEncueta(dto))
                .usuario(addUsuario(dto))
                .respuestasDiligenciadas(addPreguntas(dto))
                .build();
    }
    public static Usuario addUsuario(DiligenciaDto dto){
        return Usuario.builder().codigoUsuario(dto.getUsuario()).apellido("apellido").build();
    }
    public static Encuesta addEncueta(DiligenciaDto dto){
        return Encuesta.builder().idEncuesta(dto.getIdEncuesta()).build();
    }
    public static List<RespuestaPregunta> addRespuestaPreguntaAbierta(List<RespuestaPreguntaAbiertaDto> listaDto){
        List<RespuestaPregunta>listaRespuesta= new ArrayList<>();
        for (RespuestaPreguntaAbiertaDto respuestaDto:listaDto
             ) {
            listaRespuesta.add(RespuestaPregunta.builder()
                            .pregunta(Pregunta.builder().idPregunta(respuestaDto.getIdPregunta()).build())
                    .respuesta(Respuesta.builder().descripcionRespuesta(respuestaDto.getRespuesta()).build()).build());
        }
        return listaRespuesta;
    }
    public static  List<RespuestaPregunta> addRespuestaPreguntaCerrada(List<RespuestaPreguntaCerradaDto> listaDto){
        List<RespuestaPregunta>listaRespuesta= new ArrayList<>();
        for (RespuestaPreguntaCerradaDto respuestaDto:listaDto
        ) {
            listaRespuesta.add(RespuestaPregunta.builder()
                            .pregunta(Pregunta.builder().idPregunta(respuestaDto.getIdPregunta()).build())
                            .respuesta(Respuesta.builder().idRespuesta(respuestaDto.getIdRespuesta()).build())
                    .build()
            );
        }
        return listaRespuesta;
    }
    public  static  List<RespuestaPregunta> addPreguntas(DiligenciaDto dto){
        return Stream.concat(addRespuestaPreguntaAbierta(dto.getListaRespuestasPreguntasAbirtas()).stream()
                        ,addRespuestaPreguntaCerrada(dto.getListaRespuestaPreguntaCerrada())
                                .stream())
                        .collect(Collectors.toList());
    }
}
