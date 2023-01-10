package rpe.estagio.desafio3.presentation.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class VeiculoDTO {

    private String placa;
    private String nome;
    private String marca;
    
}
