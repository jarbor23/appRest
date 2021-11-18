package co.com.robin.food.jpa;

import co.com.robin.food.jpa.entity.encuesta.EncuestaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPARepository extends CrudRepository<EncuestaEntity, Long>, QueryByExampleExecutor<EncuestaEntity> {
}
