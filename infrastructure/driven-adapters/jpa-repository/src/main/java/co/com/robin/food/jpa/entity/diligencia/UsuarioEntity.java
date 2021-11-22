package co.com.robin.food.jpa.entity.diligencia;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USUARIO")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    long id;
    @Column(name="codigo_usuario")
    private String codigoUsuario;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
}
