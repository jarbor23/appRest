package co.com.robin.food.usecase.diligencia;

import co.com.robin.food.model.diligencia.Diligencia;
import co.com.robin.food.model.diligencia.RespuestaPregunta;
import co.com.robin.food.model.diligencia.gateways.DiligenciaRepository;
import co.com.robin.food.model.diligencia.gateways.DiligenciarRepository;
import co.com.robin.food.model.diligencia.gateways.UsuarioRepository;
import co.com.robin.food.model.encuesta.gateways.EncuestaRepository;
import co.com.robin.food.model.respuesta.gateways.RespuestaRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class DiligenciaUseCase {
    private final DiligenciaRepository diligenciaRepository;
    private final EncuestaRepository encuestaRepository;
    private final UsuarioRepository usuarioRepository;
    private final RespuestaRepository respuestaRepository;
    private final DiligenciarRepository diligenciarRepository;

    public void crearDiligencia(Diligencia diligencia){
        /* se valida que exista la encuesta*/
        diligencia.setEncuesta(encuestaRepository
                .getEncuesta(diligencia.getEncuesta().getIdEncuesta()));
        /* se valida el ususario, en caso de o existir se crea
         aplicar logica o exepcion necesario */
        diligencia.setUsuario(usuarioRepository
                .createUsuario(diligencia.getUsuario()));
        /* se agregan o validan que las preguntas si pertenezcan a encuesta */

        diligencia.setRespuestasDiligenciadas
                (agregarResputas(diligencia.getRespuestasDiligenciadas()));
        diligencia.setIdDiligencia(diligenciaRepository.crearDiligencia(diligencia).getIdDiligencia());
        diligenciarRepository.registrarDiligencia(diligencia);
    }
    private  List<RespuestaPregunta>agregarResputas(List<RespuestaPregunta> lista){
        List<RespuestaPregunta> respuetasAbiertas = new  ArrayList<>();
        List<RespuestaPregunta> respuetasCerradas = new ArrayList<>();
        lista.stream().filter(p->!(p.getRespuesta().getIdRespuesta() < 1))
                .forEach(respuetasAbiertas::add);
        lista.stream().filter(p->{
            return p.getRespuesta().getIdRespuesta() < 1 ;
        }).map(p->{
            return respuestaRepository.createRespuesta(p);
        }).forEach(respuetasCerradas::add);

        return Stream.concat(respuetasAbiertas.stream(), respuetasCerradas.stream())
                .collect(Collectors.toList());
    }
}
