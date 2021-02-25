package vector

abstract class Coordinates(x: Double, y: Double, z: Double): Vector3<Double>(x, y, z) {
    companion object {
        val HERE = RelativeCoordinates(0, 0, 0)
        val ORIGIN = AbsoluteCoordinates(0.0, 0.0, 0.0)

        fun forward(amount: Double): LocalCoordinates {
            return LocalCoordinates(0.0, 0.0, amount)
        }
        fun forward(amount: Int): LocalCoordinates {
            return forward(amount.toDouble())
        }
    }
}

class AbsoluteCoordinates(x: Double, y: Double, z: Double): Coordinates(x, y, z) {
    constructor(x: Int, y: Int, z: Int): this(x.toDouble(), y.toDouble(), z.toDouble())

    override fun toString(): String {
        return "$x $y $z"
    }
}

class RelativeCoordinates(x: Double, y: Double, z: Double): Coordinates(x, y, z) {
    constructor(x: Int, y: Int, z: Int): this(x.toDouble(), y.toDouble(), z.toDouble())

    override fun toString(): String {
        val strings: Vector3<String> = this.map { if (it == 0.0) "" else it.toString() }
        return "~${strings.x} ~${strings.y} ~${strings.z}"
    }
}

class LocalCoordinates(left: Double, up: Double, forward: Double): Coordinates(left, up, forward) {
    constructor(left: Int, up: Int, forward: Int): this(left.toDouble(), up.toDouble(), forward.toDouble())

    override fun toString(): String {
        val strings: Vector3<String> = this.map { if (it == 0.0) "" else it.toString() }
        return "^${strings.x} ^${strings.y} ^${strings.z}"
    }
}