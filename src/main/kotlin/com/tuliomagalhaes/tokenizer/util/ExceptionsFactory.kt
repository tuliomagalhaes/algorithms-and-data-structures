package com.tuliomagalhaes.tokenizer.util

import java.lang.Exception
import java.lang.IllegalStateException
import java.lang.StringBuilder

fun requireParams(funcName: String, paramsSize: Int, count: Int) {
    require(paramsSize == count) {
        "$funcName function expect minimum $count parameters, and got just $paramsSize"
    }
}

fun throwsArgumentMismatch(vararg args: Any?): Exception {
    val arguments = StringBuilder()
    args.forEachIndexed { index, item ->
        arguments.append("Argument #$index=$item\n")
    }
    return IllegalStateException("Argument types does not match.\n$arguments")
}

