package co.com.robin.food.jpa.respuestaPregunta;

import co.com.robin.food.jpa.entity.diligencia.DiligenciaHasPreguntaHasRespuestaEntity;
import co.com.robin.food.jpa.helper.AdapterOperations;
import co.com.robin.food.jpa.helper.DiligenciaModelEntityHelper;
import co.com.robin.food.model.diligencia.Diligencia;
import co.com.robin.food.model.diligencia.gateways.DiligenciarRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JPARespuestaPreguntaAdapter extends AdapterOperations<Diligencia, DiligenciaHasPreguntaHasRespuestaEntity, Long, JPARespuestaPeguntaRespository>
        implements DiligenciarRepository {
    public JPARespuestaPreguntaAdapter(JPARespuestaPeguntaRespository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Diligencia.DiligenciaBuilder.class).build());
    }

    @Override
    public void registrarDiligencia(Diligencia diligencia) {
        saveData(DiligenciaModelEntityHelper.toListDiligenciaHasPre(diligencia));
    }
}
