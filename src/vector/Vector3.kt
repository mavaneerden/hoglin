package vector

open class Vector3<T>(val x: T, val y: T, val z: T) {
    operator fun plus(other: Vector3<Double>): Vector3<Double> {
        return Vector3(x as Double + other.x, y as Double + other.y, z as Double + other.z)
    }

    operator fun minus(other: Vector3<Double>): Vector3<Double> {
        return Vector3(x as Double - other.x, y as Double - other.y, z as Double - other.z)
    }

    fun <R> map(func: (T) -> R): Vector3<R> {
        return Vector3(func(x), func(y), func(z))
    }
}
