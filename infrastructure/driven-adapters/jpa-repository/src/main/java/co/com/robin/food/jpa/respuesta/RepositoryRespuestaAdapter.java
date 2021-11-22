package co.com.robin.food.jpa.respuesta;

import co.com.robin.food.jpa.entity.encuesta.RespuestaEntity;
import co.com.robin.food.jpa.helper.AdapterOperations;
import co.com.robin.food.jpa.helper.RespuestaModelEntityHelper;
import co.com.robin.food.model.diligencia.RespuestaPregunta;
import co.com.robin.food.model.respuesta.gateways.RespuestaRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryRespuestaAdapter extends AdapterOperations<RespuestaPregunta, RespuestaEntity, Long, JPARespuestaRepository>
        implements RespuestaRepository {
    public RepositoryRespuestaAdapter(JPARespuestaRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, RespuestaPregunta.RespuestaPreguntaBuilder.class).build());
    }


    @Override
    public RespuestaPregunta createRespuesta(RespuestaPregunta respuesta) {
        RespuestaModelEntityHelper
                .addRespuesta(super.saveData(RespuestaModelEntityHelper
                        .toRespuestaEntity(respuesta)),respuesta
                );
        return respuesta;
    }
}
