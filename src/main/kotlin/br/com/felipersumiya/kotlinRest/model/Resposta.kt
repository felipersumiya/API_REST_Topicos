package br.com.felipersumiya.kotlinRest.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Resposta(

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val usuario :Usuario,

    @ManyToOne
    val topico: Topico,
    val solucao: Boolean
) {

}
