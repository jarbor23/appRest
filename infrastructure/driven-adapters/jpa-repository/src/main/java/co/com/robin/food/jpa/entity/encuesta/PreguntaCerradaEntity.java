package co.com.robin.food.jpa.entity.encuesta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "PREGUNTA_CERRADA")
public class PreguntaCerradaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    long idPregunta;

    @OneToOne
    @JoinColumn(name="FK_PREGUNTA")
    private PreguntaEntity preguntaCerrada;
    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "preguntaCerrada")
    private List<RespuestaEntity> Respuestas ;


}
