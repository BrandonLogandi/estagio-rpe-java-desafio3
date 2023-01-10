package rpe.estagio.desafio3.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(length = 7, unique = true, nullable = false)
    private String placa;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String marca;

}
