package co.com.robin.food.jpa.entity.encuesta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PREGUNTA_ABIERTA")
@Builder
public class PreguntaAbiertaEntity implements Serializable {

    /*@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    long idPregunta;*/
    @Column(name="TAMANNO_RESPUESTA")
    int tamanoRespuesta;
    @Id
    @OneToOne
    @JoinColumn(name="FK_PREGUNTA")
    private PreguntaEntity preguntaAbierta;

}
