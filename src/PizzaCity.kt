abstract class PizzaCity(
    val neapolitanPizzaPrice: Double, val romanPizzaPrice: Double,
    val sicilianPizzaPrice: Double, val tyroleanPizzaPrice: Double
) {
    var neapolitanPizzaCount = 0
    var romanPizzaCount = 0
    var sicilianPizzaCount = 0
    var tyroleanPizzaCount = 0

    abstract fun neapolitanPizzaSale()

    abstract fun romanPizzaSale()

    abstract fun sicilianPizzaSale()

    abstract fun tyroleanPizzaSale()

    open fun showStatistics() {
        println("Статистика продаж:")
        println("Неаполитанская пицца: $neapolitanPizzaCount")
        println("Римская пицца: $romanPizzaCount")
        println("Сицилийская пицца: $sicilianPizzaCount")
        println("Тирольская пицца: $tyroleanPizzaCount")

        val money = neapolitanPizzaCount * neapolitanPizzaPrice + romanPizzaCount * romanPizzaPrice +
                sicilianPizzaCount * sicilianPizzaPrice + tyroleanPizzaCount * tyroleanPizzaPrice

        println("Общая сумма за продажи: $money рублей")
    }
}