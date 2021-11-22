package co.com.robin.food.jpa.usuario;

import co.com.robin.food.jpa.entity.diligencia.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPAUsuarioRepository extends CrudRepository<UsuarioEntity, String>, QueryByExampleExecutor<UsuarioEntity> {

}
