package br.com.felipersumiya.kotlinRest.repositories

import br.com.felipersumiya.kotlinRest.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository : JpaRepository<Topico, Long> {
}