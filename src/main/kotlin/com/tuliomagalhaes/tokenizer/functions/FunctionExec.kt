package com.tuliomagalhaes.tokenizer.functions

interface FunctionExec<T> {
    fun execute(params: List<Any?>): T
}