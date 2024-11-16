import kotlin.math.roundToInt
import kotlin.system.exitProcess

val drinkPizzas = mutableMapOf("1" to 0, "2" to 0, "3" to 0, "4" to 0)

fun main() {
    val pizzaPeter = PizzaPeter(
        175.3, 241.5,
        167.5, 215.0
    )
    val pizzaMoscow = PizzaMoscow(
        215.3, 250.5,
        180.5, 240.0
    )
    val pizzaTula = PizzaTula(
        210.3, 240.5,
        175.5, 210.0
    )

    while (true) {
        val currentPizzaCity: PizzaCity
        println("Выберите город: ")
        println("1. Москва")
        println("2. Санкт-Петербург")
        println("3. Тула")
        println("0. Выход")

        val city = readln()
        currentPizzaCity = when (city) {
            "1" -> pizzaMoscow
            "2" -> pizzaPeter
            "3" -> pizzaTula
            "0" -> break
            else -> {
                println("ERROR")
                continue
            }
        }

        println("Выберите пиццу:")
        println("1. Неаполитанская")
        println("2. Римская")
        println("3. Сицилийская")
        println("4. Тирольская")
        println("0. Статистика")
        selectPizza(currentPizzaCity)
    }
}

private fun selectPizza(currentPizzaCity: PizzaCity) {
    val pizza = readln()
    when (pizza) {
        "1" -> currentPizzaCity.neapolitanPizzaSale()

        "2" -> currentPizzaCity.romanPizzaSale()

        "3" -> currentPizzaCity.sicilianPizzaSale()

        "4" -> currentPizzaCity.tyroleanPizzaSale()

        "0" -> {
            currentPizzaCity.showStatistics()
            if (currentPizzaCity is PizzaPeter) {
                val total = currentPizzaCity.romanPizzaCount + currentPizzaCity.sicilianPizzaCount +
                        currentPizzaCity.tyroleanPizzaCount + currentPizzaCity.neapolitanPizzaCount

                for (pair in drinkPizzas) {
                    val percent = (pair.value.toDouble() / total * 100).roundToInt()
                    val pizzaName = when (pair.key) {
                        "1" -> "Римская"
                        "2" -> "Сицилийская"
                        "3" -> "Тирольская"
                        "4" -> "Неаполитанская"
                        else -> "Неизвестная пицца"
                    }
                    println("Куплено кофе для пиццы $pizzaName: ${pair.value} ($percent%)")
                }
            }
        }

        else -> {
            println("ERROR")
            return
        }
    }

    if (pizza != "0") {
        selectAddService(currentPizzaCity, pizza)
    }
}

fun selectAddService(currentPizzaCity: PizzaCity, pizza: String) {
    if (currentPizzaCity is CheckPhoto) currentPizzaCity.showCheckPhoto()
    if (currentPizzaCity is Drink) {
        val count = currentPizzaCity.drinkCount
        currentPizzaCity.drinkSale()
        if (currentPizzaCity.drinkCount > count) {
            drinkPizzas[pizza] = drinkPizzas[pizza]!! + 1;
        }
    }
    if (currentPizzaCity is Sauce) currentPizzaCity.showSauce()

}