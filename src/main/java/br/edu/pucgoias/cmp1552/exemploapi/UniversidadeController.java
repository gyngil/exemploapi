package br.edu.pucgoias.cmp1552.exemploapi;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

import java.util.ArrayList;

@Controller
public class UniversidadeController {

    @GetMapping({"/"})
    @ResponseBody
    public String iniciar(){
        return "Retorno da função iniciar da classe UniversidadeController do Exemplo de API!";
    }

    @GetMapping("/consultar/{id}")
    @ResponseBody
    public Universidade consultar(@PathVariable Integer id){

        Universidade universidade = new Universidade();
        universidade.setId(id);
        universidade.setNome("Pontifícia Universidade Católica de Goiás");
        universidade.setListaCursos(new ArrayList<Curso>());

        Curso curso = new Curso();
        curso.setId(10);
        curso.setCodigo("CMP");
        curso.setNome("Ciências da Computação");

        universidade.getListaCursos().add(curso);

        curso = new Curso();
        curso.setId(20);
        curso.setCodigo("ADS");
        curso.setNome("Análise e Desenvolvimento de Sistemas");

        universidade.getListaCursos().add(curso);

        return universidade;
    }

    @GetMapping("/converterJSON/{texto}")
    @ResponseBody
    public String converterJSON(@PathVariable String texto) {

        System.out.println(texto);
        Gson gson = new Gson();

        Universidade universidade = gson.fromJson(texto,Universidade.class);
        System.out.println(universidade.getId());
        System.out.println(universidade.getNome());

        return universidade.getId() + " - " + universidade.getNome();

    }

    @GetMapping("/converterTexto")
    @ResponseBody
    public String converterTexto() {

        Universidade universidade = new Universidade();
        universidade.setId(1);
        universidade.setNome("Pontifícia Universidade Católica de Goiás");
        universidade.setListaCursos(new ArrayList<Curso>());

        Curso curso = new Curso();
        curso.setId(10);
        curso.setCodigo("CMP");
        curso.setNome("Ciências da Computação");

        universidade.getListaCursos().add(curso);

        curso = new Curso();
        curso.setId(20);
        curso.setCodigo("ADS");
        curso.setNome("Análise e Desenvolvimento de Sistemas");

        universidade.getListaCursos().add(curso);

        Gson gson = new Gson();

        String json = gson.toJson(universidade);

        return json;

    }

    @ApiOperation("Método que realiza a inclusão de uma Universidade")
    @PostMapping("/incluir")
    @ResponseBody
    public String incluir(@RequestBody Universidade universidade) {

        Gson gson = new Gson();

        String json = gson.toJson(universidade);

        System.out.println(json);

        return "JSON Recebido!";

    }
}
