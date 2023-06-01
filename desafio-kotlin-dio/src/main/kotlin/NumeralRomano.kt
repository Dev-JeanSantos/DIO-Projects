fun main() {
    val numerosRomanos = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )
    val inputNumero: String? = readLine()
    val numeroRomano = inputNumero ?: "0";
    var i = 0;
    var resultado = 0;
    while (i < numeroRomano.length) {
        val atual = numerosRomanos.getValue(numeroRomano[i])
        val proximo = when (i + 1) {
            numeroRomano.length -> 0
            else -> numerosRomanos.getValue(numeroRomano[i + 1])
        }
        if(atual >= proximo) {
            resultado += atual
        } else {
            resultado += (proximo - atual)
            i++
        }
        i++
    }
    print(resultado)
}