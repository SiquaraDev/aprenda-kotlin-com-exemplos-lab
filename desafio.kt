enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(var nome: String, var idade: Int)

data class ConteudoEducacional(var nome: String, val nivel: Nivel, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuario: Usuario) {
        for (i in usuario) {
            inscritos.add(i)
        }
    }
}

fun main() {
    val user1 = Usuario("Matheus", 21)
    val user2 = Usuario("Kayke", 17)
    
    val ce1 = ConteudoEducacional("Operadores com Kotlin", Nivel.BASICO)
    val ce2 = ConteudoEducacional("Estruturas de repetição com Kotlin", Nivel.INTERMEDIARIO)
    val ce3 = ConteudoEducacional("POO com Kotlin", Nivel.AVANCADO, 120)
    val ces = listOf(ce1, ce2, ce3)
    
    val formacao = Formacao("Kotlin", ces)
    
    for (c in formacao.conteudos) {
        println(c)
    }
    println()
    
    formacao.matricular(user1, user2)
    println(formacao.inscritos)
}