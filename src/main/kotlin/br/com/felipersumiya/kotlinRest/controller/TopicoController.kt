package br.com.felipersumiya.kotlinRest.controller

import br.com.felipersumiya.kotlinRest.dto.AtualizacaoTopicoForm
import br.com.felipersumiya.kotlinRest.dto.TopicoForm
import br.com.felipersumiya.kotlinRest.dto.TopicoView
import br.com.felipersumiya.kotlinRest.model.Topico
import br.com.felipersumiya.kotlinRest.service.TopicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid


@RestController
@RequestMapping ("/topicos")
class TopicoController(private val service:TopicoService) {

    @GetMapping
    fun listar(): List<TopicoView>{

       return service.listar()

    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id:Long):TopicoView{

        return service.buscarPorId(id)
    }

    @PostMapping
    fun incluir(@RequestBody @Valid topicoDto: TopicoForm, uriBuilder :UriComponentsBuilder) :ResponseEntity<TopicoView>{

        val topicoView = service.incluir(topicoDto)
        val uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri()

        return ResponseEntity.created(uri).body(topicoView)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid dto: AtualizacaoTopicoForm, uriBuilder: UriComponentsBuilder):ResponseEntity<TopicoView>{

        val topicoView=  service.atualizar(dto)
        return ResponseEntity.ok(topicoView)

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun excluir( @PathVariable id:Long){

        service.excluir(id)

    }
}