package rpe.estagio.desafio3.presentation.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class VeiculoDePasseioDTO extends VeiculoDTO {

    private int numPassageiros;
    
}
