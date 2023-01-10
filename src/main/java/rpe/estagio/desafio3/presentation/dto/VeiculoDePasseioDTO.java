package rpe.estagio.desafio3.presentation.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class VeiculoDePasseioDTO extends VeiculoDTO {

    private int numPassageiros;
    
}
