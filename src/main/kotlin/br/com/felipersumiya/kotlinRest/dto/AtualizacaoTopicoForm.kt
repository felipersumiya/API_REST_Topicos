package br.com.felipersumiya.kotlinRest.dto

data class AtualizacaoTopicoForm(
    val id:Long,
    val titulo:String,
    val mensagem:String
) {

}
