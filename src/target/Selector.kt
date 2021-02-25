package target

import vector.Vector2
import vector.Vector3
import vector.Volume
import scoreboard.Score
import utilities.COMPOUND_SEPARATOR

abstract class Selector(
    var position: Vector3<Double?>? = null,
    var volume: Volume? = null,
    var distance: ClosedFloatingPointRange<Double>? = null,
    var scores: Map<Score, IntRange>? = null,
    var tag: Array<String>? = null,     // TODO: Create Tag type
    var team: Array<String>? = null,    // TODO: Create Team type
    var limit: Int? = null,
    var sort: Sort? = null,
    var name: String? = null,
    var rotation: Vector2<ClosedFloatingPointRange<Double>?>? = null,
    var nbt: Array<String>? = null,        // TODO: Create NBT type or something
    var predicate: Array<String>? = null   // TODO: Create Predicate type or something
): Target() {
    fun positionToString(): String? {
        return position?.run {
            val strings: Array<String?> = arrayOf(x?.toString(), y?.toString(), z?.toString())
            var counter = 0

            strings.joinToString(COMPOUND_SEPARATOR) {
                when(counter++) {
                    0 -> "x=$it"
                    1 -> "y=$it"
                    else -> "z=$it"
                }
            }
        }
    }
}