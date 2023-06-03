package com.fourtk.creditapplicationsystem.exceptions

data class BussinesException(override val message: String) : RuntimeException(message)