package vector

class Vector2<T>(val x: T, val y: T) {
    fun <R> map(func: (T) -> R): Vector2<R> {
        return Vector2(func(x), func(y))
    }
}
