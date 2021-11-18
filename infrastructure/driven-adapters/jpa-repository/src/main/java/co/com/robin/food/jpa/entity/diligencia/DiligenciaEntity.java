package co.com.robin.food.jpa.entity.diligencia;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DILIGENCIA")
@Builder
public class DiligenciaEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    private long idDiligencia;
    @Column(name="codigo_usuario")
    private String codigoUsuario;

}
