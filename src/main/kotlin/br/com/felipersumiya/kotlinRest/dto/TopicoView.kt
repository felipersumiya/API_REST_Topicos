package br.com.felipersumiya.kotlinRest.dto

import br.com.felipersumiya.kotlinRest.model.StatusTopico
import java.time.LocalDateTime

data class TopicoView(
    val id:Long?,
    val titulo:String,
    val mensagem:String,
    val status:StatusTopico,
    val dataCriacao:LocalDateTime
) {

}
