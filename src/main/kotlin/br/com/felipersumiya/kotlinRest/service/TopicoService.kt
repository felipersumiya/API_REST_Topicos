package br.com.felipersumiya.kotlinRest.service

import br.com.felipersumiya.kotlinRest.dto.AtualizacaoTopicoForm
import br.com.felipersumiya.kotlinRest.dto.TopicoForm
import br.com.felipersumiya.kotlinRest.dto.TopicoView
import br.com.felipersumiya.kotlinRest.exceptions.NotFoundException
import br.com.felipersumiya.kotlinRest.mapper.TopicoFormMapper
import br.com.felipersumiya.kotlinRest.mapper.TopicoViewMapper
import br.com.felipersumiya.kotlinRest.model.Topico
import br.com.felipersumiya.kotlinRest.repositories.CursoRepository
import br.com.felipersumiya.kotlinRest.repositories.TopicoRepository
import br.com.felipersumiya.kotlinRest.repositories.UsuarioRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.DeleteMapping
import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos:List<Topico> = ArrayList(),
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper:TopicoFormMapper,
    private val notFoundMessage:String = "Tópico não encontrado",
    private val topicoRepository: TopicoRepository,
    private val cursoRepository: CursoRepository,
    private val usuarioRepository: UsuarioRepository

) {

    fun listar(): List<TopicoView> {

        return topicoRepository.findAll().stream().map{
            topico -> topicoViewMapper.map(topico)
        }.collect(Collectors.toList())

    }

    fun buscarPorId(id: Long): TopicoView {

        val topico =
            topicoRepository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
        return topicoViewMapper.map(topico)

    }

    fun incluir(topicoDto:TopicoForm) :TopicoView {

        val topico = topicoFormMapper.map(topicoDto)

        topicoRepository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(topicoAtualizado:AtualizacaoTopicoForm):TopicoView {

        val topico = topicoRepository.findById(topicoAtualizado.id).orElseThrow { NotFoundException(notFoundMessage) }

        topico.titulo = topicoAtualizado.mensagem
        topico.mensagem = topicoAtualizado.mensagem

        return topicoViewMapper.map(topico)
    }

    @DeleteMapping
    fun excluir(id:Long){

        topicoRepository.deleteById(id)

    }

}