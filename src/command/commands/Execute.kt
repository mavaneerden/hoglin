package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector
abstract class RootExecuteCommandRedirect(
    parent: CommandNode?,
    argOrLiteral: Any?
): CommandNode(parent, argOrLiteral) {
    fun redirect(): RootExecuteCommand {
        return RootExecuteCommand(this, null)
    }
}


class RootExecuteAlignAxesCommand(
    parent: CommandNode,
    axes: String
): RootExecuteCommandRedirect(parent, axes)

class RootExecuteAlignCommand(
    parent: CommandNode
): CommandLiteral(parent, "align") {
    fun axes(axes: String): RootExecuteCommand {
        return RootExecuteAlignAxesCommand(this, axes).redirect()
    }

    operator fun invoke(axes: String): RootExecuteCommand {
        return axes(axes)
    }
}

class RootExecuteAnchoredAnchorCommand(
    parent: CommandNode,
    anchor: String
): RootExecuteCommandRedirect(parent, anchor)

class RootExecuteAnchoredCommand(
    parent: CommandNode
): CommandLiteral(parent, "anchored") {
    fun anchor(anchor: String): RootExecuteCommand {
        return RootExecuteAnchoredAnchorCommand(this, anchor).redirect()
    }

    operator fun invoke(anchor: String): RootExecuteCommand {
        return anchor(anchor)
    }
}

class RootExecuteAsTargetsCommand(
    parent: CommandNode,
    targets: Selector
): RootExecuteCommandRedirect(parent, targets)

class RootExecuteAsCommand(
    parent: CommandNode
): CommandLiteral(parent, "as") {
    fun targets(targets: Selector): RootExecuteCommand {
        return RootExecuteAsTargetsCommand(this, targets).redirect()
    }

    operator fun invoke(targets: Selector): RootExecuteCommand {
        return targets(targets)
    }
}

class RootExecuteAtTargetsCommand(
    parent: CommandNode,
    targets: Selector
): RootExecuteCommandRedirect(parent, targets)

class RootExecuteAtCommand(
    parent: CommandNode
): CommandLiteral(parent, "at") {
    fun targets(targets: Selector): RootExecuteCommand {
        return RootExecuteAtTargetsCommand(this, targets).redirect()
    }

    operator fun invoke(targets: Selector): RootExecuteCommand {
        return targets(targets)
    }
}

class RootExecuteFacingEntityTargetsAnchorCommand(
    parent: CommandNode,
    anchor: String
): RootExecuteCommandRedirect(parent, anchor)

class RootExecuteFacingEntityTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    fun anchor(anchor: String): RootExecuteCommand {
        return RootExecuteFacingEntityTargetsAnchorCommand(this, anchor).redirect()
    }
}

class RootExecuteFacingEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun targets(targets: Selector): RootExecuteFacingEntityTargetsCommand {
        return RootExecuteFacingEntityTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector, anchor: String): RootExecuteCommand {
        return targets(targets).anchor(anchor)
    }
}

class RootExecuteFacingPosCommand(
    parent: CommandNode,
    pos: Coordinates
): RootExecuteCommandRedirect(parent, pos)

class RootExecuteFacingCommand(
    parent: CommandNode
): CommandLiteral(parent, "facing") {
    val entity = RootExecuteFacingEntityCommand(this)

        fun pos(pos: Coordinates): RootExecuteCommand {
        return RootExecuteFacingPosCommand(this, pos).redirect()
    }

    operator fun invoke(pos: Coordinates): RootExecuteCommand {
        return pos(pos)
    }
}

class RootExecuteIfBlockPosBlockCommand(
    parent: CommandNode,
    block: String
): RootExecuteCommandRedirect(parent, block)

class RootExecuteIfBlockPosCommand(
    parent: CommandNode,
    pos: String
): CommandArgument(parent, pos) {
    fun block(block: String): RootExecuteCommand {
        return RootExecuteIfBlockPosBlockCommand(this, block).redirect()
    }
}

class RootExecuteIfBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun pos(pos: String): RootExecuteIfBlockPosCommand {
        return RootExecuteIfBlockPosCommand(this, pos)
    }

    operator fun invoke(pos: String, block: String): RootExecuteCommand {
        return pos(pos).block(block)
    }
}

class RootExecuteIfBlocksStartEndDestinationAllCommand(
    parent: CommandNode
): RootExecuteCommandRedirect(parent, "all")

class RootExecuteIfBlocksStartEndDestinationMaskedCommand(
    parent: CommandNode
): RootExecuteCommandRedirect(parent, "masked")

class RootExecuteIfBlocksStartEndDestinationCommand(
    parent: CommandNode,
    destination: String
): CommandArgument(parent, destination) {
    val all = RootExecuteIfBlocksStartEndDestinationAllCommand(this).redirect()
    val masked = RootExecuteIfBlocksStartEndDestinationMaskedCommand(this).redirect()
}

class RootExecuteIfBlocksStartEndCommand(
    parent: CommandNode,
    end: String
): CommandArgument(parent, end) {
    fun destination(destination: String): RootExecuteIfBlocksStartEndDestinationCommand {
        return RootExecuteIfBlocksStartEndDestinationCommand(this, destination)
    }
}

class RootExecuteIfBlocksStartCommand(
    parent: CommandNode,
    start: String
): CommandArgument(parent, start) {
    fun end(end: String): RootExecuteIfBlocksStartEndCommand {
        return RootExecuteIfBlocksStartEndCommand(this, end)
    }
}

class RootExecuteIfBlocksCommand(
    parent: CommandNode
): CommandLiteral(parent, "blocks") {
    fun start(start: String): RootExecuteIfBlocksStartCommand {
        return RootExecuteIfBlocksStartCommand(this, start)
    }

    operator fun invoke(start: String, end: String, destination: String): RootExecuteIfBlocksStartEndDestinationCommand {
        return start(start).end(end).destination(destination)
    }
}

class RootExecuteIfDataBlockSourcePosPathCommand(
    parent: CommandNode,
    path: String
): RootExecuteCommandRedirect(parent, path)

class RootExecuteIfDataBlockSourcePosCommand(
    parent: CommandNode,
    sourcePos: String
): CommandArgument(parent, sourcePos) {
    fun path(path: String): RootExecuteCommand {
        return RootExecuteIfDataBlockSourcePosPathCommand(this, path).redirect()
    }
}

class RootExecuteIfDataBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun sourcePos(sourcePos: String): RootExecuteIfDataBlockSourcePosCommand {
        return RootExecuteIfDataBlockSourcePosCommand(this, sourcePos)
    }

    operator fun invoke(sourcePos: String, path: String): RootExecuteCommand {
        return sourcePos(sourcePos).path(path)
    }
}

class RootExecuteIfDataEntitySourcePathCommand(
    parent: CommandNode,
    path: String
): RootExecuteCommandRedirect(parent, path)

class RootExecuteIfDataEntitySourceCommand(
    parent: CommandNode,
    source: Selector
): CommandArgument(parent, source) {
    fun path(path: String): RootExecuteCommand {
        return RootExecuteIfDataEntitySourcePathCommand(this, path).redirect()
    }
}

class RootExecuteIfDataEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun source(source: Selector): RootExecuteIfDataEntitySourceCommand {
        return RootExecuteIfDataEntitySourceCommand(this, source)
    }

    operator fun invoke(source: Selector, path: String): RootExecuteCommand {
        return source(source).path(path)
    }
}

class RootExecuteIfDataStorageSourcePathCommand(
    parent: CommandNode,
    path: String
): RootExecuteCommandRedirect(parent, path)

class RootExecuteIfDataStorageSourceCommand(
    parent: CommandNode,
    source: String
): CommandArgument(parent, source) {
    fun path(path: String): RootExecuteCommand {
        return RootExecuteIfDataStorageSourcePathCommand(this, path).redirect()
    }
}

class RootExecuteIfDataStorageCommand(
    parent: CommandNode
): CommandLiteral(parent, "storage") {
    fun source(source: String): RootExecuteIfDataStorageSourceCommand {
        return RootExecuteIfDataStorageSourceCommand(this, source)
    }

    operator fun invoke(source: String, path: String): RootExecuteCommand {
        return source(source).path(path)
    }
}

class RootExecuteIfDataCommand(
    parent: CommandNode
): CommandLiteral(parent, "data") {
    val block = RootExecuteIfDataBlockCommand(this)
    val entity = RootExecuteIfDataEntityCommand(this)
    val storage = RootExecuteIfDataStorageCommand(this)
}

class RootExecuteIfEntityEntitiesCommand(
    parent: CommandNode,
    entities: Selector
): RootExecuteCommandRedirect(parent, entities)

class RootExecuteIfEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun entities(entities: Selector): RootExecuteCommand {
        return RootExecuteIfEntityEntitiesCommand(this, entities).redirect()
    }

    operator fun invoke(entities: Selector): RootExecuteCommand {
        return entities(entities)
    }
}

class RootExecuteIfPredicatePredicateCommand(
    parent: CommandNode,
    predicate: String
): RootExecuteCommandRedirect(parent, predicate)

class RootExecuteIfPredicateCommand(
    parent: CommandNode
): CommandLiteral(parent, "predicate") {
    fun predicate(predicate: String): RootExecuteCommand {
        return RootExecuteIfPredicatePredicateCommand(this, predicate).redirect()
    }

    operator fun invoke(predicate: String): RootExecuteCommand {
        return predicate(predicate)
    }
}

class RootExecuteIfScoreTargetTargetObjectiveOperationSourceSourceObjectiveCommand(
    parent: CommandNode,
    sourceObjective: String
): RootExecuteCommandRedirect(parent, sourceObjective)

class RootExecuteIfScoreTargetTargetObjectiveOperationSourceCommand(
    parent: CommandNode,
    source: String
): CommandArgument(parent, source) {
    fun sourceObjective(sourceObjective: String): RootExecuteCommand {
        return RootExecuteIfScoreTargetTargetObjectiveOperationSourceSourceObjectiveCommand(this, sourceObjective).redirect()
    }
}

class RootExecuteIfScoreTargetTargetObjectiveOperationCommand(
    parent: CommandNode,
    operation: String
): CommandArgument(parent, operation) {
    fun source(source: String): RootExecuteIfScoreTargetTargetObjectiveOperationSourceCommand {
        return RootExecuteIfScoreTargetTargetObjectiveOperationSourceCommand(this, source)
    }
}

class RootExecuteIfScoreTargetTargetObjectiveMatchesRangeCommand(
    parent: CommandNode,
    range: IntRange
): RootExecuteCommandRedirect(parent, range)

class RootExecuteIfScoreTargetTargetObjectiveMatchesCommand(
    parent: CommandNode
): CommandLiteral(parent, "matches") {
    fun range(range: IntRange): RootExecuteCommand {
        return RootExecuteIfScoreTargetTargetObjectiveMatchesRangeCommand(this, range).redirect()
    }

    operator fun invoke(range: IntRange): RootExecuteCommand {
        return range(range)
    }
}

class RootExecuteIfScoreTargetTargetObjectiveCommand(
    parent: CommandNode,
    targetObjective: String
): CommandArgument(parent, targetObjective) {
    val matches = RootExecuteIfScoreTargetTargetObjectiveMatchesCommand(this)

        fun operation(operation: String): RootExecuteIfScoreTargetTargetObjectiveOperationCommand {
        return RootExecuteIfScoreTargetTargetObjectiveOperationCommand(this, operation)
    }
}

class RootExecuteIfScoreTargetCommand(
    parent: CommandNode,
    target: String
): CommandArgument(parent, target) {
    fun targetObjective(targetObjective: String): RootExecuteIfScoreTargetTargetObjectiveCommand {
        return RootExecuteIfScoreTargetTargetObjectiveCommand(this, targetObjective)
    }
}

class RootExecuteIfScoreCommand(
    parent: CommandNode
): CommandLiteral(parent, "score") {
    fun target(target: String): RootExecuteIfScoreTargetCommand {
        return RootExecuteIfScoreTargetCommand(this, target)
    }

    operator fun invoke(target: String, targetObjective: String, operation: String, source: String, sourceObjective: String): RootExecuteCommand {
        return target(target).targetObjective(targetObjective).operation(operation).source(source).sourceObjective(sourceObjective)
    }
}

class RootExecuteIfCommand(
    parent: CommandNode
): CommandLiteral(parent, "if") {
    val block = RootExecuteIfBlockCommand(this)
    val blocks = RootExecuteIfBlocksCommand(this)
    val data = RootExecuteIfDataCommand(this)
    val entity = RootExecuteIfEntityCommand(this)
    val predicate = RootExecuteIfPredicateCommand(this)
    val score = RootExecuteIfScoreCommand(this)
}

class RootExecuteInDimensionCommand(
    parent: CommandNode,
    dimension: String
): RootExecuteCommandRedirect(parent, dimension)

class RootExecuteInCommand(
    parent: CommandNode
): CommandLiteral(parent, "in") {
    fun dimension(dimension: String): RootExecuteCommand {
        return RootExecuteInDimensionCommand(this, dimension).redirect()
    }

    operator fun invoke(dimension: String): RootExecuteCommand {
        return dimension(dimension)
    }
}

class RootExecutePositionedAsTargetsCommand(
    parent: CommandNode,
    targets: Selector
): RootExecuteCommandRedirect(parent, targets)

class RootExecutePositionedAsCommand(
    parent: CommandNode
): CommandLiteral(parent, "as") {
    fun targets(targets: Selector): RootExecuteCommand {
        return RootExecutePositionedAsTargetsCommand(this, targets).redirect()
    }

    operator fun invoke(targets: Selector): RootExecuteCommand {
        return targets(targets)
    }
}

class RootExecutePositionedPosCommand(
    parent: CommandNode,
    pos: Coordinates
): RootExecuteCommandRedirect(parent, pos)

class RootExecutePositionedCommand(
    parent: CommandNode
): CommandLiteral(parent, "positioned") {
    val `as` = RootExecutePositionedAsCommand(this)

        fun pos(pos: Coordinates): RootExecuteCommand {
        return RootExecutePositionedPosCommand(this, pos).redirect()
    }

    operator fun invoke(pos: Coordinates): RootExecuteCommand {
        return pos(pos)
    }
}

class RootExecuteRotatedAsTargetsCommand(
    parent: CommandNode,
    targets: Selector
): RootExecuteCommandRedirect(parent, targets)

class RootExecuteRotatedAsCommand(
    parent: CommandNode
): CommandLiteral(parent, "as") {
    fun targets(targets: Selector): RootExecuteCommand {
        return RootExecuteRotatedAsTargetsCommand(this, targets).redirect()
    }

    operator fun invoke(targets: Selector): RootExecuteCommand {
        return targets(targets)
    }
}

class RootExecuteRotatedRotCommand(
    parent: CommandNode,
    rot: String
): RootExecuteCommandRedirect(parent, rot)

class RootExecuteRotatedCommand(
    parent: CommandNode
): CommandLiteral(parent, "rotated") {
    val `as` = RootExecuteRotatedAsCommand(this)

        fun rot(rot: String): RootExecuteCommand {
        return RootExecuteRotatedRotCommand(this, rot).redirect()
    }

    operator fun invoke(rot: String): RootExecuteCommand {
        return rot(rot)
    }
}
abstract class RootCommandRedirect(
    parent: CommandNode?,
    argOrLiteral: Any?
): CommandNode(parent, argOrLiteral) {
    fun redirect(): RootCommand {
        return RootCommand(this, null)
    }
}


class RootExecuteRunCommand(
    parent: CommandNode
): RootCommandRedirect(parent, "run")

class RootExecuteStoreResultBlockTargetPosPathByteScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreResultBlockTargetPosPathByteCommand(
    parent: CommandNode
): CommandLiteral(parent, "byte") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreResultBlockTargetPosPathByteScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreResultBlockTargetPosPathDoubleScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreResultBlockTargetPosPathDoubleCommand(
    parent: CommandNode
): CommandLiteral(parent, "double") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreResultBlockTargetPosPathDoubleScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreResultBlockTargetPosPathFloatScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreResultBlockTargetPosPathFloatCommand(
    parent: CommandNode
): CommandLiteral(parent, "float") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreResultBlockTargetPosPathFloatScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreResultBlockTargetPosPathIntScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreResultBlockTargetPosPathIntCommand(
    parent: CommandNode
): CommandLiteral(parent, "int") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreResultBlockTargetPosPathIntScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreResultBlockTargetPosPathLongScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreResultBlockTargetPosPathLongCommand(
    parent: CommandNode
): CommandLiteral(parent, "long") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreResultBlockTargetPosPathLongScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreResultBlockTargetPosPathShortScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreResultBlockTargetPosPathShortCommand(
    parent: CommandNode
): CommandLiteral(parent, "short") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreResultBlockTargetPosPathShortScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreResultBlockTargetPosPathCommand(
    parent: CommandNode,
    path: String
): CommandArgument(parent, path) {
    val byte = RootExecuteStoreResultBlockTargetPosPathByteCommand(this)
    val double = RootExecuteStoreResultBlockTargetPosPathDoubleCommand(this)
    val float = RootExecuteStoreResultBlockTargetPosPathFloatCommand(this)
    val int = RootExecuteStoreResultBlockTargetPosPathIntCommand(this)
    val long = RootExecuteStoreResultBlockTargetPosPathLongCommand(this)
    val short = RootExecuteStoreResultBlockTargetPosPathShortCommand(this)
}

class RootExecuteStoreResultBlockTargetPosCommand(
    parent: CommandNode,
    targetPos: String
): CommandArgument(parent, targetPos) {
    fun path(path: String): RootExecuteStoreResultBlockTargetPosPathCommand {
        return RootExecuteStoreResultBlockTargetPosPathCommand(this, path)
    }
}

class RootExecuteStoreResultBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun targetPos(targetPos: String): RootExecuteStoreResultBlockTargetPosCommand {
        return RootExecuteStoreResultBlockTargetPosCommand(this, targetPos)
    }

    operator fun invoke(targetPos: String, path: String): RootExecuteStoreResultBlockTargetPosPathCommand {
        return targetPos(targetPos).path(path)
    }
}

class RootExecuteStoreResultBossbarIdMaxCommand(
    parent: CommandNode
): RootExecuteCommandRedirect(parent, "max")

class RootExecuteStoreResultBossbarIdValueCommand(
    parent: CommandNode
): RootExecuteCommandRedirect(parent, "value")

class RootExecuteStoreResultBossbarIdCommand(
    parent: CommandNode,
    id: String
): CommandArgument(parent, id) {
    val max = RootExecuteStoreResultBossbarIdMaxCommand(this).redirect()
    val value = RootExecuteStoreResultBossbarIdValueCommand(this).redirect()
}

class RootExecuteStoreResultBossbarCommand(
    parent: CommandNode
): CommandLiteral(parent, "bossbar") {
    fun id(id: String): RootExecuteStoreResultBossbarIdCommand {
        return RootExecuteStoreResultBossbarIdCommand(this, id)
    }

    operator fun invoke(id: String): RootExecuteStoreResultBossbarIdCommand {
        return id(id)
    }
}

class RootExecuteStoreResultEntityTargetPathByteScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreResultEntityTargetPathByteCommand(
    parent: CommandNode
): CommandLiteral(parent, "byte") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreResultEntityTargetPathByteScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreResultEntityTargetPathDoubleScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreResultEntityTargetPathDoubleCommand(
    parent: CommandNode
): CommandLiteral(parent, "double") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreResultEntityTargetPathDoubleScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreResultEntityTargetPathFloatScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreResultEntityTargetPathFloatCommand(
    parent: CommandNode
): CommandLiteral(parent, "float") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreResultEntityTargetPathFloatScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreResultEntityTargetPathIntScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreResultEntityTargetPathIntCommand(
    parent: CommandNode
): CommandLiteral(parent, "int") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreResultEntityTargetPathIntScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreResultEntityTargetPathLongScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreResultEntityTargetPathLongCommand(
    parent: CommandNode
): CommandLiteral(parent, "long") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreResultEntityTargetPathLongScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreResultEntityTargetPathShortScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreResultEntityTargetPathShortCommand(
    parent: CommandNode
): CommandLiteral(parent, "short") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreResultEntityTargetPathShortScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreResultEntityTargetPathCommand(
    parent: CommandNode,
    path: String
): CommandArgument(parent, path) {
    val byte = RootExecuteStoreResultEntityTargetPathByteCommand(this)
    val double = RootExecuteStoreResultEntityTargetPathDoubleCommand(this)
    val float = RootExecuteStoreResultEntityTargetPathFloatCommand(this)
    val int = RootExecuteStoreResultEntityTargetPathIntCommand(this)
    val long = RootExecuteStoreResultEntityTargetPathLongCommand(this)
    val short = RootExecuteStoreResultEntityTargetPathShortCommand(this)
}

class RootExecuteStoreResultEntityTargetCommand(
    parent: CommandNode,
    target: Selector
): CommandArgument(parent, target) {
    fun path(path: String): RootExecuteStoreResultEntityTargetPathCommand {
        return RootExecuteStoreResultEntityTargetPathCommand(this, path)
    }
}

class RootExecuteStoreResultEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun target(target: Selector): RootExecuteStoreResultEntityTargetCommand {
        return RootExecuteStoreResultEntityTargetCommand(this, target)
    }

    operator fun invoke(target: Selector, path: String): RootExecuteStoreResultEntityTargetPathCommand {
        return target(target).path(path)
    }
}

class RootExecuteStoreResultScoreTargetsObjectiveCommand(
    parent: CommandNode,
    objective: String
): RootExecuteCommandRedirect(parent, objective)

class RootExecuteStoreResultScoreTargetsCommand(
    parent: CommandNode,
    targets: String
): CommandArgument(parent, targets) {
    fun objective(objective: String): RootExecuteCommand {
        return RootExecuteStoreResultScoreTargetsObjectiveCommand(this, objective).redirect()
    }
}

class RootExecuteStoreResultScoreCommand(
    parent: CommandNode
): CommandLiteral(parent, "score") {
    fun targets(targets: String): RootExecuteStoreResultScoreTargetsCommand {
        return RootExecuteStoreResultScoreTargetsCommand(this, targets)
    }

    operator fun invoke(targets: String, objective: String): RootExecuteCommand {
        return targets(targets).objective(objective)
    }
}

class RootExecuteStoreResultStorageTargetPathByteScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreResultStorageTargetPathByteCommand(
    parent: CommandNode
): CommandLiteral(parent, "byte") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreResultStorageTargetPathByteScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreResultStorageTargetPathDoubleScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreResultStorageTargetPathDoubleCommand(
    parent: CommandNode
): CommandLiteral(parent, "double") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreResultStorageTargetPathDoubleScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreResultStorageTargetPathFloatScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreResultStorageTargetPathFloatCommand(
    parent: CommandNode
): CommandLiteral(parent, "float") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreResultStorageTargetPathFloatScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreResultStorageTargetPathIntScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreResultStorageTargetPathIntCommand(
    parent: CommandNode
): CommandLiteral(parent, "int") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreResultStorageTargetPathIntScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreResultStorageTargetPathLongScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreResultStorageTargetPathLongCommand(
    parent: CommandNode
): CommandLiteral(parent, "long") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreResultStorageTargetPathLongScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreResultStorageTargetPathShortScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreResultStorageTargetPathShortCommand(
    parent: CommandNode
): CommandLiteral(parent, "short") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreResultStorageTargetPathShortScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreResultStorageTargetPathCommand(
    parent: CommandNode,
    path: String
): CommandArgument(parent, path) {
    val byte = RootExecuteStoreResultStorageTargetPathByteCommand(this)
    val double = RootExecuteStoreResultStorageTargetPathDoubleCommand(this)
    val float = RootExecuteStoreResultStorageTargetPathFloatCommand(this)
    val int = RootExecuteStoreResultStorageTargetPathIntCommand(this)
    val long = RootExecuteStoreResultStorageTargetPathLongCommand(this)
    val short = RootExecuteStoreResultStorageTargetPathShortCommand(this)
}

class RootExecuteStoreResultStorageTargetCommand(
    parent: CommandNode,
    target: String
): CommandArgument(parent, target) {
    fun path(path: String): RootExecuteStoreResultStorageTargetPathCommand {
        return RootExecuteStoreResultStorageTargetPathCommand(this, path)
    }
}

class RootExecuteStoreResultStorageCommand(
    parent: CommandNode
): CommandLiteral(parent, "storage") {
    fun target(target: String): RootExecuteStoreResultStorageTargetCommand {
        return RootExecuteStoreResultStorageTargetCommand(this, target)
    }

    operator fun invoke(target: String, path: String): RootExecuteStoreResultStorageTargetPathCommand {
        return target(target).path(path)
    }
}

class RootExecuteStoreResultCommand(
    parent: CommandNode
): CommandLiteral(parent, "result") {
    val block = RootExecuteStoreResultBlockCommand(this)
    val bossbar = RootExecuteStoreResultBossbarCommand(this)
    val entity = RootExecuteStoreResultEntityCommand(this)
    val score = RootExecuteStoreResultScoreCommand(this)
    val storage = RootExecuteStoreResultStorageCommand(this)
}

class RootExecuteStoreSuccessBlockTargetPosPathByteScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreSuccessBlockTargetPosPathByteCommand(
    parent: CommandNode
): CommandLiteral(parent, "byte") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreSuccessBlockTargetPosPathByteScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreSuccessBlockTargetPosPathDoubleScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreSuccessBlockTargetPosPathDoubleCommand(
    parent: CommandNode
): CommandLiteral(parent, "double") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreSuccessBlockTargetPosPathDoubleScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreSuccessBlockTargetPosPathFloatScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreSuccessBlockTargetPosPathFloatCommand(
    parent: CommandNode
): CommandLiteral(parent, "float") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreSuccessBlockTargetPosPathFloatScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreSuccessBlockTargetPosPathIntScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreSuccessBlockTargetPosPathIntCommand(
    parent: CommandNode
): CommandLiteral(parent, "int") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreSuccessBlockTargetPosPathIntScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreSuccessBlockTargetPosPathLongScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreSuccessBlockTargetPosPathLongCommand(
    parent: CommandNode
): CommandLiteral(parent, "long") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreSuccessBlockTargetPosPathLongScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreSuccessBlockTargetPosPathShortScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreSuccessBlockTargetPosPathShortCommand(
    parent: CommandNode
): CommandLiteral(parent, "short") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreSuccessBlockTargetPosPathShortScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreSuccessBlockTargetPosPathCommand(
    parent: CommandNode,
    path: String
): CommandArgument(parent, path) {
    val byte = RootExecuteStoreSuccessBlockTargetPosPathByteCommand(this)
    val double = RootExecuteStoreSuccessBlockTargetPosPathDoubleCommand(this)
    val float = RootExecuteStoreSuccessBlockTargetPosPathFloatCommand(this)
    val int = RootExecuteStoreSuccessBlockTargetPosPathIntCommand(this)
    val long = RootExecuteStoreSuccessBlockTargetPosPathLongCommand(this)
    val short = RootExecuteStoreSuccessBlockTargetPosPathShortCommand(this)
}

class RootExecuteStoreSuccessBlockTargetPosCommand(
    parent: CommandNode,
    targetPos: String
): CommandArgument(parent, targetPos) {
    fun path(path: String): RootExecuteStoreSuccessBlockTargetPosPathCommand {
        return RootExecuteStoreSuccessBlockTargetPosPathCommand(this, path)
    }
}

class RootExecuteStoreSuccessBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun targetPos(targetPos: String): RootExecuteStoreSuccessBlockTargetPosCommand {
        return RootExecuteStoreSuccessBlockTargetPosCommand(this, targetPos)
    }

    operator fun invoke(targetPos: String, path: String): RootExecuteStoreSuccessBlockTargetPosPathCommand {
        return targetPos(targetPos).path(path)
    }
}

class RootExecuteStoreSuccessBossbarIdMaxCommand(
    parent: CommandNode
): RootExecuteCommandRedirect(parent, "max")

class RootExecuteStoreSuccessBossbarIdValueCommand(
    parent: CommandNode
): RootExecuteCommandRedirect(parent, "value")

class RootExecuteStoreSuccessBossbarIdCommand(
    parent: CommandNode,
    id: String
): CommandArgument(parent, id) {
    val max = RootExecuteStoreSuccessBossbarIdMaxCommand(this).redirect()
    val value = RootExecuteStoreSuccessBossbarIdValueCommand(this).redirect()
}

class RootExecuteStoreSuccessBossbarCommand(
    parent: CommandNode
): CommandLiteral(parent, "bossbar") {
    fun id(id: String): RootExecuteStoreSuccessBossbarIdCommand {
        return RootExecuteStoreSuccessBossbarIdCommand(this, id)
    }

    operator fun invoke(id: String): RootExecuteStoreSuccessBossbarIdCommand {
        return id(id)
    }
}

class RootExecuteStoreSuccessEntityTargetPathByteScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreSuccessEntityTargetPathByteCommand(
    parent: CommandNode
): CommandLiteral(parent, "byte") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreSuccessEntityTargetPathByteScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreSuccessEntityTargetPathDoubleScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreSuccessEntityTargetPathDoubleCommand(
    parent: CommandNode
): CommandLiteral(parent, "double") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreSuccessEntityTargetPathDoubleScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreSuccessEntityTargetPathFloatScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreSuccessEntityTargetPathFloatCommand(
    parent: CommandNode
): CommandLiteral(parent, "float") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreSuccessEntityTargetPathFloatScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreSuccessEntityTargetPathIntScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreSuccessEntityTargetPathIntCommand(
    parent: CommandNode
): CommandLiteral(parent, "int") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreSuccessEntityTargetPathIntScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreSuccessEntityTargetPathLongScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreSuccessEntityTargetPathLongCommand(
    parent: CommandNode
): CommandLiteral(parent, "long") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreSuccessEntityTargetPathLongScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreSuccessEntityTargetPathShortScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreSuccessEntityTargetPathShortCommand(
    parent: CommandNode
): CommandLiteral(parent, "short") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreSuccessEntityTargetPathShortScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreSuccessEntityTargetPathCommand(
    parent: CommandNode,
    path: String
): CommandArgument(parent, path) {
    val byte = RootExecuteStoreSuccessEntityTargetPathByteCommand(this)
    val double = RootExecuteStoreSuccessEntityTargetPathDoubleCommand(this)
    val float = RootExecuteStoreSuccessEntityTargetPathFloatCommand(this)
    val int = RootExecuteStoreSuccessEntityTargetPathIntCommand(this)
    val long = RootExecuteStoreSuccessEntityTargetPathLongCommand(this)
    val short = RootExecuteStoreSuccessEntityTargetPathShortCommand(this)
}

class RootExecuteStoreSuccessEntityTargetCommand(
    parent: CommandNode,
    target: Selector
): CommandArgument(parent, target) {
    fun path(path: String): RootExecuteStoreSuccessEntityTargetPathCommand {
        return RootExecuteStoreSuccessEntityTargetPathCommand(this, path)
    }
}

class RootExecuteStoreSuccessEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun target(target: Selector): RootExecuteStoreSuccessEntityTargetCommand {
        return RootExecuteStoreSuccessEntityTargetCommand(this, target)
    }

    operator fun invoke(target: Selector, path: String): RootExecuteStoreSuccessEntityTargetPathCommand {
        return target(target).path(path)
    }
}

class RootExecuteStoreSuccessScoreTargetsObjectiveCommand(
    parent: CommandNode,
    objective: String
): RootExecuteCommandRedirect(parent, objective)

class RootExecuteStoreSuccessScoreTargetsCommand(
    parent: CommandNode,
    targets: String
): CommandArgument(parent, targets) {
    fun objective(objective: String): RootExecuteCommand {
        return RootExecuteStoreSuccessScoreTargetsObjectiveCommand(this, objective).redirect()
    }
}

class RootExecuteStoreSuccessScoreCommand(
    parent: CommandNode
): CommandLiteral(parent, "score") {
    fun targets(targets: String): RootExecuteStoreSuccessScoreTargetsCommand {
        return RootExecuteStoreSuccessScoreTargetsCommand(this, targets)
    }

    operator fun invoke(targets: String, objective: String): RootExecuteCommand {
        return targets(targets).objective(objective)
    }
}

class RootExecuteStoreSuccessStorageTargetPathByteScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreSuccessStorageTargetPathByteCommand(
    parent: CommandNode
): CommandLiteral(parent, "byte") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreSuccessStorageTargetPathByteScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreSuccessStorageTargetPathDoubleScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreSuccessStorageTargetPathDoubleCommand(
    parent: CommandNode
): CommandLiteral(parent, "double") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreSuccessStorageTargetPathDoubleScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreSuccessStorageTargetPathFloatScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreSuccessStorageTargetPathFloatCommand(
    parent: CommandNode
): CommandLiteral(parent, "float") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreSuccessStorageTargetPathFloatScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreSuccessStorageTargetPathIntScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreSuccessStorageTargetPathIntCommand(
    parent: CommandNode
): CommandLiteral(parent, "int") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreSuccessStorageTargetPathIntScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreSuccessStorageTargetPathLongScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreSuccessStorageTargetPathLongCommand(
    parent: CommandNode
): CommandLiteral(parent, "long") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreSuccessStorageTargetPathLongScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreSuccessStorageTargetPathShortScaleCommand(
    parent: CommandNode,
    scale: Double
): RootExecuteCommandRedirect(parent, scale)

class RootExecuteStoreSuccessStorageTargetPathShortCommand(
    parent: CommandNode
): CommandLiteral(parent, "short") {
    fun scale(scale: Double): RootExecuteCommand {
        return RootExecuteStoreSuccessStorageTargetPathShortScaleCommand(this, scale).redirect()
    }

    operator fun invoke(scale: Double): RootExecuteCommand {
        return scale(scale)
    }
}

class RootExecuteStoreSuccessStorageTargetPathCommand(
    parent: CommandNode,
    path: String
): CommandArgument(parent, path) {
    val byte = RootExecuteStoreSuccessStorageTargetPathByteCommand(this)
    val double = RootExecuteStoreSuccessStorageTargetPathDoubleCommand(this)
    val float = RootExecuteStoreSuccessStorageTargetPathFloatCommand(this)
    val int = RootExecuteStoreSuccessStorageTargetPathIntCommand(this)
    val long = RootExecuteStoreSuccessStorageTargetPathLongCommand(this)
    val short = RootExecuteStoreSuccessStorageTargetPathShortCommand(this)
}

class RootExecuteStoreSuccessStorageTargetCommand(
    parent: CommandNode,
    target: String
): CommandArgument(parent, target) {
    fun path(path: String): RootExecuteStoreSuccessStorageTargetPathCommand {
        return RootExecuteStoreSuccessStorageTargetPathCommand(this, path)
    }
}

class RootExecuteStoreSuccessStorageCommand(
    parent: CommandNode
): CommandLiteral(parent, "storage") {
    fun target(target: String): RootExecuteStoreSuccessStorageTargetCommand {
        return RootExecuteStoreSuccessStorageTargetCommand(this, target)
    }

    operator fun invoke(target: String, path: String): RootExecuteStoreSuccessStorageTargetPathCommand {
        return target(target).path(path)
    }
}

class RootExecuteStoreSuccessCommand(
    parent: CommandNode
): CommandLiteral(parent, "success") {
    val block = RootExecuteStoreSuccessBlockCommand(this)
    val bossbar = RootExecuteStoreSuccessBossbarCommand(this)
    val entity = RootExecuteStoreSuccessEntityCommand(this)
    val score = RootExecuteStoreSuccessScoreCommand(this)
    val storage = RootExecuteStoreSuccessStorageCommand(this)
}

class RootExecuteStoreCommand(
    parent: CommandNode
): CommandLiteral(parent, "store") {
    val result = RootExecuteStoreResultCommand(this)
    val success = RootExecuteStoreSuccessCommand(this)
}

class RootExecuteUnlessBlockPosBlockCommand(
    parent: CommandNode,
    block: String
): RootExecuteCommandRedirect(parent, block)

class RootExecuteUnlessBlockPosCommand(
    parent: CommandNode,
    pos: String
): CommandArgument(parent, pos) {
    fun block(block: String): RootExecuteCommand {
        return RootExecuteUnlessBlockPosBlockCommand(this, block).redirect()
    }
}

class RootExecuteUnlessBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun pos(pos: String): RootExecuteUnlessBlockPosCommand {
        return RootExecuteUnlessBlockPosCommand(this, pos)
    }

    operator fun invoke(pos: String, block: String): RootExecuteCommand {
        return pos(pos).block(block)
    }
}

class RootExecuteUnlessBlocksStartEndDestinationAllCommand(
    parent: CommandNode
): RootExecuteCommandRedirect(parent, "all")

class RootExecuteUnlessBlocksStartEndDestinationMaskedCommand(
    parent: CommandNode
): RootExecuteCommandRedirect(parent, "masked")

class RootExecuteUnlessBlocksStartEndDestinationCommand(
    parent: CommandNode,
    destination: String
): CommandArgument(parent, destination) {
    val all = RootExecuteUnlessBlocksStartEndDestinationAllCommand(this).redirect()
    val masked = RootExecuteUnlessBlocksStartEndDestinationMaskedCommand(this).redirect()
}

class RootExecuteUnlessBlocksStartEndCommand(
    parent: CommandNode,
    end: String
): CommandArgument(parent, end) {
    fun destination(destination: String): RootExecuteUnlessBlocksStartEndDestinationCommand {
        return RootExecuteUnlessBlocksStartEndDestinationCommand(this, destination)
    }
}

class RootExecuteUnlessBlocksStartCommand(
    parent: CommandNode,
    start: String
): CommandArgument(parent, start) {
    fun end(end: String): RootExecuteUnlessBlocksStartEndCommand {
        return RootExecuteUnlessBlocksStartEndCommand(this, end)
    }
}

class RootExecuteUnlessBlocksCommand(
    parent: CommandNode
): CommandLiteral(parent, "blocks") {
    fun start(start: String): RootExecuteUnlessBlocksStartCommand {
        return RootExecuteUnlessBlocksStartCommand(this, start)
    }

    operator fun invoke(start: String, end: String, destination: String): RootExecuteUnlessBlocksStartEndDestinationCommand {
        return start(start).end(end).destination(destination)
    }
}

class RootExecuteUnlessDataBlockSourcePosPathCommand(
    parent: CommandNode,
    path: String
): RootExecuteCommandRedirect(parent, path)

class RootExecuteUnlessDataBlockSourcePosCommand(
    parent: CommandNode,
    sourcePos: String
): CommandArgument(parent, sourcePos) {
    fun path(path: String): RootExecuteCommand {
        return RootExecuteUnlessDataBlockSourcePosPathCommand(this, path).redirect()
    }
}

class RootExecuteUnlessDataBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun sourcePos(sourcePos: String): RootExecuteUnlessDataBlockSourcePosCommand {
        return RootExecuteUnlessDataBlockSourcePosCommand(this, sourcePos)
    }

    operator fun invoke(sourcePos: String, path: String): RootExecuteCommand {
        return sourcePos(sourcePos).path(path)
    }
}

class RootExecuteUnlessDataEntitySourcePathCommand(
    parent: CommandNode,
    path: String
): RootExecuteCommandRedirect(parent, path)

class RootExecuteUnlessDataEntitySourceCommand(
    parent: CommandNode,
    source: Selector
): CommandArgument(parent, source) {
    fun path(path: String): RootExecuteCommand {
        return RootExecuteUnlessDataEntitySourcePathCommand(this, path).redirect()
    }
}

class RootExecuteUnlessDataEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun source(source: Selector): RootExecuteUnlessDataEntitySourceCommand {
        return RootExecuteUnlessDataEntitySourceCommand(this, source)
    }

    operator fun invoke(source: Selector, path: String): RootExecuteCommand {
        return source(source).path(path)
    }
}

class RootExecuteUnlessDataStorageSourcePathCommand(
    parent: CommandNode,
    path: String
): RootExecuteCommandRedirect(parent, path)

class RootExecuteUnlessDataStorageSourceCommand(
    parent: CommandNode,
    source: String
): CommandArgument(parent, source) {
    fun path(path: String): RootExecuteCommand {
        return RootExecuteUnlessDataStorageSourcePathCommand(this, path).redirect()
    }
}

class RootExecuteUnlessDataStorageCommand(
    parent: CommandNode
): CommandLiteral(parent, "storage") {
    fun source(source: String): RootExecuteUnlessDataStorageSourceCommand {
        return RootExecuteUnlessDataStorageSourceCommand(this, source)
    }

    operator fun invoke(source: String, path: String): RootExecuteCommand {
        return source(source).path(path)
    }
}

class RootExecuteUnlessDataCommand(
    parent: CommandNode
): CommandLiteral(parent, "data") {
    val block = RootExecuteUnlessDataBlockCommand(this)
    val entity = RootExecuteUnlessDataEntityCommand(this)
    val storage = RootExecuteUnlessDataStorageCommand(this)
}

class RootExecuteUnlessEntityEntitiesCommand(
    parent: CommandNode,
    entities: Selector
): RootExecuteCommandRedirect(parent, entities)

class RootExecuteUnlessEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun entities(entities: Selector): RootExecuteCommand {
        return RootExecuteUnlessEntityEntitiesCommand(this, entities).redirect()
    }

    operator fun invoke(entities: Selector): RootExecuteCommand {
        return entities(entities)
    }
}

class RootExecuteUnlessPredicatePredicateCommand(
    parent: CommandNode,
    predicate: String
): RootExecuteCommandRedirect(parent, predicate)

class RootExecuteUnlessPredicateCommand(
    parent: CommandNode
): CommandLiteral(parent, "predicate") {
    fun predicate(predicate: String): RootExecuteCommand {
        return RootExecuteUnlessPredicatePredicateCommand(this, predicate).redirect()
    }

    operator fun invoke(predicate: String): RootExecuteCommand {
        return predicate(predicate)
    }
}

class RootExecuteUnlessScoreTargetTargetObjectiveOperationSourceSourceObjectiveCommand(
    parent: CommandNode,
    sourceObjective: String
): RootExecuteCommandRedirect(parent, sourceObjective)

class RootExecuteUnlessScoreTargetTargetObjectiveOperationSourceCommand(
    parent: CommandNode,
    source: String
): CommandArgument(parent, source) {
    fun sourceObjective(sourceObjective: String): RootExecuteCommand {
        return RootExecuteUnlessScoreTargetTargetObjectiveOperationSourceSourceObjectiveCommand(this, sourceObjective).redirect()
    }
}

class RootExecuteUnlessScoreTargetTargetObjectiveOperationCommand(
    parent: CommandNode,
    operation: String
): CommandArgument(parent, operation) {
    fun source(source: String): RootExecuteUnlessScoreTargetTargetObjectiveOperationSourceCommand {
        return RootExecuteUnlessScoreTargetTargetObjectiveOperationSourceCommand(this, source)
    }
}

class RootExecuteUnlessScoreTargetTargetObjectiveMatchesRangeCommand(
    parent: CommandNode,
    range: IntRange
): RootExecuteCommandRedirect(parent, range)

class RootExecuteUnlessScoreTargetTargetObjectiveMatchesCommand(
    parent: CommandNode
): CommandLiteral(parent, "matches") {
    fun range(range: IntRange): RootExecuteCommand {
        return RootExecuteUnlessScoreTargetTargetObjectiveMatchesRangeCommand(this, range).redirect()
    }

    operator fun invoke(range: IntRange): RootExecuteCommand {
        return range(range)
    }
}

class RootExecuteUnlessScoreTargetTargetObjectiveCommand(
    parent: CommandNode,
    targetObjective: String
): CommandArgument(parent, targetObjective) {
    val matches = RootExecuteUnlessScoreTargetTargetObjectiveMatchesCommand(this)

        fun operation(operation: String): RootExecuteUnlessScoreTargetTargetObjectiveOperationCommand {
        return RootExecuteUnlessScoreTargetTargetObjectiveOperationCommand(this, operation)
    }
}

class RootExecuteUnlessScoreTargetCommand(
    parent: CommandNode,
    target: String
): CommandArgument(parent, target) {
    fun targetObjective(targetObjective: String): RootExecuteUnlessScoreTargetTargetObjectiveCommand {
        return RootExecuteUnlessScoreTargetTargetObjectiveCommand(this, targetObjective)
    }
}

class RootExecuteUnlessScoreCommand(
    parent: CommandNode
): CommandLiteral(parent, "score") {
    fun target(target: String): RootExecuteUnlessScoreTargetCommand {
        return RootExecuteUnlessScoreTargetCommand(this, target)
    }

    operator fun invoke(target: String, targetObjective: String, operation: String, source: String, sourceObjective: String): RootExecuteCommand {
        return target(target).targetObjective(targetObjective).operation(operation).source(source).sourceObjective(sourceObjective)
    }
}

class RootExecuteUnlessCommand(
    parent: CommandNode
): CommandLiteral(parent, "unless") {
    val block = RootExecuteUnlessBlockCommand(this)
    val blocks = RootExecuteUnlessBlocksCommand(this)
    val data = RootExecuteUnlessDataCommand(this)
    val entity = RootExecuteUnlessEntityCommand(this)
    val predicate = RootExecuteUnlessPredicateCommand(this)
    val score = RootExecuteUnlessScoreCommand(this)
}

class RootExecuteCommand(
    parent: CommandNode?,
    literal: String? = "execute"
): CommandLiteral(parent, literal) {
    val align = RootExecuteAlignCommand(this)
    val anchored = RootExecuteAnchoredCommand(this)
    val `as` = RootExecuteAsCommand(this)
    val at = RootExecuteAtCommand(this)
    val facing = RootExecuteFacingCommand(this)
    val `if` = RootExecuteIfCommand(this)
    val `in` = RootExecuteInCommand(this)
    val positioned = RootExecutePositionedCommand(this)
    val rotated = RootExecuteRotatedCommand(this)
    val run = RootExecuteRunCommand(this).redirect()
    val store = RootExecuteStoreCommand(this)
    val unless = RootExecuteUnlessCommand(this)
}
val execute = RootExecuteCommand(null)