package co.com.robin.food.jpa;

import co.com.robin.food.jpa.entity.encuesta.EncuestaEntity;
import co.com.robin.food.jpa.entity.encuesta.PreguntaAbiertaEntity;
import co.com.robin.food.jpa.entity.encuesta.PreguntaCerradaEntity;
import co.com.robin.food.jpa.entity.encuesta.PreguntaEntity;
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
    public Object getEncuestas1() {
        Optional<EncuestaEntity> encuesta= super.repository.findById(1L);
        return  EncuestaModelEntityHelper.obtenerModel(encuesta);
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
    @Override
    public void crearEncuestaPrueba() {

        EncuestaEntity encuesta1=new EncuestaEntity();
        encuesta1.setTitulo("titulo 1");
        encuesta1.setDescripcion("esto es una descripcion");
            PreguntaEntity pregunta1 = new PreguntaEntity();
            pregunta1.setDescripcion("pregunta1");
            pregunta1.setTitulo("pregunta 1");
                PreguntaCerradaEntity  preguntaCerrada= new PreguntaCerradaEntity();
                preguntaCerrada.setPreguntaCerrada(pregunta1);
                pregunta1.setPreguntasCerradas(preguntaCerrada);

            PreguntaEntity pregunta2= new PreguntaEntity();
            pregunta2.setDescripcion("pregunta2");
            pregunta2.setTitulo("pregunta 2");
                PreguntaAbiertaEntity preguntaAbiera= new PreguntaAbiertaEntity();
                preguntaAbiera.setTamanoRespuesta(10);
                preguntaAbiera.setPreguntaAbierta(pregunta2);
                pregunta2.setPreguntasAbiertas(preguntaAbiera);
        encuesta1.addPregunta(pregunta1);
        encuesta1.addPregunta(pregunta2);

        super.saveData(encuesta1);
    }
}
