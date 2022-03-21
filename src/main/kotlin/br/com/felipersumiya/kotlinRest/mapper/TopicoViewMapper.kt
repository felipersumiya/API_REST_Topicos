package br.com.felipersumiya.kotlinRest.mapper

import br.com.felipersumiya.kotlinRest.dto.TopicoView
import br.com.felipersumiya.kotlinRest.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper : Mapper<Topico, TopicoView> {

    override fun map(topico: Topico): TopicoView {

       return TopicoView(
            id= topico.id,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )
    }


}