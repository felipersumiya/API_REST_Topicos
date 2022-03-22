package br.com.felipersumiya.kotlinRest.mapper

import br.com.felipersumiya.kotlinRest.dto.TopicoForm
import br.com.felipersumiya.kotlinRest.model.Topico
import br.com.felipersumiya.kotlinRest.service.CursoService
import br.com.felipersumiya.kotlinRest.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,
) :Mapper<TopicoForm, Topico> {


    override fun map(form: TopicoForm): Topico {
       return Topico(
            titulo = form.titulo,
            mensagem = form.mensagem,
            curso = cursoService.buscarPorId(form.idCurso),
            usuario = usuarioService.buscarPorId(form.idAutor)
        )
    }

}