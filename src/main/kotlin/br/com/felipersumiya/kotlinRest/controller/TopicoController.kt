package br.com.felipersumiya.kotlinRest.controller

import br.com.felipersumiya.kotlinRest.dto.AtualizacaoTopicoForm
import br.com.felipersumiya.kotlinRest.dto.TopicoForm
import br.com.felipersumiya.kotlinRest.dto.TopicoPorCategoriaDto
import br.com.felipersumiya.kotlinRest.dto.TopicoView
import br.com.felipersumiya.kotlinRest.model.Topico
import br.com.felipersumiya.kotlinRest.service.TopicoService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.transaction.Transactional
import javax.validation.Valid


@RestController
@RequestMapping ("/topicos")
class TopicoController(private val service:TopicoService) {

    @GetMapping
    @Cacheable("topicos")
    fun listar(@RequestParam(required = false) nomeCurso:String?, @PageableDefault(size=6, sort = ["dataCriacao"], direction= Sort.Direction.DESC) paginacao:Pageable): Page<TopicoView>{

       return service.listar(nomeCurso,paginacao)

    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id:Long):TopicoView{

        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = ["topicos"], allEntries=true)
    fun incluir(@RequestBody @Valid topicoDto: TopicoForm, uriBuilder :UriComponentsBuilder) :ResponseEntity<TopicoView>{

        val topicoView = service.incluir(topicoDto)
        val uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri()

        return ResponseEntity.created(uri).body(topicoView)
    }

    @PutMapping
    @Transactional
    @CacheEvict(value = ["topicos"], allEntries=true)
    fun atualizar(@RequestBody @Valid dto: AtualizacaoTopicoForm, uriBuilder: UriComponentsBuilder):ResponseEntity<TopicoView>{

        val topicoView=  service.atualizar(dto)
        return ResponseEntity.ok(topicoView)

    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(value = ["topicos"], allEntries=true)
    fun excluir( @PathVariable id:Long){

        service.excluir(id)

    }

    @GetMapping("/relatorioTopico")
    fun relatorioTopico(): List<TopicoPorCategoriaDto>{

        return service.relatorioTopico()
    }

    @GetMapping("/topicosSemResposta")
    fun topicosNaoRespondidos() : List<Topico>{

        return service.topicosSemREsposta()

    }

}