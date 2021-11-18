package co.com.robin.food.usecase.encuesta;

import co.com.robin.food.model.encuesta.Encuesta;
import co.com.robin.food.model.encuesta.gateways.EncuestaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class EncuestaUseCase {
    private final EncuestaRepository encuestaRepository;
    public List<Encuesta> getEncuestas() {
        return  encuestaRepository.getEncuestas();
    }
    public Encuesta getEncuesta(long idEncuesta){
        return encuestaRepository.getEncuesta(idEncuesta);
    }
    public void crearEncuesta(Encuesta encuensta){
        encuestaRepository.crearEncuesta(encuensta);
    }
    public void crearEncuestaPrueba(){
        encuestaRepository.crearEncuestaPrueba();
    }
    public Object prueba(){
        return encuestaRepository.getEncuestas1();
    }


}
