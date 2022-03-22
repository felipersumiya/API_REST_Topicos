package br.com.felipersumiya.kotlinRest.service

import br.com.felipersumiya.kotlinRest.model.Curso
import br.com.felipersumiya.kotlinRest.repositories.CursoRepository
import org.springframework.stereotype.Service
import java.lang.NullPointerException
import java.util.*
import kotlin.collections.ArrayList

@Service
class CursoService (private val cursoRepository: CursoRepository){


    fun buscarPorId(id:Long):Curso{

        return cursoRepository.getById(id)

    }

}
