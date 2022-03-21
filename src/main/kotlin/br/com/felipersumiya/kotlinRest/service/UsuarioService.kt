package br.com.felipersumiya.kotlinRest.service

import br.com.felipersumiya.kotlinRest.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService (var usuarios:List<Usuario>){

    init {
        val usuario = Usuario(
            id = 1,
            nome= "Felipe Sumiya",
            email = "felipersumiya@gmail.com"
        )

        usuarios = Arrays.asList(usuario)
    }

    fun buscarPorId(id:Long):Usuario{

        return usuarios.stream().filter({
            usuario -> usuario.id == id
        }).findFirst().get()
    }

}
