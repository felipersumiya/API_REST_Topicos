package br.com.felipersumiya.kotlinRest.repositories

import br.com.felipersumiya.kotlinRest.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository: JpaRepository<Usuario,Long> {
}