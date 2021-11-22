package co.com.robin.food.jpa.helper;

import co.com.robin.food.jpa.entity.diligencia.DiligenciaEntity;
import co.com.robin.food.jpa.entity.diligencia.DiligenciaHasPreguntaHasRespuestaEntity;
import co.com.robin.food.model.diligencia.Diligencia;
import co.com.robin.food.model.diligencia.Usuario;

import java.util.ArrayList;
import java.util.List;

public class DiligenciaModelEntityHelper {
    public static DiligenciaEntity toDiligenciaEntity(Diligencia diligencia){
        DiligenciaEntity diligenciaEntity =new DiligenciaEntity();
        diligenciaEntity.setCodigoUsuario(diligencia.getUsuario().getCodigoUsuario());
        return diligenciaEntity;
    }
    public static  void addUsuario(DiligenciaEntity diligenciaEntity,Diligencia diligencia){
         diligencia.setUsuario(Usuario.builder()
                        .codigoUsuario(diligenciaEntity.getCodigoUsuario())
                .build());
    }
    public  static List<DiligenciaHasPreguntaHasRespuestaEntity> toListDiligenciaHasPre
            (Diligencia diligencia){
        List<DiligenciaHasPreguntaHasRespuestaEntity> lista =  new ArrayList<>();
        diligencia.getRespuestasDiligenciadas().stream()
                .forEach(d -> {
                    lista.add(DiligenciaHasPreguntaHasRespuestaEntity.builder()
                                    .idDiligencia(diligencia.getIdDiligencia())
                                    .idEncueta(diligencia.getIdDiligencia())
                                    .idPregunta(d.getPregunta().getIdPregunta())
                                    .idRespuesta(d.getRespuesta().getIdRespuesta())
                            .build());
                });
        return lista;
    }
}
