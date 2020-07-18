package com.tuliomagalhaes.tokenizer.functions.builtin

import com.tuliomagalhaes.tokenizer.functions.FunctionExec
import com.tuliomagalhaes.tokenizer.util.requireParams
import com.tuliomagalhaes.tokenizer.util.throwsArgumentMismatch

class GreaterFunction : FunctionExec<Boolean> {

    override fun execute(params: List<Any?>): Boolean {
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
}