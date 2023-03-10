package rpe.estagio.desafio3.presentation.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class VeiculoDeCargaDTO extends VeiculoDTO {

    private int capacidade;
    private int qtdCarroceria;
    
}
