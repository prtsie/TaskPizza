import kotlin.math.roundToInt

class PizzaPeter(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(neapolitanPizzaPrice, romanPizzaPrice, sicilianPizzaPrice, tyroleanPizzaPrice),
    Drink {
    override fun neapolitanPizzaSale() {
        println("Спасибо за покупку неаполитанской пиццы в Санкт-Петербурге")
        neapolitanPizzaCount++;
    }

    override fun romanPizzaSale() {
        println("Спасибо за покупку римской пиццы в Санкт-Петербурге")
        romanPizzaCount++;
    }

    override fun sicilianPizzaSale() {
        println("Спасибо за покупку сицилийской пиццы в Санкт-Петербурге")
        sicilianPizzaCount++;
    }

    override fun tyroleanPizzaSale() {
        println("Спасибо за покупку тирольской пиццы в Санкт-Петербурге")
        tyroleanPizzaCount++;
    }

    override fun drinkSale() {
        println("Вы будете кофе?")
        println("1. Да")
        println("2. Нет")
        if (readln() == "1") {
            println("С вас 200 рублей")
            drinkCount++
            drinkSum += 200.0
        }
    }

    override var drinkCount = 0
    override var drinkSum = 0.0

    override fun showStatistics() {
        super.showStatistics()
        println("Кофе продано: $drinkCount")
        println("Денег получено за кофе: $drinkSum")
        val totalSum = romanPizzaCount + neapolitanPizzaCount + sicilianPizzaCount + tyroleanPizzaCount
        val drinkPercent = (drinkCount.toDouble() / totalSum * 100).roundToInt()
        println("Процент купивших кофе: $drinkPercent%")

        val money = neapolitanPizzaCount * neapolitanPizzaPrice + romanPizzaCount * romanPizzaPrice +
                sicilianPizzaCount * sicilianPizzaPrice + tyroleanPizzaCount * tyroleanPizzaPrice

        println("Общая сумма за продажи c учетом кофе: ${money + drinkSum} рублей")
    }
}