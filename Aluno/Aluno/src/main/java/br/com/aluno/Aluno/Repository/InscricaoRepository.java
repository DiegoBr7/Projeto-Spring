package br.com.aluno.Aluno.Repository;

import br.com.aluno.Aluno.Model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
}
