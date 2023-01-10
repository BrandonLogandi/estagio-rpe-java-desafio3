package rpe.estagio.desafio3.presentation.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class VeiculoDeCargaDTO extends VeiculoDTO {

    private int capacidade;
    private int qtdCarroceria;
    
}
