package rpe.estagio.desafio3.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class VeiculoDePasseio extends Veiculo {

    @Column(nullable = false)
    private int numPassageiros;

}
