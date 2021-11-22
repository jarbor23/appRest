package co.com.robin.food.jpa.encuesta;

import co.com.robin.food.jpa.entity.encuesta.EncuestaEntity;
import co.com.robin.food.jpa.helper.AdapterOperations;
import co.com.robin.food.jpa.helper.EncuestaModelEntityHelper;
import co.com.robin.food.model.encuesta.Encuesta;
import co.com.robin.food.model.encuesta.gateways.EncuestaRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JPARepositoryAdapter extends AdapterOperations<Encuesta, EncuestaEntity, Long, JPARepository>
 implements EncuestaRepository
{

    public JPARepositoryAdapter(JPARepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Encuesta.EncuestaBuilder.class).build());
    }

    @Override
    public List<Encuesta> getEncuestas() {
        return super.findAll();
    }


    @Override
    public Encuesta getEncuesta(long idEncuesta) {
        Optional<EncuestaEntity> encuesta= super.repository.findById(idEncuesta);
        return  EncuestaModelEntityHelper.obtenerModel(encuesta);
    }

    @Override
    public void crearEncuesta(Encuesta encuensta) {
        EncuestaEntity encuenstaEnt= super.toData(encuensta);
        EncuestaModelEntityHelper.addPreguntasRespuestas(encuensta,encuenstaEnt);
        super.saveData(encuenstaEnt);
    }

}
