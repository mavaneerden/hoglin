package target

import vector.Vector2
import vector.Vector3
import vector.Volume
import scoreboard.Score
import utilities.arrayArgumentToString
import utilities.mapToString

class PlayerSelector(
    var level: IntRange? = null,
    var gamemode: Array<Gamemode>? = null,
    var advancements: String? = null,  // TODO: Create Advancement type or something
    position: Vector3<Double?>? = null,
    volume: Volume? = null,
    distance: ClosedFloatingPointRange<Double>? = null,
    scores: Map<Score, IntRange>? = null,
    tag: Array<String>? = null,
    team: Array<String>? = null,       // TODO: Create Team type
    limit: Int? = null,
    sort: Sort? = null,
    name: String? = null,
    rotation: Vector2<ClosedFloatingPointRange<Double>?>? = null,
    nbt: Array<String>? = null,        // TODO: Create NBT type or something
    predicate: Array<String>? = null   // TODO: Create Predicate type or something
): Selector(position, volume, distance, scores, tag, team, limit, sort, name, rotation, nbt, predicate) {
    companion object {
        const val ARGUMENT_AMOUNT = 15
    }

    override fun toString(): String {
        val selectorVariable: SelectorVariable =
            if (sort == Sort.NEAREST && limit == 1) {
                SelectorVariable.NEAREST_PLAYER
            }
            else if (sort == Sort.RANDOM && limit == 1) {
                SelectorVariable.RANDOM_PLAYER
            }
            else {
                SelectorVariable.ALL_PLAYERS
            }
        val arguments: ArrayList<String?> = ArrayList<String?>(ARGUMENT_AMOUNT).apply {
            // TODO: Put in Selector class
            add(gamemode?.let { arrayArgumentToString(gamemode, ::gamemode.name) })
            add(team?.let { arrayArgumentToString(team, ::team.name) })
            add(tag?.let { arrayArgumentToString(tag, ::tag.name) })
            add(name?.let { "${::name.name}=\"$name\"" })
            add(scores?.let { "${::scores.name}={${mapToString(scores!!)}}" })
        }
        return ""
    }
}

