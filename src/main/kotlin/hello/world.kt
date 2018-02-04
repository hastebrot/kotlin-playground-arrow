package hello

import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import arrow.core.getOrElse
import arrow.data.Try

inline val <T> Some<T>.value get() = this.t

fun main(vararg args: String) {
    run {
        val someValue: Option<String> = Some("foo")
        someValue.getOrElse { "bar" }.println
    }

    run {
        val noneValue = None
        noneValue.getOrElse { "bar" }.println
    }

    run {
        val someValue: Option<Double> = Some(20.0)
        val value = when (someValue) {
            is Some -> someValue.value
            None -> 0.0
        }
        value.println
    }

    run {
        Option(1).map { it + 1 }.println
        None.map { it }.println
    }

    run {
        Try<Int> { error("failed") }.map { it + 1 }.println
        Try { 5 }.map { it + 1 }.println
    }
}
