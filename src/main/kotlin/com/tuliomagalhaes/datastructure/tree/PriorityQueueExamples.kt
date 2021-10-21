package com.tuliomagalhaes.datastructure.tree

import java.util.*

fun ascendingOrder() {
    val priorityQueue = PriorityQueue<Int>(10)

    priorityQueue.add(40)
    priorityQueue.add(50)
    priorityQueue.add(30)
    priorityQueue.add(10)
    priorityQueue.add(20)

    println("ASCENDING:")
    while (priorityQueue.isNotEmpty()) {
        print("${priorityQueue.poll()} ")
    }
}

fun descendingOrder() {
    val priorityQueue = PriorityQueue<Int>(reverseOrder())

    priorityQueue.add(40)
    priorityQueue.add(50)
    priorityQueue.add(30)
    priorityQueue.add(10)
    priorityQueue.add(20)

    println("DESCENDING:")
    while (priorityQueue.isNotEmpty()) {
        print("${priorityQueue.poll()} ")
    }
}

private fun personsByAge() {
    data class Person(
        val age: Int
    )

    val persons = listOf(Person(1),Person(80), Person(5), Person(2), Person(15), Person(8))
    val personByAge = PriorityQueue<Person> { a, b -> b.age - a.age }
    personByAge.addAll(persons)

    while (personByAge.isNotEmpty()) {
        print("${personByAge.poll().age} ")
    }
}

fun main() {
    ascendingOrder()
    println()
    descendingOrder()
    println()
    personsByAge()
}