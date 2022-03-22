package br.com.felipersumiya.kotlinRest.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Topico (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var titulo: String,
    var mensagem:String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val curso: Curso,

    @ManyToOne
    val usuario: Usuario,
    val status: StatusTopico =StatusTopico.NAO_RESPONDIDO,

    @OneToMany
    val resposta : List<Resposta> = ArrayList()
        ){
}