package co.com.robin.food.jpa.helper;

import co.com.robin.food.jpa.entity.encuesta.RespuestaEntity;
import co.com.robin.food.model.diligencia.RespuestaPregunta;
import co.com.robin.food.model.respuesta.Respuesta;

public class RespuestaModelEntityHelper {
   public static RespuestaEntity toRespuestaEntity(RespuestaPregunta respuestaPregunta){
       RespuestaEntity respuestaEntity = new RespuestaEntity();
       respuestaEntity.setDescripcion(respuestaPregunta.getRespuesta().getDescripcionRespuesta());
       return respuestaEntity;

   }
   public  static  void addRespuesta(RespuestaEntity respuestaEntity, RespuestaPregunta respuestaPregunta ){
       respuestaPregunta.setRespuesta(Respuesta.builder()
               .idRespuesta(respuestaEntity.getIdRespuesta())
               .descripcionRespuesta(respuestaEntity.getDescripcion())
               .build()
       );
   }
}
