package br.com.felipersumiya.kotlinRest.repositories

import br.com.felipersumiya.kotlinRest.dto.TopicoPorCategoriaDto
import br.com.felipersumiya.kotlinRest.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicoRepository : JpaRepository<Topico, Long> {


    fun findByCursoNome(nomeCurso:String, paginacao:Pageable) : Page<Topico>

    @Query("SELECT new br.com.felipersumiya.kotlinRest.dto.TopicoPorCategoriaDto(curso.categoria,count(t)) FROM Topico t JOIN t.curso curso GROUP BY curso.categoria")
    fun relatorioTopico(): List<TopicoPorCategoriaDto>

    @Query("SELECT t FROM Topico t WHERE t.resposta is empty")
    fun topicosSemResposta() : List<Topico>
}