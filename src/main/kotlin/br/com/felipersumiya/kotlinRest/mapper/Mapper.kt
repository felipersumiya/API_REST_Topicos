package br.com.felipersumiya.kotlinRest.mapper

interface Mapper<T, U> {

    fun map(t:T) :U

}
