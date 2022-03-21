package br.com.felipersumiya.kotlinRest.controller

import br.com.felipersumiya.kotlinRest.dto.AtualizacaoTopicoForm
import br.com.felipersumiya.kotlinRest.dto.TopicoForm
import br.com.felipersumiya.kotlinRest.dto.TopicoView
import br.com.felipersumiya.kotlinRest.model.Topico
import br.com.felipersumiya.kotlinRest.service.TopicoService
import org.springframework.web.bind.annotation.*
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
    fun incluir(@RequestBody @Valid topicoDto: TopicoForm){

        service.incluir(topicoDto)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid dto: AtualizacaoTopicoForm){

        service.atualizar(dto)

    }

    @DeleteMapping("/{id}")
    fun excluir( @PathVariable id:Long){

        service.excluir(id)

    }
}