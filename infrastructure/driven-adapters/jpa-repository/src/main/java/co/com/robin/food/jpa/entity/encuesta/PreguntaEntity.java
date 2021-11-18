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
@Table(name = "PREGUNTAS")
@AllArgsConstructor
@Builder
public class PreguntaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    private long idPregunta;
    @Column(name="TITULO")
    private String titulo;
    @Column(name="DESCRIPCION")
    private String descripcion;
    @ManyToMany(mappedBy = "listaPreguntas")
    private List<EncuestaEntity> encuestas;

    @OneToOne(cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "preguntaAbierta")
    private PreguntaAbiertaEntity preguntasAbiertas;

    @OneToOne(cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "preguntaCerrada")
    private PreguntaCerradaEntity preguntasCerradas;



}
