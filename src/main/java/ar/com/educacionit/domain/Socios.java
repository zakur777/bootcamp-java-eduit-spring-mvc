package ar.com.educacionit.domain;

import javax.persistence.*;

@Entity
@Table(name = "socios")
public class Socios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String apellido;

    @Column(nullable = false, length = 60)
    private String nombre;

    @Column(nullable = false, length = 6, unique = true)
    private String codigo;
}
