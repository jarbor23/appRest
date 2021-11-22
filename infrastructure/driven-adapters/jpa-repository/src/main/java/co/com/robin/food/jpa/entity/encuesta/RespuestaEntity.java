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
@Builder
@Table(name = "RESPUESTA")
public class RespuestaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    private long idRespuesta;
    @Column(name="DESCRIPCION")
    private String descripcion;
    @ManyToOne
    @JoinColumn(name="FK_PREGUNTA_CERRADA")
    private PreguntaCerradaEntity preguntaCerrada;
}
