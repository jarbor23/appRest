package co.com.robin.food.jpa.usuario;

import co.com.robin.food.jpa.entity.diligencia.UsuarioEntity;
import co.com.robin.food.jpa.helper.AdapterOperations;
import co.com.robin.food.model.diligencia.Usuario;
import co.com.robin.food.model.diligencia.gateways.UsuarioRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JPAUsuarioRepositoryAdapter extends AdapterOperations<Usuario, UsuarioEntity, String, JPAUsuarioRepository>
        implements UsuarioRepository {
    public JPAUsuarioRepositoryAdapter(JPAUsuarioRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Usuario.UsuarioBuilder.class).build());
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        UsuarioEntity usu=super.toData(usuario);
            return super.save(usuario);
    }

}
