package br.com.felipersumiya.kotlinRest.service

import br.com.felipersumiya.kotlinRest.dto.AtualizacaoTopicoForm
import br.com.felipersumiya.kotlinRest.dto.TopicoForm
import br.com.felipersumiya.kotlinRest.dto.TopicoView
import br.com.felipersumiya.kotlinRest.mapper.TopicoFormMapper
import br.com.felipersumiya.kotlinRest.mapper.TopicoViewMapper
import br.com.felipersumiya.kotlinRest.model.Topico
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
    private val topicoFormMapper:TopicoFormMapper

) {

//    init {
//
//        val topico1 = Topico(
//            1,
//            "Dúvidas Kotlin",
//            "Variáveis no Kotlin",
//            curso = Curso(
//                1,
//                "Programação",
//                "Exatas"
//            ),
//            usuario = Usuario(
//                1,
//                "Felipe Sumiya",
//                "felipersumiya@gmail.com"
//            )
//        )
//
//
//        val topico2 = Topico(
//            2,
//            "Dúvidas Kotlin2",
//            "Variáveis no Kotlin2",
//            curso = Curso(
//                2,
//                "História",
//                "Humanas"
//            ),
//            usuario = Usuario(
//                2,
//                "Sydnei Sumiya",
//                "sydsumiya@gmail.com"
//            )
//        )
//
//
//        val topico3 = Topico(
//            3,
//            "Dúvidas Kotlin3",
//            "Variáveis no Kotlin3",
//            curso = Curso(
//                3,
//                "Data Science",
//                "Exatas"
//            ),
//            usuario = Usuario(
//                3,
//                "Leandro Vieria",
//                "levi@gmail.com"
//            )
//        )
//
//        topicos = Arrays.asList(topico1, topico2, topico3)
//
//    }


    fun listar(): List<TopicoView> {

        return topicos.stream().map{
            topico -> topicoViewMapper.map(topico)
        }.collect(Collectors.toList())

    }

    fun buscarPorId(id: Long): TopicoView {

       val topico = topicos.stream().filter({ topico ->
            topico.id == id
        }).findFirst().get()

        return topicoViewMapper.map(topico)

    }

    fun incluir(topicoDto:TopicoForm) :TopicoView {

        val topico = topicoFormMapper.map(topicoDto)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)

        return topicoViewMapper.map(topico)
    }

    fun atualizar(topicoAtualizado:AtualizacaoTopicoForm):TopicoView {

        val topico = topicos.stream().filter({ topico ->
            topico.id == topicoAtualizado.id
        }).findFirst().get()

        val topicoNovo = Topico(
            id = topicoAtualizado.id,
            titulo = topicoAtualizado.titulo,
            mensagem = topicoAtualizado.mensagem,
            curso = topico.curso,
            usuario = topico.usuario,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )
        topicos = topicos.minus(topico).plus(topicoNovo)

        return topicoViewMapper.map(topicoNovo)
    }

    @DeleteMapping
    fun excluir(id:Long){

       val topico = topicos.stream().filter {
           topico -> topico.id == id
       }.findFirst().get()

        topicos = topicos.minus(topico)

    }


}