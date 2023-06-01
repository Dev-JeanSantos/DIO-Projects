fun mediaFinal(media : Double) : String {
    return when {
        media < 5 -> "REP"
        media >= 5 && media < 7 -> "REC"
        media >= 7 -> "APR"
        else -> "Entrada inválida"
    }
}

fun main() {
    val media = readLine()!!.toDouble();
    println(mediaFinal(media))
}