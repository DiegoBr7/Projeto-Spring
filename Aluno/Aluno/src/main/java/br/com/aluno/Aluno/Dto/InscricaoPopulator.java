package br.com.aluno.Aluno.Dto;

import br.com.aluno.Aluno.Model.Aluno;
import br.com.aluno.Aluno.Model.Curso;

public class InscricaoPopulator {
    public AlunoDTO toAlunoDTO(Aluno aluno){
        AlunoDTO dto = new AlunoDTO();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setEmail(aluno.getEmail());
        dto.setDataCadastro(aluno.getDataCadastro());
        return dto;
    }

    public  CursoDTO toCursoDto(Curso curso){
        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setNome(curso.getNome());
        dto.setDescricao(curso.getDescricao());
        dto.setDataCriacao(curso.getDataCriacao());
        return dto;
        
    }
}
