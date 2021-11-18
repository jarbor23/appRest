package co.com.robin.food.jpa.helper;


import co.com.robin.food.jpa.entity.encuesta.*;
import co.com.robin.food.model.encuesta.*;
import co.com.robin.food.model.pregunta.Pregunta;
import co.com.robin.food.model.pregunta.PreguntaAbierta;
import co.com.robin.food.model.pregunta.PreguntaCerrada;
import co.com.robin.food.model.respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EncuestaModelEntityHelper {
    public static EncuestaEntity addPreguntasRespuestas(Encuesta encuesta, EncuestaEntity encuestaEntity) {
        List<PreguntaEntity> preguntaEnt=new ArrayList<>();
        int contador=0;
        for (Pregunta pregunta :
                encuesta.getListaPreguntas()) {
            if( pregunta instanceof PreguntaAbierta){
                preguntaEnt.add(PreguntaEntity.builder()
                                .descripcion(pregunta.getDescripcion())
                                .titulo(pregunta.getTitulo())

                        .preguntasAbiertas(
                            PreguntaAbiertaEntity.builder()
                            .tamanoRespuesta(((PreguntaAbierta) pregunta).getTamanoRespuesta())
                            .preguntaAbierta(PreguntaEntity.builder().idPregunta(pregunta.getIdPregunta()).build())
                            .build()
                        ).build()
                );
                encuestaEntity.getListaPreguntas().get(contador).setPreguntasAbiertas(
                        PreguntaAbiertaEntity.builder()
                                .tamanoRespuesta(((PreguntaAbierta) pregunta).getTamanoRespuesta())
                                .preguntaAbierta(encuestaEntity.getListaPreguntas().get(contador++))
                                .build()
                );


            }else{
                PreguntaCerradaEntity preguntaCerradaEntity=PreguntaCerradaEntity.builder()
                        .preguntaCerrada(encuestaEntity.getListaPreguntas().get(contador)).build();
                preguntaCerradaEntity.setRespuestas(listaRespuestasCerradasEnt(((PreguntaCerrada)pregunta).getListadoRespuesta(),preguntaCerradaEntity));
                encuestaEntity.getListaPreguntas().get(contador).setPreguntasCerradas(
                        preguntaCerradaEntity
                );
                preguntaEnt.add(PreguntaEntity.builder()
                        .titulo(pregunta.getTitulo())
                        .descripcion(pregunta.getDescripcion())
                            .preguntasCerradas
                            (preguntaCerradaEntity)
                        .build()


                );

            }

        }

    //encuestaEntity.setListaPreguntas(preguntaEnt);
        return null;
    }
    public static List<RespuestaEntity> listaRespuestasCerradasEnt
            (List<Respuesta> resCerradas, PreguntaCerradaEntity id){
        List<RespuestaEntity> respuestaCerradas =new ArrayList<>();
        for (Respuesta res :
                resCerradas) {

            respuestaCerradas.add(RespuestaEntity.builder().descripcion(res.getDescripcionRespuesta())
                    .preguntaCerrada(id)
                    .build());
        }
        return respuestaCerradas;
    }

    public  static  Encuesta obtenerModel(Optional<EncuestaEntity> entidad){
        Encuesta respuesta=new Encuesta();
        respuesta.setDescripcion(entidad.get().getDescripcion());
        respuesta.setTitulo(entidad.get().getTitulo());
        respuesta.setIdEncuesta(entidad.get().getIdEncuesta());
        respuesta.setListaPreguntas(new ArrayList<>());
        for (PreguntaEntity preguntaEntity:(entidad.get().getListaPreguntas())) {
            if(preguntaEntity.getPreguntasAbiertas() !=null ){
                respuesta.getListaPreguntas().add(preguntaEntitiToPreguntaAbiertaModel(preguntaEntity));
            }else{
                respuesta.getListaPreguntas().add(preguntaEntitiToPreguntaCerradaModel(preguntaEntity));
            }


        }
        return respuesta;
    }
    public static PreguntaAbierta preguntaEntitiToPreguntaAbiertaModel(
            PreguntaEntity preguntaEntity){
        return PreguntaAbierta.builder()
                //.idPregunta(preguntaEntity.getPreguntasAbiertas().getIdPregunta())
                .idPregunta(preguntaEntity.getIdPregunta())
                .descripcion(preguntaEntity.getDescripcion())
                .titulo(preguntaEntity.getTitulo())
                .tamanoRespuesta(preguntaEntity.getPreguntasAbiertas().getTamanoRespuesta())
                .build();
    }
    public static PreguntaCerrada preguntaEntitiToPreguntaCerradaModel(
            PreguntaEntity preguntaEntity){

        return PreguntaCerrada.builder()
                .idPregunta(preguntaEntity.getIdPregunta())
                .descripcion(preguntaEntity.getDescripcion())
                .titulo(preguntaEntity.getTitulo())
                .listadoRespuesta(obtenerListaRespuesta(preguntaEntity.getPreguntasCerradas()))
                .build();
    }
    public static List<Respuesta> obtenerListaRespuesta(
            PreguntaCerradaEntity  preguntasCerradas){
        List<Respuesta> listaR =new ArrayList<Respuesta>();
        for(RespuestaEntity respuestaEntity:
             preguntasCerradas.getRespuestas()) {
            listaR.add(
                   Respuesta.builder()
                           .descripcionRespuesta(respuestaEntity.getDescripcion())
                           .idRespuesta(respuestaEntity.getIdRespuesta())
                           .build()
            );
        }
        return listaR;
    }

}
