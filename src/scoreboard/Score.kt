package scoreboard


import control.conditions.Condition
import control.conditions.Condition.Companion.createScoreCondition
import control.conditions.ScoreConditionData
import target.EntitySelector
import target.FakePlayer
import target.PlayerSelector
import target.Target


class Score(val holder: Target, val objective: Objective) {
    constructor(holder: PlayerSelector, objective: Objective) : this(holder as Target, objective)
    constructor(holder: EntitySelector, objective: Objective) : this(holder as Target, objective)
    constructor(holder: FakePlayer, objective: Objective) : this(holder as Target, objective)

    companion object {
        private var instanceCount = 0
    }

    private val id = instanceCount++

    operator fun plus(other: Int): Score {
        this.add(other)
        return this
    }

    operator fun plus(other: Score): Score {
        this.add(other)
        return this
    }

    operator fun plusAssign(other: Int) {
        this.add(other)
    }

    operator fun plusAssign(other: Score) {
        this.add(other)
    }

    operator fun inc(): Score {
        this.add(1)
        return this
    }

    /**
     * Add an integer value to the score's value.
     *
     * @param other Value to add.
     */
    fun add(other: Int) {
        // TODO: scoreboard players remove {this} {other}
        println("scoreboard players remove $this $other")
    }

    /**
     * Add the value of another score to the score's value.
     *
     * @param other Score to add the value of.
     */
    fun add(other: Score) {
        // TODO: scoreboard players operation {this} += {other}
        println("scoreboard players operation $this += $other")
    }

    operator fun minus(other: Int): Score {
        this.remove(other)
        return this
    }

    operator fun minus(other: Score): Score {
        this.remove(other)
        return this
    }

    operator fun minusAssign(other: Int) {
        this.remove(other)
    }

    operator fun minusAssign(other: Score) {
        this.remove(other)
    }

    operator fun dec(): Score {
        this.remove(1)
        return this
    }

    /**
     * Remove an integer value from the score's value.
     *
     * @param other Value to remove.
     */
    fun remove(other: Int) {
        // TODO: scoreboard players remove {this} {other}
        println("scoreboard players remove $this $other")
    }

    /**
     * Remove the value of another score from the score's value.
     *
     * @param other Score to remove the value of.
     */
    fun remove(other: Score) {
        // TODO: scoreboard players operation {this} -= {other}
        println("scoreboard players operation $this -= $other")
    }

    operator fun times(other: Int): Score {
        this.multiply(other)
        return this
    }

    operator fun times(other: Score): Score {
        this.multiply(other)
        return this
    }

    operator fun timesAssign(other: Int) {
        this.multiply(other)
    }

    operator fun timesAssign(other: Score) {
        this.multiply(other)
    }

    /**
     * Do a multiplication operation on this score with an integer value.
     *
     * @param other Value to use in the multiplication operation.
     */
    fun multiply(other: Int) {
        // TODO: Create constant.
        // TODO: scoreboard players operation {this} *= {fakePlayer} {other}
        println("scoreboard players operation $this *= {fakePlayer} $other")
    }

    /**
     * Do a multiplication operation on this score with another score.
     *
     * @param other Score's value to use in the multiplication operation.
     */
    fun multiply(other: Score) {
        // TODO: scoreboard players operation {this} *= {other}
        println("scoreboard players operation $this *= $other")
    }

    operator fun div(other: Int): Score {
        this.divide(other)
        return this
    }

    operator fun div(other: Score): Score {
        this.divide(other)
        return this
    }

    operator fun divAssign(other: Int) {
        this.divide(other)
    }

    operator fun divAssign(other: Score) {
        this.divide(other)
    }

    /**
     * Do a division operation on this score with an integer value.
     *
     * @param other Value to use in the division operation.
     */
    fun divide(other: Int) {
        // TODO: Create constant.
        // TODO: scoreboard players operation {this} /= {fakePlayer} {other}
        println("scoreboard players operation $this /= {fakePlayer} $other")
    }

    /**
     * Do a division operation on this score with another score.
     *
     * @param other Score's value to use in the division operation.
     */
    fun divide(other: Score) {
        // TODO: scoreboard players operation {this} /= {other}
        println("scoreboard players operation $this /= $other")
    }

    operator fun rem(other: Int): Score {
        this.remainder(other)
        return this
    }

    operator fun rem(other: Score): Score {
        this.remainder(other)
        return this
    }

    operator fun remAssign(other: Int) {
        this.remainder(other)
    }

    operator fun remAssign(other: Score) {
        this.remainder(other)
    }

    /**
     * Do a modulo operation on this score with an integer value.
     *
     * @param other Value to use in the modulo operation.
     */
    fun remainder(other: Int) {
        // TODO: Create constant.
        // TODO: scoreboard players operation {this} %= {fakePlayer} {other}
        println("scoreboard players operation $this %= {fakePlayer} $other")
    }

    /**
     * Do a modulo operation on this score with another score.
     *
     * @param other Score's value to use in the modulo operation.
     */
    fun remainder(other: Score) {
        // TODO: scoreboard players operation {this} %= {other}
        println("scoreboard players operation $this %= $other")
    }

    /**
     * Swap the values of two scores.
     *
     * @param other Score to swap the value with.
     */
    fun swap(other: Score) {
        // TODO: scoreboard players operation {this} >< {other}
        println("scoreboard players operation $this >< $other")
    }

    /**
     * Get the minimum value of a score and store it into this score.
     *
     * @param other Score to get the minimum value of.
     */
    fun min(other: Score) {
        // TODO: scoreboard players operation {this} < {other}
        println("scoreboard players operation $this < $other")
    }

    /**
     * Get the maximum value of a score and store it into this score.
     *
     * @param other Score to get the maximum value of.
     */
    fun max(other: Score) {
        // TODO: scoreboard players operation {this} > {other}
        println("scoreboard players operation $this > $other")
    }

    /**
     * Check if the value of this score is less than an integer value.
     *
     * @param other Value to compare against.
     */
    infix fun lt(other: Int): Condition {
        // TODO: if/unless score {this} matches ..{other - 1}
        return createScoreCondition(ScoreConditionData(this, ScoreboardComparison.LESS_THAN, other))
    }

    /**
     * Check if the value of this score is less than the value of the other score.
     *
     * @param other Score to compare against.
     */
    infix fun lt(other: Score): Condition {
        // TODO: if/unless score {this} < {other}
        return createScoreCondition(ScoreConditionData(this, ScoreboardComparison.LESS_THAN, other))
    }

    /**
     * Check if the value of this score is less than or equal to an integer value.
     *
     * @param other Value to compare against.
     */
    infix fun lte(other: Int): Condition {
        // TODO: if/unless score {this} matches ..{other}
        return createScoreCondition(ScoreConditionData(this, ScoreboardComparison.LESS_THAN_EQUAL, other))
    }

    /**
     * Check if the value of this score is less than or equal to the value of the other score.
     *
     * @param other Score to compare against.
     */
    infix fun lte(other: Score): Condition {
        // TODO: if/unless score {this} <= {other}
        return createScoreCondition(ScoreConditionData(this, ScoreboardComparison.LESS_THAN_EQUAL, other))
    }

    /**
     * Check if the value of this score is greater than an integer value.
     *
     * @param other Value to compare against.
     */
    infix fun gt(other: Int): Condition {
        // TODO: if/unless score {this} matches {other + 1}..
        return createScoreCondition(ScoreConditionData(this, ScoreboardComparison.GREATER_THAN, other))
    }

    /**
     * Check if the value of this score is greater than the value of the other score.
     *
     * @param other Score to compare against.
     */
    infix fun gt(other: Score): Condition {
        // TODO: if/unless score {this} > {other}
        return createScoreCondition(ScoreConditionData(this, ScoreboardComparison.GREATER_THAN, other))
    }

    /**
     * Check if the value of this score is greater than or equal to an integer value.
     *
     * @param other Value to compare against.
     */
    infix fun gte(other: Int): Condition {
        // TODO: if/unless score {this} matches {other}..
        return createScoreCondition(ScoreConditionData(this, ScoreboardComparison.GREATER_THAN_EQUAL, other))
    }

    /**
     * Check if the value of this score is greater than or equal to the value of the other score.
     *
     * @param other Score to compare against.
     */
    infix fun gte(other: Score): Condition {
        // TODO: if/unless score {this} >= {other}
        return createScoreCondition(ScoreConditionData(this, ScoreboardComparison.GREATER_THAN_EQUAL, other))
    }

    /**
     * Check if the value of this score is equal to an integer value.
     *
     * @param other Value the score should be equal to.
     */
    infix fun matches(other: Int): Condition {
        // TODO: if/unless score {this} matches {other}
        return createScoreCondition(ScoreConditionData(this, ScoreboardComparison.MATCHES, other))
    }

    /**
     * Check if the value of this score is within a range.
     *
     * @param other Range that the value should be in.
     */
    infix fun matches(other: IntRange): Condition {
        // TODO: if/unless score {this} matches {other}
        return createScoreCondition(ScoreConditionData(this, ScoreboardComparison.MATCHES, other))
    }

    /**
     * Check if the value of this score matches the value of the other.
     *
     * @param other Other score to match the value with.
     */
    infix fun matches(other: Score): Condition {
        // TODO: if/unless score {this} = {other}
        return createScoreCondition(ScoreConditionData(this, ScoreboardComparison.EQUAL, other))
    }

    /**
     * Reset the value of the score.
     */
    fun reset() {
        // TODO: scoreboard players reset {this}
        println("scoreboard players reset $this")
    }

    /**
     * Set the value of the score to an integer value.
     *
     * @param value The value to set.
     */
    fun set(value: Int) {
        // TODO: scoreboard players set {this} {value}
        println("scoreboard players set $this $value")
    }

    /**
     * Copy the value of one score to the other.
     *
     * @param other The score to copy the value of.
     */
    fun set(other: Score) {
        // TODO: scoreboard players operation {this} = {other}
        println("scoreboard players operation $this = $other")
    }

    /**
     * Get the value of the score.
     */
    fun get() {
        // TODO: scoreboard players get {this}
        println("scoreboard players get $this")
    }

    override fun toString(): String {
        return "${this.holder} ${this.objective}"
    }

    override fun hashCode(): Int {
        var result = objective.hashCode()
        result = 31 * result + holder.hashCode()
        return result
    }

    // override fun equals(other: Any?): Boolean {
    //     if (this === other) return true
    //     if (javaClass != other?.javaClass) return false
    //
    //     other as Score
    //
    //     if (objective != other.objective) return false
    //     if (holder != other.holder) return false
    //     if (id != other.id) return false
    //
    //     return true
    // }
}

enum class ScoreboardComparison {
    LESS_THAN,
    LESS_THAN_EQUAL,
    EQUAL,
    MATCHES,
    GREATER_THAN,
    GREATER_THAN_EQUAL;

    override fun toString(): String {
        return when(this) {
            LESS_THAN           -> "<"
            LESS_THAN_EQUAL     -> "<="
            EQUAL               -> "="
            MATCHES             -> "matches"
            GREATER_THAN        -> ">"
            GREATER_THAN_EQUAL  -> ">="
        }
    }
}