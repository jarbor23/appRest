package co.com.robin.food.model.encuesta.gateways;
import co.com.robin.food.model.encuesta.Encuesta;

import java.util.List;

public interface EncuestaRepository {
    List<Encuesta> getEncuestas();
    Encuesta getEncuesta(long idEncuesta);
    void crearEncuesta(Encuesta encuensta);
}
