
fun converterParaMesPorExtenso(mes: String): String {
    return when (mes) {
        "01" -> "Janeiro"
        "02" -> "Fevereiro"
        "03" -> "Marco"
        "04" -> "Abril"
        "05" -> "Maio"
        "06" -> "Junho"
        "07" -> "Julho"
        "08" -> "Agosto"
        "09" -> "Setembro"
        "10" -> "Outubro"
        "11" -> "Novembro"
        "12" -> "Dezembro"
        else -> "Mês Inválido!"
    }
}

fun main() {
    val entrada: String? = readLine()
     val (dia, mes, ano) = entrada!!.split("/")
    val mesPorExtenso = converterParaMesPorExtenso(mes)
    println("$dia de $mesPorExtenso de $ano")
}