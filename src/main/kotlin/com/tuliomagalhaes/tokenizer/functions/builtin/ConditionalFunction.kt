package com.tuliomagalhaes.tokenizer.functions.builtin

import com.tuliomagalhaes.tokenizer.functions.FunctionExec
import com.tuliomagalhaes.tokenizer.util.requireParams
import java.lang.IllegalStateException

class ConditionalFunction : FunctionExec<Any?> {

    override fun execute(params: List<Any?>): Any? {
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
}