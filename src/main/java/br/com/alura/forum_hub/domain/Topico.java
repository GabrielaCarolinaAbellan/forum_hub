package br.com.alura.forum_hub.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "Topico")
@NoArgsConstructor
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    private Curso curso;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario autor;

    @OneToMany(mappedBy = "topico")
    private List<Resposta> respostas;

    public Topico(String titulo, String mensagem, Curso curso, Usuario autor){
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = LocalDateTime.now();
        this.status = "Não Resolvido";
        this.curso = curso;
        this.autor = autor;
    }

}