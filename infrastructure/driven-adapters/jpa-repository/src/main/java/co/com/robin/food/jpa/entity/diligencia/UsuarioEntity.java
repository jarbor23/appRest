package co.com.robin.food.jpa.entity.diligencia;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USUARIO")
public class UsuarioEntity {
    @Id
    @Column(name="codigo_usuario")
    private String codigoUsuario;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
}
