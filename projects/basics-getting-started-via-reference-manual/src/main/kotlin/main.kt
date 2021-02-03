package com.brian.kotlinStarts

import kotlin.*
import kotlin.io.*
//import kotlin.script.*

// What lives here?
//import kotlin.experimental

// Runtime Related?
//import kotlin.jdk7
//import kotlin.jvm
//import kotlin.js

// Kotlin Nouns:
//    - Companion objects
//    - Extension methods


data class DataObject(
    val field1: String,
    val field2: String,
    val field3: String,
    val field4: String,
    val field5: String,
    val field6: String)



fun main(args: Array<String>) {
    println("Hello World!")

    aNewFn()
    val someValue: Int
    someValue = aNewFnWitRet()
    println("$someValue has a value of that!")

    val aNewFnWitRet = aNewFnWitRet()
    println("$aNewFnWitRet is a new random number")

    conditionals("hello")
    conditionals("hello1")
    conditionals("its an else?")

    someVars()

    rangesCollectionsMapsEtc()
}


fun aNewFn() {
    println("aNewFn()")
}

/**
 * Function that returns something....
 */
val rand = kotlin.random.Random(34)
fun aNewFnWitRet(): Int {

    return rand.nextInt()
}

fun someVars() {
    val aval_variable: Int // No reassignment
    var avar_variable: Int // Reassignment

    aval_variable = 1
    avar_variable = 2
    println("aval_variable: $aval_variable")
    println("avar_variable: $avar_variable")

//    aval_variable = 2
    avar_variable = 4

    println("aval_variable: $aval_variable")
    println("avar_variable: $avar_variable")
}

fun conditionals(arg: String) {
    if (arg.length == 5) {
        println("its 5")
    } else if (arg.length == 6) {
        println("its 6")
    } else {
        println("its not 5, its not 6!!")
    }
}

fun rangesCollectionsMapsEtc() {
    // Ranges
    val l = 1..100
    println("$l")
    for (e in l) {
        println(e)
    }

    // Collections
    val numsList = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten")
    println("$numsList")

// Maps
}

fun createOneHundredDataObjects() {
    var els = []
    for (el in 1..100) {
        val doins = DataObject("one" + el, "two" + el, "three" + el, "four" + el, "five" + el, "six"  + el)
        els. << doins
    }
}

fun someOfs() {
    listOf()
    arrayOf()
    mapOf()
}