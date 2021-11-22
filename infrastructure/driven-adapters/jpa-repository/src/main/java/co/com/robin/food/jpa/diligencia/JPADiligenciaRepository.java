package co.com.robin.food.jpa.diligencia;

import co.com.robin.food.jpa.entity.diligencia.DiligenciaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPADiligenciaRepository extends CrudRepository<DiligenciaEntity, Long>, QueryByExampleExecutor<DiligenciaEntity> {
}
