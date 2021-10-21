package com.tuliomagalhaes.algorithms

/*fun Int.fibonacci(): Int {
    val values = arrayListOf(0)

    for (i in 1..this) {
        val fib = if (values.size >= 2) {
            values[values.lastIndex] + values[values.lastIndex - 1]
        } else {
            1
        }
        values.add(fib)
    }

    return values.last()
}*/

/*fun Int.fibonacci(): Int {
    if (this < 2) {
        return this
    }
    return (this - 1).fibonacci() + (this - 2).fibonacci()
}*/

fun Int.fibonacci(): Int {
    if (this < 2) {
        return this
    }

    val fibCalls = mutableListOf<Int>()

    return (this - 1).fibonacci(fibCalls) + (this - 2).fibonacci(fibCalls)
}

private fun Int.fibonacci(fibCalls: MutableList<Int>): Int {
    when {
        this < 2 -> return this
        fibCalls.contains(this) -> {
            return fibCalls[fibCalls.indexOf(this)]
        }
        else -> fibCalls.add(this)
    }

    return (this - 1).fibonacci() + (this - 2).fibonacci()
}
