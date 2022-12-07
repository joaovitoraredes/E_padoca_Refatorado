import Produtos.*

class Pares {
    val paes: List<Pair<String,Double>> = listOf(
        Pair(PAO_FRANCES.nome, PAO_FRANCES.preco), //index 0
        Pair(PAO_DE_LEITE.nome, PAO_FRANCES.preco), //index 1
        Pair(PAO_DE_MILHO.nome, PAO_FRANCES.preco), //index 2
    )

    val salgados: List<Pair<String,Double>> = listOf(
        Pair(COXINHA.nome, COXINHA.preco),
        Pair(PASTEL.nome, PASTEL.preco),
        Pair(EMPADA.nome, EMPADA.preco),
    )

    val doces: List<Pair<String,Double>> = listOf(
        Pair(BRIGADEIRO.nome, BRIGADEIRO.preco),
        Pair(SONHO.nome, SONHO.preco),
        Pair(DOCE_DE_LEITE.nome, DOCE_DE_LEITE.preco),
    )

    val sucos: List<Pair<String,Double>> = listOf(
        Pair(GOIABA.nome, GOIABA.preco),
        Pair(LARANJA.nome, LARANJA.preco),
        Pair(UVA.nome, UVA.preco),
    )

    val cafe: List<Pair<String,Double>> = listOf(
        Pair(CAFE_EXPRESSO.nome, CAFE_EXPRESSO.preco),
        Pair(CAPUCCINO.nome, CAPUCCINO.preco),
        Pair(LATTE.nome, LATTE.preco),
    )
}