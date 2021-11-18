package co.com.robin.food.api;

import co.com.robin.food.api.rest.dto.encuesta.EncuestaDto;
import co.com.robin.food.api.rest.helpers.EncuestaDtoModelHelper;
import co.com.robin.food.model.encuesta.Encuesta;
import co.com.robin.food.usecase.encuesta.EncuestaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/encuesta", produces = MediaType.APPLICATION_JSON_VALUE)
//@AllArgsConstructor
@RequiredArgsConstructor
public class ApiRestEncuesta {
   private final EncuestaUseCase useCaseEncuesta;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Encuesta> crearEncuesta(@Valid @RequestBody EncuestaDto encuesta) {
         useCaseEncuesta.crearEncuesta(EncuestaDtoModelHelper.createModelEncuesta(encuesta));
        return ResponseEntity.status(HttpStatus.CREATED).body(EncuestaDtoModelHelper.createModelEncuesta(encuesta));
    }
    @PostMapping("/holapost")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Encuesta> crearEncuestaPrueba(@Valid @RequestBody EncuestaDto encuesta) {
        int vakp=3;
        //Encuesta covertido=Encuesta.builder().idEncuesta(encuesta.getId()).ListaPreguntas(encuesta.getListaPreguntas()).build();
        useCaseEncuesta.crearEncuestaPrueba();
        return ResponseEntity.status(HttpStatus.OK).body(EncuestaDtoModelHelper.createModelEncuesta(encuesta));
    }
    @GetMapping
    public List<Encuesta> listarEncustas() {
        return useCaseEncuesta.getEncuestas();
    }
    @GetMapping("/{id}")
    public ResponseEntity<EncuestaDto> listarEncustaXid(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(EncuestaDtoModelHelper.createDtoEncuesta
                (useCaseEncuesta.getEncuesta(id)));
    }
}
