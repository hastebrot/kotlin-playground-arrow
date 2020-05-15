package hello

import arrow.fx.IO

fun main(vararg args: String) {
    IO<Int> { error("io error") }.attempt().println
}

