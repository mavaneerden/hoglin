package vector

class Volume(private val from: AbsoluteCoordinates, private val to: AbsoluteCoordinates) {
    constructor(from: AbsoluteCoordinates, dimensions: Vector3<Double>): this(from, (from + dimensions) as
            AbsoluteCoordinates)

    var dx: Double? = null
    var dy: Double? = null
    var dz: Double? = null

    companion object {
        private val DELTA_THRESHOLD = -0.00001..0.00001
    }

    init {
        val delta = to - from

        if (delta.x !in DELTA_THRESHOLD) {
            dx = delta.x - 1.0
        }
        if (delta.y !in DELTA_THRESHOLD) {
            dy = delta.y - 1.0
        }
        if (delta.z !in DELTA_THRESHOLD) {
            dz = delta.z - 1.0
        }
    }
}