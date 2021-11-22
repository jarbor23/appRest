package co.com.robin.food.api;

import co.com.robin.food.api.rest.dto.diligencia.DiligenciaDto;
import co.com.robin.food.api.rest.helpers.DiligenciaDtoModelHelper;
import co.com.robin.food.usecase.diligencia.DiligenciaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/diligencia", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ApiRestDiligencia {
    private final DiligenciaUseCase useCaseDiligencia;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DiligenciaDto> crearEncuesta( @Valid @RequestBody DiligenciaDto diligenciaDto) {
        useCaseDiligencia.crearDiligencia(DiligenciaDtoModelHelper.buildDiligencia(diligenciaDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(diligenciaDto);
    }
}
