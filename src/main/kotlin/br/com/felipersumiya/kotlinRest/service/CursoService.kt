package br.com.felipersumiya.kotlinRest.service

import br.com.felipersumiya.kotlinRest.model.Curso
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class CursoService (var cursos:List<Curso>){

    init {
        val curso = Curso(
            id= 1,
            "Kotlin",
            "Exatas"
        )
        cursos = Arrays.asList(curso)

    }

    fun buscarPorId(id:Long):Curso{
        return cursos.stream().filter({
            curso -> curso.id == id
        }).findFirst().get()
    }

}
