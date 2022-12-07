import Menus.*
import OpcoesCategorias.*
import java.text.NumberFormat
import java.util.*

class Comanda {

    private val currencyFormatter = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"))
    private val comanda: MutableList<String> = mutableListOf()
    private var valorTotal = 0.0

    init {
        ePadoca()
        verificacaoVazia()
    }

    private fun ePadoca() {
        do {
            println(PRINCIPAL.menu)
            val categoria = readln().toInt()

            when (categoria) {
                PAES.id -> {
                    selecionaProduto(menuSelecionado = PAES_.menu, produtos = Pares().paes)
                }

                SALGADOS.id -> {
                    selecionaProduto(menuSelecionado = SALGADOS_.menu, produtos = Pares().salgados)
                }
                DOCES.id -> {
                    selecionaProduto(menuSelecionado = DOCES_.menu, produtos = Pares().doces)
                }
                SUCOS.id -> {
                    selecionaProduto(menuSelecionado = SUCOS_.menu, produtos = Pares().sucos)
                }
                CAFES.id -> {
                    selecionaProduto(menuSelecionado = CAFES_.menu, produtos = Pares().cafe)
                }
            }
        } while (categoria != 0)

        println("Você possui algum cupom de desconto?")
        when (readln().uppercase()) {
            "S" -> valorTotal = cupomDeDesconto(valorTotal)
        }
    }

    private fun selecionaQuantidadeDoProdutoECalculoDoValor(
        produto: Pair<String, Double>
    ) {
        println("Quantidade: ")
        val quantidadeDoTipoDoPao = readln().toInt()
        val precoTotalItem = produto.second * quantidadeDoTipoDoPao
        val tamanho = pontos(produto.first)

        val linhaItem = linhaDaComanda(
            produto = produto.first,
            qtsProduto = quantidadeDoTipoDoPao,
            valorProduto = produto.second,
            precoTotalDoProduto = precoTotalItem,
            pontos = tamanho
        )

        comanda.add(linhaItem)
        valorTotal += precoTotalItem
    }

    private fun linhaDaComanda(
        produto: String,
        qtsProduto: Int,
        valorProduto: Double,
        precoTotalDoProduto: Double,
        pontos: String
    ): String =
        "${comanda.size.inc()}.......$produto$pontos$qtsProduto.......${currencyFormatter.format(valorProduto)}...........${currencyFormatter.format(precoTotalDoProduto)}"

    private fun selecionaProduto(
        menuSelecionado: String,
        produtos: List<Pair<String, Double>>
    ) {
        println(menuSelecionado)

        do {
            val selecaoDoTipoDoProduto = readln().toInt()

            for ((i, produto) in produtos.withIndex()) {
                if (i.inc() == selecaoDoTipoDoProduto) {
                    selecionaQuantidadeDoProdutoECalculoDoValor(produto)
                    break
                }
            }

            println(menuSelecionado)

        } while (selecaoDoTipoDoProduto != 0)
    }

    private fun cupomDeDesconto(
        valorTotal: Double
    ): Double {

        var valor = valorTotal
        println("Qual o seu cupom?")

        when (readln()) {
            "5PADOCA" -> valor -= (valor * 0.05)
            "10PADOCA" -> valor -= (valor * 0.1)
            "50OFF" -> valor -= (valor * 0.5)
            else ->
                println("Cupom inválido!!")
        }
        return valor
    }

    private fun verificacaoVazia(){
        if (comanda.isEmpty()) {
            do {
                println("Deseja mesmo cancelar a compra? (S/N)")
                val cancelarCompra = readln().uppercase()
                if (cancelarCompra == "N") {
                    ePadoca()
                }
            } while (cancelarCompra != "S" && cancelarCompra != "N")
        } else {
            println(COMANDA_SUPERIOR.menu)

            comanda.forEach { linhaItem ->
                println(linhaItem)
            }

            println(
                "${COMANDA_INFERIOR.menu} ${currencyFormatter.format(valorTotal)} \n" +
                        "======================VOLTE SEMPRE ^-^======================="
            )
        }
    }

    private fun pontos(palavra: String): String {
        val totalDePontos = 17 - palavra.length
        var ponto = ""

        for (i in 0..totalDePontos) {
            ponto += "."
        }
        return ponto
    }
}
