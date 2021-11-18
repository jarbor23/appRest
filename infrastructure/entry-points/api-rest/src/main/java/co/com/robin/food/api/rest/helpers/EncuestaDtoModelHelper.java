package co.com.robin.food.api.rest.helpers;

import co.com.robin.food.api.rest.dto.encuesta.EncuestaDto;
import co.com.robin.food.api.rest.dto.encuesta.PreguntaAbiertaDto;
import co.com.robin.food.api.rest.dto.encuesta.PreguntaCerradaDto;
import co.com.robin.food.api.rest.dto.encuesta.RespuestaCerradaDto;
import co.com.robin.food.model.encuesta.*;
import co.com.robin.food.model.pregunta.Pregunta;
import co.com.robin.food.model.pregunta.PreguntaAbierta;
import co.com.robin.food.model.pregunta.PreguntaCerrada;
import co.com.robin.food.model.respuesta.Respuesta;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class EncuestaDtoModelHelper {
    public static List<Pregunta> listaAbiertas(List<PreguntaAbiertaDto> preguntasAbi){
        List<Pregunta> preguntas=new ArrayList<>();
        for (PreguntaAbiertaDto preguntaAbiertoDto:
                preguntasAbi
        ) {
            preguntas.add(PreguntaAbierta.builder().idPregunta(preguntaAbiertoDto
                            .getIdPregunta())
                    .titulo(preguntaAbiertoDto.getTitulo())
                    .descripcion("pregunta abierta")
                    .tamanoRespuesta(100)
                    .build());
        }
        return preguntas;
    }
    public static List<PreguntaAbiertaDto> listaAbiertasDto(List<Pregunta> preguntasAbi){
        List<PreguntaAbiertaDto> preguntas=new ArrayList<>();
        for (Pregunta pregunta:
                preguntasAbi
        ) {
            if(pregunta instanceof PreguntaAbierta ){
                preguntas.add(PreguntaAbiertaDto.builder().idPregunta(pregunta.getIdPregunta())
                        .titulo(pregunta.getTitulo())
                        .build());
            }

        }
        return preguntas;
    }
    public static List<Pregunta> listaCerrada(List<PreguntaCerradaDto> preguntasCerradas){
        List<Pregunta> preguntas=new ArrayList<>();
        for (PreguntaCerradaDto preguntaCerrada:
                preguntasCerradas
        ) {
            List<Respuesta> respuestas =
                    listaRespuestasCerradas(preguntaCerrada.getListaRespuestasCerradas());
            preguntas.add(PreguntaCerrada.builder()
                    .listadoRespuesta(respuestas)
                    .idPregunta(preguntaCerrada.getIdPregunta())
                    .titulo(preguntaCerrada.getTitulo())
                    .descripcion("pregunta Cerrada")
                    .build());


        }
        return preguntas;
    }
    public static List<PreguntaCerradaDto> listaCerradaDto(List<Pregunta> preguntasCerradas){
        List<PreguntaCerradaDto> preguntasCerrada=new ArrayList<>();
        for (Pregunta pregunta:
                preguntasCerradas
        ) {
            if(pregunta instanceof PreguntaCerrada ){
                preguntasCerrada.add(PreguntaCerradaDto.builder().idPregunta(pregunta.getIdPregunta())
                        .titulo(pregunta.getTitulo())
                        .listaRespuestasCerradas(listaRespuestasCerradasDto(((PreguntaCerrada) pregunta).getListadoRespuesta()))
                        .build());
            }

        }
        return preguntasCerrada;
    }
    public static List<Respuesta> listaRespuestasCerradas
            (List<RespuestaCerradaDto> resCerradas){
        List<Respuesta> respuestas =new ArrayList<>();
        for (RespuestaCerradaDto res :
                resCerradas) {

            respuestas.add(Respuesta.builder().
                    descripcionRespuesta(res.getDescripcionRespuesta()).build());
        }
        return respuestas;
    }
    public static List<RespuestaCerradaDto> listaRespuestasCerradasDto
            (List<Respuesta> resCerradas){
        List<RespuestaCerradaDto> respuestaCerradas =new ArrayList<>();
        for (Respuesta res :
                resCerradas) {

            respuestaCerradas.add(RespuestaCerradaDto.builder()
                    .idRepuesta(res.getIdRespuesta())
                    .descripcionRespuesta(res.getDescripcionRespuesta()).build());
        }
        return respuestaCerradas;
    }
    public static Encuesta createModelEncuesta(EncuestaDto encuestaDto) {

        return Encuesta.builder().titulo(encuestaDto.getTitulo()).descripcion(encuestaDto.getDescripcion())
                .listaPreguntas(Stream.concat(
                                listaAbiertas(encuestaDto.getListaPreguntasAbirtas()).stream(),
                                listaCerrada(encuestaDto.getListaPreguntasCerradas()).stream()
                         )
                        .collect(Collectors.toList())).build();

    }
    public static EncuestaDto createDtoEncuesta(Encuesta encuesta){
        return EncuestaDto.builder().idEncuesta(encuesta.getIdEncuesta())
                .titulo(encuesta.getTitulo())
                .descripcion(encuesta.getDescripcion())
                .listaPreguntasAbirtas(listaAbiertasDto(encuesta.getListaPreguntas()))
                .listaPreguntasCerradas(listaCerradaDto(encuesta.getListaPreguntas()))
                .build();


        //return new EncuestaDto()
    }

}
