package target

import vector.Vector2
import vector.Vector3
import vector.Volume
import scoreboard.Score

class EntitySelector(
    var type: Array<EntityType?>? = null,
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
}