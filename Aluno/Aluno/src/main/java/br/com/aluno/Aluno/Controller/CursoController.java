package br.com.aluno.Aluno.Controller;

import br.com.aluno.Aluno.Model.Curso;
import br.com.aluno.Aluno.Repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Curso criarCurso(@RequestBody Curso curso){
        return cursoRepository.save(curso);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Curso> listarCursos(){
        return cursoRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Curso> obterCurso(@PathVariable Long id){
        return cursoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
