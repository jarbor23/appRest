package co.com.robin.food.jpa.respuestaPregunta;

import co.com.robin.food.jpa.entity.diligencia.DiligenciaHasPreguntaHasRespuestaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPARespuestaPeguntaRespository extends CrudRepository<DiligenciaHasPreguntaHasRespuestaEntity, Long>, QueryByExampleExecutor<DiligenciaHasPreguntaHasRespuestaEntity> {
}
