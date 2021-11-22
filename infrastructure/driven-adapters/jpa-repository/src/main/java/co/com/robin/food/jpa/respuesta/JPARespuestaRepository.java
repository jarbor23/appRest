package co.com.robin.food.jpa.respuesta;

import co.com.robin.food.jpa.entity.encuesta.RespuestaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPARespuestaRepository  extends CrudRepository<RespuestaEntity, Long>, QueryByExampleExecutor<RespuestaEntity> {
}
