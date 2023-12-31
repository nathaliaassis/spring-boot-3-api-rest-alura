package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name="medicos")
@Entity(name="medico")
@Getter //criar os getters
@NoArgsConstructor // cria o construtor default sem args
@AllArgsConstructor // para ter construtor que recebe todos o campos
@EqualsAndHashCode(of = "id") // gera hash code em cima do id
public class Medico {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String nome;
     private String telefone;
     private String email;
     private  String crm;

     @Enumerated(EnumType.STRING)
     private Especialidade especialidade;

     @Embedded
     private Endereco endereco;

     private boolean ativo;

     public Medico(DadosCadastroMedico dados) {
          this.nome = dados.nome();
          this.email = dados.email();
          this.telefone = dados.telefone();
          this.crm = dados.crm();
          this.endereco = new Endereco(dados.endereco());
          this.especialidade = dados.especialidade();
          this.ativo = true;
     }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
          if(dados.nome() != null) {
               this.nome = dados.nome();
          }
          if(dados.telefone() != null) {
              this.telefone = dados.telefone();
          }
          if(dados.endereco() != null) {
              this.endereco.atualizarInformacoes(dados.endereco());
          }
    }

    public void excluir() {
         this.ativo = false;
    }
}
