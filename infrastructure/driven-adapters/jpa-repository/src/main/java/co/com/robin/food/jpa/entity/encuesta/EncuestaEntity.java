package co.com.robin.food.jpa.entity.encuesta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ENCUESTAS")
public class EncuestaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    long idEncuesta;
    @Column(name="TITULO")
    String titulo;
    @Column(name="DESCRIPCION")
    String descripcion;

    @JoinTable(
            name = "REL_ENCUESTAS_PREGUNTAS",
            joinColumns = @JoinColumn(name = "FK_ENCUESTA", nullable = false),
            inverseJoinColumns = @JoinColumn(name="FK_PREGUNTA", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<PreguntaEntity> listaPreguntas ;



}
