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
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id ;

    private String nome;

    private String email;

    @Column(name = "data_cadastro")
    private Date dataCadastro;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Inscricao",
            joinColumns = { @JoinColumn(name = "aluno_id")},
            inverseJoinColumns = {@JoinColumn(name = "curso_id")}
    )
    @JsonIgnore
    private Set<Curso> cursos = new HashSet<>();

}
