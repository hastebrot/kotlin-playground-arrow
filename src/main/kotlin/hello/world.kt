package hello

import kategory.Option
import kategory.Try
import kategory.getOrElse

fun main(vararg args: String) {
    run {
        val someValue: Option<String> = Option.Some("foo")
        someValue.getOrElse { "bar" }.println
    }

    run {
        val noneValue = Option.None
        noneValue.getOrElse { "bar" }.println
    }

    run {
        val someValue: Option<Double> = Option.Some(20.0)
        val value = when (someValue) {
            is Option.Some -> someValue.value
            is Option.None -> 0.0
        }
        value.println
    }

    run {
        Option(1).map { it + 1 }.println
        Option.None.map { it }.println
    }

    run {
        Try<Int> { error("failed") }.map { it + 1 }.println
        Try { 5 }.map { it + 1 }.println
    }

    run {
//        Option.monad().binding {
//
//        }
    }
}
