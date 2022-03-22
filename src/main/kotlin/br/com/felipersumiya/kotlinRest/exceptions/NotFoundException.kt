package br.com.felipersumiya.kotlinRest.exceptions

import java.lang.RuntimeException

class NotFoundException(message:String?) :RuntimeException(message) {

}