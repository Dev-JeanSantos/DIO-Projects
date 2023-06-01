data class Pais(var habitantes: Double, val taxaCrescimento: Double) {
    fun crescerPopulacaoAnual() {
        habitantes += (habitantes * taxaCrescimento)
    }
}

fun main() {
    val habitantesPaisA = readLine()!!.toDouble();
    val habitantesPaisB = readLine()!!.toDouble();
    val paisA = Pais(habitantesPaisA, taxaCrescimento = 0.03)
    val paisB = Pais(habitantesPaisB, taxaCrescimento = 0.015)

    var quantidadeAnos = 0
    while (paisA.habitantes < paisB.habitantes) {
       paisA.crescerPopulacaoAnual();
       paisB.crescerPopulacaoAnual();
       quantidadeAnos++
    }
    println("${quantidadeAnos} anos")
}