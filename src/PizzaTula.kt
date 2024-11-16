import kotlin.math.roundToInt

class PizzaTula(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(neapolitanPizzaPrice, romanPizzaPrice, sicilianPizzaPrice, tyroleanPizzaPrice),
    CheckPhoto, Drink, Sauce {
    override fun neapolitanPizzaSale() {
        println("Спасибо за покупку неаполитанской пиццы в Туле")
        neapolitanPizzaCount++;
    }

    override fun romanPizzaSale() {
        println("Спасибо за покупку римской пиццы в Туле")
        romanPizzaCount++;
    }

    override fun sicilianPizzaSale() {
        println("Спасибо за покупку сицилийской пиццы в Туле")
        sicilianPizzaCount++;
    }

    override fun tyroleanPizzaSale() {
        println("Спасибо за покупку тирольской пиццы в Туле")
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
        println("Чеков предоставлено: $checkCount")
        println("Общая скидка за чеки: $checkDiscountSum")
        val totalSum = romanPizzaCount + neapolitanPizzaCount + sicilianPizzaCount + tyroleanPizzaCount
        val checkPercent = (checkCount.toDouble() / totalSum * 100).roundToInt()
        println("Процент показавших чек: $checkPercent%")

        println("Кофе продано: $drinkCount")
        println("Денег получено за кофе: $drinkSum")
        val totalSum2 = romanPizzaCount + neapolitanPizzaCount + sicilianPizzaCount + tyroleanPizzaCount
        val drinkPercent = (drinkCount.toDouble() / totalSum * 100).roundToInt()
        println("Процент купивших кофе: $drinkPercent%")

        println("Томатного соуса продано: $tomatoSauceCount ($tomatoSauceSum рублей)")
        println("Соуса песто продано: $pestoSauceCount ($pestoSauceSum рублей)")

        val money = neapolitanPizzaCount * neapolitanPizzaPrice + romanPizzaCount * romanPizzaPrice +
                sicilianPizzaCount * sicilianPizzaPrice + tyroleanPizzaCount * tyroleanPizzaPrice

        println("Общая сумма за продажи c учетом кофе, чеков, соусов: ${money + drinkSum - checkDiscountSum + pestoSauceSum + tomatoSauceSum} рублей")
    }

    var tomatoSauceCount = 0
    var tomatoSauceSum = 0.0
    var pestoSauceCount = 0
    var pestoSauceSum = 0.0

    override fun showSauce() {
        println("Выберите соус")
        println("1. Томатный")
        println("2. Песто")
        when (readln()) {
            "1" -> {
                println("С вас 200 рублей")
                tomatoSauceCount++
                tomatoSauceSum += 200.0
            }
            "2" -> {
                println("С вас 400 рублей")
                pestoSauceCount++
                pestoSauceSum += 400.0
            }
        }
    }
}