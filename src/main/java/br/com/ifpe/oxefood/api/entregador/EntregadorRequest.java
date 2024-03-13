package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class EntregadorRequest {
      
    private String nome;
  
    private String cpf;

   private String rg;
  
   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate dataNascimento;

   private String foneCelular;
   
   private String foneFixo;

   private Integer qtdEntregasRealizadas;

   private Double valorFrete;

   private String EnderecoRua;

   private String EnderecoNumero;

   private String EnderecoBairro;

   private String EnderecoCidade;

   private String EnderecoCep;

   private String EnderecoUf;

   private String EnderecoComplemento;

   private Boolean ativo;

   public Entregador build() {
 
    return Entregador.builder()
        .nome(nome)
        .cpf(cpf)
        .rg(rg)
        .dataNascimento(dataNascimento)
        .foneCelular(foneCelular)
        .foneFixo(foneFixo)
        .qtdEntregasRealizadas( qtdEntregasRealizadas)
        .valorFrete(valorFrete)
        .EnderecoRua(EnderecoRua)
        .EnderecoNumero( EnderecoNumero)
        .EnderecoBairro(EnderecoBairro)
        .EnderecoCidade(EnderecoCidade)
        .EnderecoCep(EnderecoCep)
        .EnderecoUf(EnderecoUf)
        .EnderecoComplemento(EnderecoComplemento)
        .ativo(ativo)
        .build();
}

}
