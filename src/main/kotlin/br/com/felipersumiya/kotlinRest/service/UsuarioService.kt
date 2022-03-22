package br.com.felipersumiya.kotlinRest.service

import br.com.felipersumiya.kotlinRest.model.Usuario
import br.com.felipersumiya.kotlinRest.repositories.UsuarioRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService (private val usuarioRepository: UsuarioRepository){

    fun buscarPorId(id:Long):Usuario{

        return usuarioRepository.getById(id)
    }

}
