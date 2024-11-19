package br.com.aluno.Aluno.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id ;

    private String nome;

    private String descricao;

    @Column(name = "data_criacao")
    private Date dataCriacao;

    @ManyToMany(mappedBy = "cursos")
    @JsonIgnore
    private Set<Aluno> alunos = new HashSet<>();

}
