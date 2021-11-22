package co.com.robin.food.jpa.encuesta;


import co.com.robin.food.jpa.entity.encuesta.EncuestaEntity;
import co.com.robin.food.model.encuesta.Encuesta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.reactivecommons.utils.ObjectMapperImp;

import java.util.Arrays;
import java.util.Optional;

class JPARepositoryAdapterTest {

    JPARepository jpaRepository = Mockito.mock(JPARepository.class);


    @Test
    void getEncuestas() {
        EncuestaEntity correctEncuesta1 = new EncuestaEntity(1L, "pruebaEncuesta", " descrip", null);
        EncuestaEntity correctEncuesta2 = new EncuestaEntity(2L, "pruebaEncuesta", " descrip", null);

        Mockito.when(jpaRepository.findAll()).thenReturn(Arrays.asList(correctEncuesta1, correctEncuesta2));
        JPARepositoryAdapter reposi = new JPARepositoryAdapter(jpaRepository, new ObjectMapperImp());

        Assertions.assertAll("Get encuestas",
                () -> Assertions.assertEquals(2, reposi.findAll().size()),
                () -> reposi.findAll()
                        .stream()
                        .map(enc -> compareEncuestas(correctEncuesta1, enc) || compareEncuestas(correctEncuesta2, enc))
                        .forEach(Assertions::assertTrue)
        );

    }

    private boolean compareEncuestas(EncuestaEntity expect, Encuesta result) {
        return Optional.ofNullable(result)
                .filter(r -> r.getIdEncuesta() == expect.getIdEncuesta())
                .filter(r -> r.getTitulo().equals(expect.getTitulo()))
                .filter(r -> r.getDescripcion().equals(expect.getDescripcion()))
                .filter(r -> r.getListaPreguntas() == null)
                .isPresent();
    }
    @Test
    void getEncuesta() {
    }

    @Test
    void crearEncuesta() {
    }
}