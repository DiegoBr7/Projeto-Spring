package br.com.aluno.Aluno.Controller;


import br.com.aluno.Aluno.Model.Inscricao;
import br.com.aluno.Aluno.Repository.AlunoRepository;
import br.com.aluno.Aluno.Repository.CursoRepository;
import br.com.aluno.Aluno.Repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inscricao")
public class InscricaoController {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public Inscricao inscreverAluno(@RequestBody InscricaoRequest inscricaoRequest){
        Inscricao inscricao = new Inscricao();
        inscricao.setAluno(alunoRepository.findById(inscricaoRequest.getAlunoId()).orElseThrow());
        inscricao.setCurso(cursoRepository.findById(inscricaoRequest.getCursoId()).orElseThrow());
        inscricao.setDataInscricao(new Date());
        return inscricaoRepository.save(inscricao);
    }

    @GetMapping
    public List<Inscricao> listarInscricoes(){
        return inscricaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscricao> obterInscricao(@PathVariable Long id){
        Optional<Inscricao> inscricao = inscricaoRepository.findById(id);
        return inscricao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

class InscricaoRequest {

    private Long alunoId;
    private Long cursoId;

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

}
