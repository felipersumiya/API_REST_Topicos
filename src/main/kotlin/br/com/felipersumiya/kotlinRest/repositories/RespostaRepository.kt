package br.com.felipersumiya.kotlinRest.repositories

import br.com.felipersumiya.kotlinRest.model.Resposta
import org.springframework.data.jpa.repository.JpaRepository

interface RespostaRepository : JpaRepository<Resposta, Long> {
}