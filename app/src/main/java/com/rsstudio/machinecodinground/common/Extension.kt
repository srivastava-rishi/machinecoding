package com.rsstudio.machinecodinground.common

fun String.addArgs(args: String) = this.plus("?").plus(args).plus("={").plus(args).plus("}")

fun String.withArgs(args: String, value: String) = this.plus("?").plus(args).plus("=").plus(value)