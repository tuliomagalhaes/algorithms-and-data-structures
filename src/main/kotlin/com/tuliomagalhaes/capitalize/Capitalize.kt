package com.tuliomagalhaes.capitalize

fun String.capitalize(): String {
    val newString = StringBuilder()
    newString.append(this[0].toUpperCase())

    for (i in 1 until this.length) {
        if (this[i - 1] == ' ') {
            newString.append(this[i].toUpperCase())
        } else {
            newString.append(this[i])
        }
    }

    return newString.toString()
}

/*
fun String.capitalize(): String {
    return this.split(" ").map {
        val capitalized = it[0].toUpperCase()
        "$capitalized${it.slice(1 until it.length)}"
    }.joinToString(separator = " ") { it }
}

fun String.capitalize(): String {
    val newString = StringBuilder()

    var shouldCapitalize = true
    this.forEach {
        if (shouldCapitalize) {
            newString.append(it.toUpperCase())
        } else {
            newString.append(it)
        }

        shouldCapitalize = it == ' '
    }

    return newString.toString()
}*/
