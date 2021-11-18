package co.com.robin.food.jpa.entity.diligencia;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Rel_DIL_PRE_RES")
public class DiligenciaHasPreguntaHasRespuesta {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    @Column(name="fk_id_pregunta")
    private long idPregunta;
    @Column(name="fk_id_encuesta")
    private long idEncueta;
    @Column(name="fk_id_respuesta")
    private long idRespuesta;
    @Column(name="fk_id_diligencia")
    private long idDiligencia;
}
