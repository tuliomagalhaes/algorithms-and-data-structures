package com.tuliomagalhaes.tokenizer.functions

import com.tuliomagalhaes.tokenizer.Function
import com.tuliomagalhaes.tokenizer.functions.builtin.ConditionalFunction
import com.tuliomagalhaes.tokenizer.functions.builtin.GreaterFunction
import com.tuliomagalhaes.tokenizer.functions.builtin.SumFunction
import java.lang.IllegalStateException

class FunctionExecuter {

    fun execute(function: Function): Any? {
        val exec: FunctionExec<*> = when (function.name) {
            "gt" -> GreaterFunction()
            "sum" -> SumFunction()
            "conditional" -> ConditionalFunction()
            else -> throw IllegalStateException("Function ${function.name} does not exists")
        }
        return exec.execute(function.params)
    }
}