package control.conditions

import scoreboard.Score
import scoreboard.ScoreboardComparison


sealed class ConditionData


class ScoreConditionData(
    private val target: Score,
    private val comparison: ScoreboardComparison,
    private val source: Any
): ConditionData() {
    init {
        if (!(source is Score || source is Int || source is IntRange)) {
            throw IllegalArgumentException("'source' must be 'Score', 'Int' or 'IntRange'.")
        }
    }

    override fun toString(): String {
        return "$target $comparison $source"
    }
}