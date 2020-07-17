package com.tuliomagalhaes.tokenizer

import java.lang.Exception
import java.lang.IllegalStateException
import java.lang.StringBuilder

class FunctionExecuter {

    fun execute(function: Function): Any? {
        return when (function.name) {
            "gt" -> gt(function.params)
            "sum" -> sum(function.params)
            "conditional" -> conditional(function.params)
            else -> IllegalStateException("Function ${function.name} does not exists")
        }
    }

    private fun gt(params: List<Any?>): Boolean {
        requireParams("gt", params.size, 2)

        val value1 = params[0]
        val value2 = params[1]

        return if (value1 is Int && value2 is Int) {
            value1 > value2
        } else if (value1 is Double && value2 is Double) {
            value1 > value2
        } else {
            throw throwsArgumentMismatch(value1, value2)
        }
    }

    private fun sum(params: List<Any?>): Number {
        requireParams("sum", params.size, 2)

        val value1 = params[0]
        val value2 = params[1]

        return if (value1 is Int && value2 is Int) {
            value1 + value2
        } else if (value1 is Double && value2 is Double) {
            value1 + value2
        } else {
            throw throwsArgumentMismatch(value1, value2)
        }
    }

    private fun conditional(params: List<Any?>): Any? {
        requireParams("conditional", params.size, 3)

        val condition = params[0]
        return if (condition is Boolean) {
            if (condition) {
                params[1]
            } else {
                params[2]
            }
        } else {
            throw IllegalStateException("First parameter must be a boolean, but got $condition")
        }
    }

    private fun requireParams(funcName: String, paramsSize: Int, count: Int) {
        require(paramsSize == count) {
            "$funcName function expect minimum $count parameters, and got just $paramsSize"
        }
    }

    private fun throwsArgumentMismatch(vararg args: Any?): Exception {
        val arguments = StringBuilder()
        args.forEachIndexed { index, item ->
            arguments.append("Argument #$index=$item\n")
        }
        return IllegalStateException("Argument types does not match.\n$arguments")
    }
}