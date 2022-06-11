package API.REST.FULL.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Contactos")
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Nombre")
    private String Name;
    @Column(name = "Apellido")
    private String lastName;
    @Column(name = "Correo")
    private String Email;
    @Column(name = "Celular")
    private int Telefono;
    @Column(name = "Fecha_Nacimiento")
    private LocalDate FechaNacimiento;
    @Column(name = "Direccion")
    private String Direccion;
    @Column(name = "Pais")
    private String Origen;


}
