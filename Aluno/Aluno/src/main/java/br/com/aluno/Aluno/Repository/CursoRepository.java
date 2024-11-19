package br.com.aluno.Aluno.Repository;

import br.com.aluno.Aluno.Model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository  extends JpaRepository<Curso,Long> {
}
