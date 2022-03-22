package br.com.felipersumiya.kotlinRest.repositories

import br.com.felipersumiya.kotlinRest.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository : JpaRepository<Curso, Long> {
}