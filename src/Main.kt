fun main(args: Array<String>) {}

/**
 *
 * clear itens repeat in list
 *
 * */

private fun notRepeated(array: ArrayList<String>): ArrayList<String> {

    val listOfIndices = arrayListOf<Int>()
    var j: Int

    for (i in 0..array.size) {

        j = i + 1

        while (j < array.size) {
            if (array[i] == array[j]) {

                if (!listOfIndices.contains(j)) {
                    listOfIndices.add(j)
                }
            }
            j++
        }
    }

    for (i in listOfIndices.reversed()) {
        array.removeAt(i)
    }

    return array

}

/**
 *
 * print char $,# and etc... right to left
 *
 * */

private fun printChar(n: Int, s: String) {

    val num = 1
    var contSpaces = n - 1

    for (i in num..n) {

        for (a in num..contSpaces) {
            print(" ")
        }

        for (j in num..i) {
            print(s)
        }

        println()

        contSpaces--
    }
}

/**
 *
 * order list and sum the firsts fours elements to min sum, and get last four elements and to max sum
 *
 * */

private fun minMax(arr: Array<Int>) {

    arr.sortWith(Comparator { o1, o2 ->
        if (o1 < o2) {
            -1
        } else if (o1 > o2) {
            1
        } else {
            0
        }
    })

    var min = 0L
    var max = 0L

    var j = 1

    for (i in arr) {

        if (j < 5) {
            min += i
        }

        if (j > 1) {
            max += i
        }

        j++
    }

    print("$min $max")

}

/**
 *
 * cont candles more tall of birthday
 *
 * */

fun birthdayCakeCandles(ar: Array<Int>): Int {

    ar.sortWith(Comparator { o1, o2 ->

        if (o1 < o2) {
            -1
        } else if (o1 > o2) {
            1
        } else {
            0
        }
    })

    val n = ar.last()
    var cont = 0

    for (item in ar) {

        if (item == n) {
            cont++
        }

    }

    return cont

}

/**
 *
 * convert hour type 12:00:00 to 00:00:00
 *
 * */

fun timeConversion(s: String): String {

    val hour = s.substring(0, 2)
    val min = s.substring(3, 5)
    val sec = s.substring(6, 8)

    var hourInPm = 0
    var isPM = false

    val finalHour: String?

    when (hour.toInt()) {

        12 -> {

            if (s.contains("AM")) {
                finalHour = "00:$min:$sec"
            } else {
                finalHour = "$hour:$min:$sec"
            }

        }
        else -> {

            if (s.contains("PM")) {
                isPM = true
                hourInPm = hour.toInt().plus(12)
            }

            if (isPM) {
                if (hourInPm < 10) {
                    finalHour = "0$hourInPm:$min:$sec"
                } else {
                    finalHour = "$hourInPm:$min:$sec"
                }

            } else {
                finalHour = "$hour:$min:$sec"
            }

        }

    }

    return finalHour
}

/**
 *
 * rounded values from grade to students
 *
 * */

fun gradeStudents(grades: Array<Int>): Array<Int> {

    var isDivisible: Boolean
    var i = 0
    var prox: Int

    for (grade in grades) {

        if (grade >= 38) {

            prox = grade
            isDivisible = false

            while (!isDivisible) {

                if (prox.rem(5) == 0) {

                    val diff = prox - grade

                    if (diff < 3) {
                        grades[i] = prox
                    }

                    isDivisible = true
                } else {
                    prox++
                }

            }

        }

        i++

    }

    return grades
}

/**
 *
 * return apples and oranges proxim the house`s sam.
 *
 **/

fun countApplesAndOranges(s: Int, t: Int, a: Int, b: Int, apples: Array<Int>, oranges: Array<Int>) {

    var contApple = 0
    var contOrange = 0

    apples.forEachIndexed { i, item ->

        apples[i] = apples[i] + a

        val location = apples[i] >= s && apples[i] <= t

        if (location) contApple++

    }

    oranges.forEachIndexed { i, item ->

        oranges[i] = oranges[i] + b

        val location = oranges[i] >= s && oranges[i] <= t

        if (location) contOrange++

    }

    print(contApple)
    println()
    print(contOrange)

}

/**
 *
 * get the same position in same time the twos kangaroo
 *
 * */

fun kangaroo(x1: Int, v1: Int, x2: Int, v2: Int): String {

    val count = 10000
    var ka1 = x1
    var ka2 = x2

    for (i in 1..count) {

        if (x2 > x1) {
            if (v2 > v1) {
                return "NO"
            }
        }

        ka1 += v1
        ka2 += v2

        if (ka1 == ka2) {
            return "YES"
        }

    }

    return "NO"
}

/** Test case print(catAndMouse(2, 5, 4)) **/
fun catAndMouse(x: Int, y: Int, z: Int): String {
    /**
     * Developed by Guilherme Antônio (Software Enginner) exercise from HackerRank.
     * Two cats and a mouse are at various positions on a line. You will be given their starting positions.
     * Your task is to determine which cat will reach the mouse first, assuming the mouse doesn't move and the cats travel at
     * equal speed. If the cats arrive at the same time, the mouse will be allowed to move and it will escape while they fight.
     * If cat A catches the mouse first, print Cat A.
     * If cat B catches the mouse first, print Cat B.
     * If both cats reach the mouse at the same time, print Mouse C as the two cats fight and mouse escapes.
     */
    val resultX = if (z > x) z.minus(x) else x.minus(z)
    val resultY = if (z > y) z.minus(y) else y.minus(z)
    when {
        resultX < resultY -> return "Cat A"
        resultX > resultY -> return "Cat B"
        resultX == resultY -> return "Mouse C"
    }
    return ""
}

