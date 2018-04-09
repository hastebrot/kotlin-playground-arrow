package hello

import arrow.effects.IO
import arrow.optics.Lens

fun main(vararg args: String) {
    val fooValue: Lens<Foo, Int> = Lens(
        get = { foo -> foo.value },
        set = { value -> { foo -> foo.copy(value = value) } }
    )

    val foo = Foo(5)
    fooValue.get(foo).println
    fooValue.set(foo, 10).println
    fooValue.get(fooValue.set(foo, 10)).println
    fooValue.modify(foo) { it + 1 }.println

    val fooValueLift = fooValue.lift { it + 1 }
    fooValueLift(foo).println

    IO<Int> { error("io error") }.attempt().println
}

data class Foo(val value: Int)

val <T> T.println
    get() = println(this)
