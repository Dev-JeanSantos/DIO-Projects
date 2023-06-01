object ReceitaFederal {
    fun calcularImposto(salario: Double): Double {
        val aliquota = when {
            salario in 0.00 .. 1100.0 -> 0.05
            salario in 1100.01 .. 2500.0 -> 0.1
            else -> 0.15
        }
        return aliquota * salario
    }
}

fun main() {
    val salarioBruto = readLine()!!.toDouble()
    val totalBeneficios = readLine()!!.toDouble()
    val impostoDeRenda = ReceitaFederal.calcularImposto(salarioBruto)
    val salarioLiquido = salarioBruto - impostoDeRenda + totalBeneficios

    println(String.format("%.2f", salarioLiquido));
}