package hello

import kategory.Option
import kategory.getOrElse

fun main(args: Array<String>) {
    val someValue: Option<String> = Option.Some("foo")
    println(someValue.getOrElse { "bar" })

    val noneValue = Option.None
    println(noneValue.getOrElse { "bar" })

    val otherValue: Option<Double> = Option.Some(20.0)
    val value = when (otherValue) {
        is Option.Some -> otherValue.value
        is Option.None -> 0.0
    }
    println(value)
}
