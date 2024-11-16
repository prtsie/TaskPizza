import kotlin.math.roundToInt

class PizzaMoscow(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(neapolitanPizzaPrice, romanPizzaPrice, sicilianPizzaPrice, tyroleanPizzaPrice),
    CheckPhoto{
    override fun neapolitanPizzaSale() {
        println("Спасибо за покупку неаполитанской пиццы в Москве")
        neapolitanPizzaCount++;
    }

    override fun romanPizzaSale() {
        println("Спасибо за покупку римской пиццы в Москве")
        romanPizzaCount++;
    }

    override fun sicilianPizzaSale() {
        println("Спасибо за покупку сицилийской пиццы в Москве")
        sicilianPizzaCount++;
    }

    override fun tyroleanPizzaSale() {
        println("Спасибо за покупку тирольской пиццы в Москве")
        tyroleanPizzaCount++;
    }

    override fun showCheckPhoto() {
        println("У вас есть фотография чека?")
        println("1. Да")
        println("2. Нет")
        if (readln() == "1") {
            println("Вам будет скидка 50 рублей с покупки")
            checkCount++
            checkDiscountSum += 50.0
        }
    }

    override var checkCount = 0
    override var checkDiscountSum = 0.0

    override fun showStatistics() {
        super.showStatistics()
        println("Чеков предоставлено: $checkCount")
        println("Общая скидка за чеки: $checkDiscountSum")
        val totalSum = romanPizzaCount + neapolitanPizzaCount + sicilianPizzaCount + tyroleanPizzaCount
        val checkPercent = (checkCount.toDouble() / totalSum * 100).roundToInt()
        println("Процент показавших чек: $checkPercent%")

        val money = neapolitanPizzaCount * neapolitanPizzaPrice + romanPizzaCount * romanPizzaPrice +
                sicilianPizzaCount * sicilianPizzaPrice + tyroleanPizzaCount * tyroleanPizzaPrice

        println("Общая сумма за продажи c учетом показанных чеков: ${money - checkDiscountSum} рублей")
    }
}