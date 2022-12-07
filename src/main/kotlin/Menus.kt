import Produtos.*
import java.text.NumberFormat
import java.util.*

private val currencyFormatter = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"))

enum class Menus(val menu: String) {
    PRINCIPAL(menu = """
            Menu padaria E-padoca:
            1..................Pães
            2..............Salgados
            3.................Doces
            4.................Sucos
            5.................Cafés
            0......Finalizar compra
            """.trimIndent()),

    PAES_(menu = """
            1 - Pão Francês............${currencyFormatter.format(PAO_FRANCES.preco)}
            2 - Pão de leite...........${currencyFormatter.format(PAO_DE_LEITE.preco)}
            3 - Pão de milho...........${currencyFormatter.format(PAO_DE_MILHO.preco)}
            0 - Voltar
            """.trimIndent()),

    SALGADOS_(menu =  """
            1 - Coxinha ..........${currencyFormatter.format(COXINHA.preco)}
            2 - Pastel............${currencyFormatter.format(COXINHA.preco)}
            3 - Empada............${currencyFormatter.format(COXINHA.preco)}
            0 - Voltar
            """.trimIndent()),

    DOCES_(menu = """
            1 - Brigadeiro...........${currencyFormatter.format(BRIGADEIRO.preco)}
            2 - Sonho................${currencyFormatter.format(SONHO.preco)}
            3 - Doce de Leite........${currencyFormatter.format(DOCE_DE_LEITE.preco)}
            0 - Voltar
            """.trimIndent()),

    SUCOS_(menu = """
            1 - Goiaba............${currencyFormatter.format(GOIABA.preco)}
            2 - Laranja...........${currencyFormatter.format(LARANJA.preco)}
            3 - Uva...............${currencyFormatter.format(UVA.preco)}
            0 - Voltar
            """.trimIndent()),

    CAFES_(menu = """
            1 - Expresso............${currencyFormatter.format(CAFE_EXPRESSO.preco)}
            2 - Capuccino...........${currencyFormatter.format(CAPUCCINO.preco)}
            3 - Latte...............${currencyFormatter.format(LATTE.preco)}
            0 - Voltar
            """.trimIndent()),

    COMANDA_SUPERIOR(menu = """
        ======================Comanda E-padoca=======================
        =============================================================
        item.......Produto..........Qtd.......Valor.............Total
        =============================================================
        """.trimIndent()),

    COMANDA_INFERIOR(menu = """
        =============================================================
        Total ============================================> 
        """.trimIndent())
}





