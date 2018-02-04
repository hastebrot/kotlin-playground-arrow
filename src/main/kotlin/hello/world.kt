package hello

import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import arrow.core.applicative
import arrow.core.ev
import arrow.core.getOrElse
import arrow.core.monad
import arrow.data.Try
import arrow.syntax.applicative.map
import arrow.syntax.option.none
import arrow.typeclasses.binding
import java.util.UUID

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
        Try { 2 }.map { it + 1 }.println
    }

    // FP in Kotlin with Arrow Options
    // https://www.youtube.com/watch?v=5SFTbphderE

    run {
        val maybeOne = Option(1)
//        val maybeTwo = Option(2)
        val maybeTwo = none<Int>()
        val maybeThree = Option(3)

        Option.monad().binding {
            val one = maybeOne.bind()
            val two = maybeTwo.bind()
            val three = maybeThree.bind()
            one + two + three
        }.ev().println
    }

    run {
        val maybeId = Option(UUID.randomUUID())
        val maybeName = Option("foo bar")
        val maybeAge = Option(123)

        Option.applicative().map(maybeId, maybeName, maybeAge, { (id, name, age) ->
            id to name to age
        }).ev().println
    }
}
