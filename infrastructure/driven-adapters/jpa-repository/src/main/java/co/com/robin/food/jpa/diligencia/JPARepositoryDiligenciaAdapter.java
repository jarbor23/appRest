package co.com.robin.food.jpa.diligencia;

import co.com.robin.food.jpa.entity.diligencia.DiligenciaEntity;
import co.com.robin.food.jpa.helper.AdapterOperations;
import co.com.robin.food.jpa.helper.DiligenciaModelEntityHelper;
import co.com.robin.food.model.diligencia.Diligencia;
import co.com.robin.food.model.diligencia.gateways.DiligenciaRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JPARepositoryDiligenciaAdapter extends AdapterOperations<Diligencia, DiligenciaEntity, Long, JPADiligenciaRepository>
        implements DiligenciaRepository {
    public JPARepositoryDiligenciaAdapter(JPADiligenciaRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Diligencia.DiligenciaBuilder.class).build());
    }

    @Override
    public Diligencia crearDiligencia(Diligencia diligencia) {

         diligencia.setIdDiligencia(super.saveData(DiligenciaModelEntityHelper
                        .toDiligenciaEntity(diligencia))
                .getIdDiligencia());
         return  diligencia;
    }

}
