package br.com.felipersumiya.kotlinRest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class KotlinRestApplication

fun main(args: Array<String>) {
	runApplication<KotlinRestApplication>(*args)
}
