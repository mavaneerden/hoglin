package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootDataGetBlockTargetPosPathScaleCommand(
    parent: CommandNode,
    scale: Double? = null
): CommandArgument(parent, scale)

class RootDataGetBlockTargetPosPathCommand(
    parent: CommandNode,
    path: String? = null
): CommandArgument(parent, path) {
    fun scale(scale: Double? = null): RootDataGetBlockTargetPosPathScaleCommand {
        return RootDataGetBlockTargetPosPathScaleCommand(this, scale)
    }
}

class RootDataGetBlockTargetPosCommand(
    parent: CommandNode,
    targetPos: String
): CommandArgument(parent, targetPos) {
    fun path(path: String? = null): RootDataGetBlockTargetPosPathCommand {
        return RootDataGetBlockTargetPosPathCommand(this, path)
    }
}

class RootDataGetBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun targetPos(targetPos: String): RootDataGetBlockTargetPosCommand {
        return RootDataGetBlockTargetPosCommand(this, targetPos)
    }

    operator fun invoke(targetPos: String, path: String? = null, scale: Double? = null): RootDataGetBlockTargetPosPathScaleCommand {
        return targetPos(targetPos).path(path).scale(scale)
    }
}

class RootDataGetEntityTargetPathScaleCommand(
    parent: CommandNode,
    scale: Double? = null
): CommandArgument(parent, scale)

class RootDataGetEntityTargetPathCommand(
    parent: CommandNode,
    path: String? = null
): CommandArgument(parent, path) {
    fun scale(scale: Double? = null): RootDataGetEntityTargetPathScaleCommand {
        return RootDataGetEntityTargetPathScaleCommand(this, scale)
    }
}

class RootDataGetEntityTargetCommand(
    parent: CommandNode,
    target: Selector
): CommandArgument(parent, target) {
    fun path(path: String? = null): RootDataGetEntityTargetPathCommand {
        return RootDataGetEntityTargetPathCommand(this, path)
    }
}

class RootDataGetEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun target(target: Selector): RootDataGetEntityTargetCommand {
        return RootDataGetEntityTargetCommand(this, target)
    }

    operator fun invoke(target: Selector, path: String? = null, scale: Double? = null): RootDataGetEntityTargetPathScaleCommand {
        return target(target).path(path).scale(scale)
    }
}

class RootDataGetStorageTargetPathScaleCommand(
    parent: CommandNode,
    scale: Double? = null
): CommandArgument(parent, scale)

class RootDataGetStorageTargetPathCommand(
    parent: CommandNode,
    path: String? = null
): CommandArgument(parent, path) {
    fun scale(scale: Double? = null): RootDataGetStorageTargetPathScaleCommand {
        return RootDataGetStorageTargetPathScaleCommand(this, scale)
    }
}

class RootDataGetStorageTargetCommand(
    parent: CommandNode,
    target: String
): CommandArgument(parent, target) {
    fun path(path: String? = null): RootDataGetStorageTargetPathCommand {
        return RootDataGetStorageTargetPathCommand(this, path)
    }
}

class RootDataGetStorageCommand(
    parent: CommandNode
): CommandLiteral(parent, "storage") {
    fun target(target: String): RootDataGetStorageTargetCommand {
        return RootDataGetStorageTargetCommand(this, target)
    }

    operator fun invoke(target: String, path: String? = null, scale: Double? = null): RootDataGetStorageTargetPathScaleCommand {
        return target(target).path(path).scale(scale)
    }
}

class RootDataGetCommand(
    parent: CommandNode
): CommandLiteral(parent, "get") {
    val block = RootDataGetBlockCommand(this)
    val entity = RootDataGetEntityCommand(this)
    val storage = RootDataGetStorageCommand(this)
}

class RootDataMergeBlockTargetPosNbtCommand(
    parent: CommandNode,
    nbt: String
): CommandArgument(parent, nbt)

class RootDataMergeBlockTargetPosCommand(
    parent: CommandNode,
    targetPos: String
): CommandArgument(parent, targetPos) {
    fun nbt(nbt: String): RootDataMergeBlockTargetPosNbtCommand {
        return RootDataMergeBlockTargetPosNbtCommand(this, nbt)
    }
}

class RootDataMergeBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun targetPos(targetPos: String): RootDataMergeBlockTargetPosCommand {
        return RootDataMergeBlockTargetPosCommand(this, targetPos)
    }

    operator fun invoke(targetPos: String, nbt: String): RootDataMergeBlockTargetPosNbtCommand {
        return targetPos(targetPos).nbt(nbt)
    }
}

class RootDataMergeEntityTargetNbtCommand(
    parent: CommandNode,
    nbt: String
): CommandArgument(parent, nbt)

class RootDataMergeEntityTargetCommand(
    parent: CommandNode,
    target: Selector
): CommandArgument(parent, target) {
    fun nbt(nbt: String): RootDataMergeEntityTargetNbtCommand {
        return RootDataMergeEntityTargetNbtCommand(this, nbt)
    }
}

class RootDataMergeEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun target(target: Selector): RootDataMergeEntityTargetCommand {
        return RootDataMergeEntityTargetCommand(this, target)
    }

    operator fun invoke(target: Selector, nbt: String): RootDataMergeEntityTargetNbtCommand {
        return target(target).nbt(nbt)
    }
}

class RootDataMergeStorageTargetNbtCommand(
    parent: CommandNode,
    nbt: String
): CommandArgument(parent, nbt)

class RootDataMergeStorageTargetCommand(
    parent: CommandNode,
    target: String
): CommandArgument(parent, target) {
    fun nbt(nbt: String): RootDataMergeStorageTargetNbtCommand {
        return RootDataMergeStorageTargetNbtCommand(this, nbt)
    }
}

class RootDataMergeStorageCommand(
    parent: CommandNode
): CommandLiteral(parent, "storage") {
    fun target(target: String): RootDataMergeStorageTargetCommand {
        return RootDataMergeStorageTargetCommand(this, target)
    }

    operator fun invoke(target: String, nbt: String): RootDataMergeStorageTargetNbtCommand {
        return target(target).nbt(nbt)
    }
}

class RootDataMergeCommand(
    parent: CommandNode
): CommandLiteral(parent, "merge") {
    val block = RootDataMergeBlockCommand(this)
    val entity = RootDataMergeEntityCommand(this)
    val storage = RootDataMergeStorageCommand(this)
}

class RootDataModifyBlockTargetPosTargetPathAppendFromBlockSourcePosSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyBlockTargetPosTargetPathAppendFromBlockSourcePosCommand(
    parent: CommandNode,
    sourcePos: String
): CommandArgument(parent, sourcePos) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathAppendFromBlockSourcePosSourcePathCommand {
        return RootDataModifyBlockTargetPosTargetPathAppendFromBlockSourcePosSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathAppendFromBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun sourcePos(sourcePos: String): RootDataModifyBlockTargetPosTargetPathAppendFromBlockSourcePosCommand {
        return RootDataModifyBlockTargetPosTargetPathAppendFromBlockSourcePosCommand(this, sourcePos)
    }

    operator fun invoke(sourcePos: String, sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathAppendFromBlockSourcePosSourcePathCommand {
        return sourcePos(sourcePos).sourcePath(sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathAppendFromEntitySourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyBlockTargetPosTargetPathAppendFromEntitySourceCommand(
    parent: CommandNode,
    source: Selector
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathAppendFromEntitySourceSourcePathCommand {
        return RootDataModifyBlockTargetPosTargetPathAppendFromEntitySourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathAppendFromEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun source(source: Selector): RootDataModifyBlockTargetPosTargetPathAppendFromEntitySourceCommand {
        return RootDataModifyBlockTargetPosTargetPathAppendFromEntitySourceCommand(this, source)
    }

    operator fun invoke(source: Selector, sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathAppendFromEntitySourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathAppendFromStorageSourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyBlockTargetPosTargetPathAppendFromStorageSourceCommand(
    parent: CommandNode,
    source: String
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathAppendFromStorageSourceSourcePathCommand {
        return RootDataModifyBlockTargetPosTargetPathAppendFromStorageSourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathAppendFromStorageCommand(
    parent: CommandNode
): CommandLiteral(parent, "storage") {
    fun source(source: String): RootDataModifyBlockTargetPosTargetPathAppendFromStorageSourceCommand {
        return RootDataModifyBlockTargetPosTargetPathAppendFromStorageSourceCommand(this, source)
    }

    operator fun invoke(source: String, sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathAppendFromStorageSourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathAppendFromCommand(
    parent: CommandNode
): CommandLiteral(parent, "from") {
    val block = RootDataModifyBlockTargetPosTargetPathAppendFromBlockCommand(this)
    val entity = RootDataModifyBlockTargetPosTargetPathAppendFromEntityCommand(this)
    val storage = RootDataModifyBlockTargetPosTargetPathAppendFromStorageCommand(this)
}

class RootDataModifyBlockTargetPosTargetPathAppendValueValueCommand(
    parent: CommandNode,
    value: String
): CommandArgument(parent, value)

class RootDataModifyBlockTargetPosTargetPathAppendValueCommand(
    parent: CommandNode
): CommandLiteral(parent, "value") {
    fun value(value: String): RootDataModifyBlockTargetPosTargetPathAppendValueValueCommand {
        return RootDataModifyBlockTargetPosTargetPathAppendValueValueCommand(this, value)
    }

    operator fun invoke(value: String): RootDataModifyBlockTargetPosTargetPathAppendValueValueCommand {
        return value(value)
    }
}

class RootDataModifyBlockTargetPosTargetPathAppendCommand(
    parent: CommandNode
): CommandLiteral(parent, "append") {
    val from = RootDataModifyBlockTargetPosTargetPathAppendFromCommand(this)
    val value = RootDataModifyBlockTargetPosTargetPathAppendValueCommand(this)
}

class RootDataModifyBlockTargetPosTargetPathInsertIndexFromBlockSourcePosSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyBlockTargetPosTargetPathInsertIndexFromBlockSourcePosCommand(
    parent: CommandNode,
    sourcePos: String
): CommandArgument(parent, sourcePos) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathInsertIndexFromBlockSourcePosSourcePathCommand {
        return RootDataModifyBlockTargetPosTargetPathInsertIndexFromBlockSourcePosSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathInsertIndexFromBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun sourcePos(sourcePos: String): RootDataModifyBlockTargetPosTargetPathInsertIndexFromBlockSourcePosCommand {
        return RootDataModifyBlockTargetPosTargetPathInsertIndexFromBlockSourcePosCommand(this, sourcePos)
    }

    operator fun invoke(sourcePos: String, sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathInsertIndexFromBlockSourcePosSourcePathCommand {
        return sourcePos(sourcePos).sourcePath(sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathInsertIndexFromEntitySourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyBlockTargetPosTargetPathInsertIndexFromEntitySourceCommand(
    parent: CommandNode,
    source: Selector
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathInsertIndexFromEntitySourceSourcePathCommand {
        return RootDataModifyBlockTargetPosTargetPathInsertIndexFromEntitySourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathInsertIndexFromEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun source(source: Selector): RootDataModifyBlockTargetPosTargetPathInsertIndexFromEntitySourceCommand {
        return RootDataModifyBlockTargetPosTargetPathInsertIndexFromEntitySourceCommand(this, source)
    }

    operator fun invoke(source: Selector, sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathInsertIndexFromEntitySourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathInsertIndexFromStorageSourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyBlockTargetPosTargetPathInsertIndexFromStorageSourceCommand(
    parent: CommandNode,
    source: String
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathInsertIndexFromStorageSourceSourcePathCommand {
        return RootDataModifyBlockTargetPosTargetPathInsertIndexFromStorageSourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathInsertIndexFromStorageCommand(
    parent: CommandNode
): CommandLiteral(parent, "storage") {
    fun source(source: String): RootDataModifyBlockTargetPosTargetPathInsertIndexFromStorageSourceCommand {
        return RootDataModifyBlockTargetPosTargetPathInsertIndexFromStorageSourceCommand(this, source)
    }

    operator fun invoke(source: String, sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathInsertIndexFromStorageSourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathInsertIndexFromCommand(
    parent: CommandNode
): CommandLiteral(parent, "from") {
    val block = RootDataModifyBlockTargetPosTargetPathInsertIndexFromBlockCommand(this)
    val entity = RootDataModifyBlockTargetPosTargetPathInsertIndexFromEntityCommand(this)
    val storage = RootDataModifyBlockTargetPosTargetPathInsertIndexFromStorageCommand(this)
}

class RootDataModifyBlockTargetPosTargetPathInsertIndexValueValueCommand(
    parent: CommandNode,
    value: String
): CommandArgument(parent, value)

class RootDataModifyBlockTargetPosTargetPathInsertIndexValueCommand(
    parent: CommandNode
): CommandLiteral(parent, "value") {
    fun value(value: String): RootDataModifyBlockTargetPosTargetPathInsertIndexValueValueCommand {
        return RootDataModifyBlockTargetPosTargetPathInsertIndexValueValueCommand(this, value)
    }

    operator fun invoke(value: String): RootDataModifyBlockTargetPosTargetPathInsertIndexValueValueCommand {
        return value(value)
    }
}

class RootDataModifyBlockTargetPosTargetPathInsertIndexCommand(
    parent: CommandNode,
    index: Int
): CommandArgument(parent, index) {
    val from = RootDataModifyBlockTargetPosTargetPathInsertIndexFromCommand(this)
    val value = RootDataModifyBlockTargetPosTargetPathInsertIndexValueCommand(this)
}

class RootDataModifyBlockTargetPosTargetPathInsertCommand(
    parent: CommandNode
): CommandLiteral(parent, "insert") {
    fun index(index: Int): RootDataModifyBlockTargetPosTargetPathInsertIndexCommand {
        return RootDataModifyBlockTargetPosTargetPathInsertIndexCommand(this, index)
    }

    operator fun invoke(index: Int): RootDataModifyBlockTargetPosTargetPathInsertIndexCommand {
        return index(index)
    }
}

class RootDataModifyBlockTargetPosTargetPathMergeFromBlockSourcePosSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyBlockTargetPosTargetPathMergeFromBlockSourcePosCommand(
    parent: CommandNode,
    sourcePos: String
): CommandArgument(parent, sourcePos) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathMergeFromBlockSourcePosSourcePathCommand {
        return RootDataModifyBlockTargetPosTargetPathMergeFromBlockSourcePosSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathMergeFromBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun sourcePos(sourcePos: String): RootDataModifyBlockTargetPosTargetPathMergeFromBlockSourcePosCommand {
        return RootDataModifyBlockTargetPosTargetPathMergeFromBlockSourcePosCommand(this, sourcePos)
    }

    operator fun invoke(sourcePos: String, sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathMergeFromBlockSourcePosSourcePathCommand {
        return sourcePos(sourcePos).sourcePath(sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathMergeFromEntitySourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyBlockTargetPosTargetPathMergeFromEntitySourceCommand(
    parent: CommandNode,
    source: Selector
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathMergeFromEntitySourceSourcePathCommand {
        return RootDataModifyBlockTargetPosTargetPathMergeFromEntitySourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathMergeFromEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun source(source: Selector): RootDataModifyBlockTargetPosTargetPathMergeFromEntitySourceCommand {
        return RootDataModifyBlockTargetPosTargetPathMergeFromEntitySourceCommand(this, source)
    }

    operator fun invoke(source: Selector, sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathMergeFromEntitySourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathMergeFromStorageSourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyBlockTargetPosTargetPathMergeFromStorageSourceCommand(
    parent: CommandNode,
    source: String
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathMergeFromStorageSourceSourcePathCommand {
        return RootDataModifyBlockTargetPosTargetPathMergeFromStorageSourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathMergeFromStorageCommand(
    parent: CommandNode
): CommandLiteral(parent, "storage") {
    fun source(source: String): RootDataModifyBlockTargetPosTargetPathMergeFromStorageSourceCommand {
        return RootDataModifyBlockTargetPosTargetPathMergeFromStorageSourceCommand(this, source)
    }

    operator fun invoke(source: String, sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathMergeFromStorageSourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathMergeFromCommand(
    parent: CommandNode
): CommandLiteral(parent, "from") {
    val block = RootDataModifyBlockTargetPosTargetPathMergeFromBlockCommand(this)
    val entity = RootDataModifyBlockTargetPosTargetPathMergeFromEntityCommand(this)
    val storage = RootDataModifyBlockTargetPosTargetPathMergeFromStorageCommand(this)
}

class RootDataModifyBlockTargetPosTargetPathMergeValueValueCommand(
    parent: CommandNode,
    value: String
): CommandArgument(parent, value)

class RootDataModifyBlockTargetPosTargetPathMergeValueCommand(
    parent: CommandNode
): CommandLiteral(parent, "value") {
    fun value(value: String): RootDataModifyBlockTargetPosTargetPathMergeValueValueCommand {
        return RootDataModifyBlockTargetPosTargetPathMergeValueValueCommand(this, value)
    }

    operator fun invoke(value: String): RootDataModifyBlockTargetPosTargetPathMergeValueValueCommand {
        return value(value)
    }
}

class RootDataModifyBlockTargetPosTargetPathMergeCommand(
    parent: CommandNode
): CommandLiteral(parent, "merge") {
    val from = RootDataModifyBlockTargetPosTargetPathMergeFromCommand(this)
    val value = RootDataModifyBlockTargetPosTargetPathMergeValueCommand(this)
}

class RootDataModifyBlockTargetPosTargetPathPrependFromBlockSourcePosSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyBlockTargetPosTargetPathPrependFromBlockSourcePosCommand(
    parent: CommandNode,
    sourcePos: String
): CommandArgument(parent, sourcePos) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathPrependFromBlockSourcePosSourcePathCommand {
        return RootDataModifyBlockTargetPosTargetPathPrependFromBlockSourcePosSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathPrependFromBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun sourcePos(sourcePos: String): RootDataModifyBlockTargetPosTargetPathPrependFromBlockSourcePosCommand {
        return RootDataModifyBlockTargetPosTargetPathPrependFromBlockSourcePosCommand(this, sourcePos)
    }

    operator fun invoke(sourcePos: String, sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathPrependFromBlockSourcePosSourcePathCommand {
        return sourcePos(sourcePos).sourcePath(sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathPrependFromEntitySourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyBlockTargetPosTargetPathPrependFromEntitySourceCommand(
    parent: CommandNode,
    source: Selector
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathPrependFromEntitySourceSourcePathCommand {
        return RootDataModifyBlockTargetPosTargetPathPrependFromEntitySourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathPrependFromEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun source(source: Selector): RootDataModifyBlockTargetPosTargetPathPrependFromEntitySourceCommand {
        return RootDataModifyBlockTargetPosTargetPathPrependFromEntitySourceCommand(this, source)
    }

    operator fun invoke(source: Selector, sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathPrependFromEntitySourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathPrependFromStorageSourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyBlockTargetPosTargetPathPrependFromStorageSourceCommand(
    parent: CommandNode,
    source: String
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathPrependFromStorageSourceSourcePathCommand {
        return RootDataModifyBlockTargetPosTargetPathPrependFromStorageSourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathPrependFromStorageCommand(
    parent: CommandNode
): CommandLiteral(parent, "storage") {
    fun source(source: String): RootDataModifyBlockTargetPosTargetPathPrependFromStorageSourceCommand {
        return RootDataModifyBlockTargetPosTargetPathPrependFromStorageSourceCommand(this, source)
    }

    operator fun invoke(source: String, sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathPrependFromStorageSourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathPrependFromCommand(
    parent: CommandNode
): CommandLiteral(parent, "from") {
    val block = RootDataModifyBlockTargetPosTargetPathPrependFromBlockCommand(this)
    val entity = RootDataModifyBlockTargetPosTargetPathPrependFromEntityCommand(this)
    val storage = RootDataModifyBlockTargetPosTargetPathPrependFromStorageCommand(this)
}

class RootDataModifyBlockTargetPosTargetPathPrependValueValueCommand(
    parent: CommandNode,
    value: String
): CommandArgument(parent, value)

class RootDataModifyBlockTargetPosTargetPathPrependValueCommand(
    parent: CommandNode
): CommandLiteral(parent, "value") {
    fun value(value: String): RootDataModifyBlockTargetPosTargetPathPrependValueValueCommand {
        return RootDataModifyBlockTargetPosTargetPathPrependValueValueCommand(this, value)
    }

    operator fun invoke(value: String): RootDataModifyBlockTargetPosTargetPathPrependValueValueCommand {
        return value(value)
    }
}

class RootDataModifyBlockTargetPosTargetPathPrependCommand(
    parent: CommandNode
): CommandLiteral(parent, "prepend") {
    val from = RootDataModifyBlockTargetPosTargetPathPrependFromCommand(this)
    val value = RootDataModifyBlockTargetPosTargetPathPrependValueCommand(this)
}

class RootDataModifyBlockTargetPosTargetPathSetFromBlockSourcePosSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyBlockTargetPosTargetPathSetFromBlockSourcePosCommand(
    parent: CommandNode,
    sourcePos: String
): CommandArgument(parent, sourcePos) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathSetFromBlockSourcePosSourcePathCommand {
        return RootDataModifyBlockTargetPosTargetPathSetFromBlockSourcePosSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathSetFromBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun sourcePos(sourcePos: String): RootDataModifyBlockTargetPosTargetPathSetFromBlockSourcePosCommand {
        return RootDataModifyBlockTargetPosTargetPathSetFromBlockSourcePosCommand(this, sourcePos)
    }

    operator fun invoke(sourcePos: String, sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathSetFromBlockSourcePosSourcePathCommand {
        return sourcePos(sourcePos).sourcePath(sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathSetFromEntitySourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyBlockTargetPosTargetPathSetFromEntitySourceCommand(
    parent: CommandNode,
    source: Selector
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathSetFromEntitySourceSourcePathCommand {
        return RootDataModifyBlockTargetPosTargetPathSetFromEntitySourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathSetFromEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun source(source: Selector): RootDataModifyBlockTargetPosTargetPathSetFromEntitySourceCommand {
        return RootDataModifyBlockTargetPosTargetPathSetFromEntitySourceCommand(this, source)
    }

    operator fun invoke(source: Selector, sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathSetFromEntitySourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathSetFromStorageSourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyBlockTargetPosTargetPathSetFromStorageSourceCommand(
    parent: CommandNode,
    source: String
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathSetFromStorageSourceSourcePathCommand {
        return RootDataModifyBlockTargetPosTargetPathSetFromStorageSourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathSetFromStorageCommand(
    parent: CommandNode
): CommandLiteral(parent, "storage") {
    fun source(source: String): RootDataModifyBlockTargetPosTargetPathSetFromStorageSourceCommand {
        return RootDataModifyBlockTargetPosTargetPathSetFromStorageSourceCommand(this, source)
    }

    operator fun invoke(source: String, sourcePath: String? = null): RootDataModifyBlockTargetPosTargetPathSetFromStorageSourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyBlockTargetPosTargetPathSetFromCommand(
    parent: CommandNode
): CommandLiteral(parent, "from") {
    val block = RootDataModifyBlockTargetPosTargetPathSetFromBlockCommand(this)
    val entity = RootDataModifyBlockTargetPosTargetPathSetFromEntityCommand(this)
    val storage = RootDataModifyBlockTargetPosTargetPathSetFromStorageCommand(this)
}

class RootDataModifyBlockTargetPosTargetPathSetValueValueCommand(
    parent: CommandNode,
    value: String
): CommandArgument(parent, value)

class RootDataModifyBlockTargetPosTargetPathSetValueCommand(
    parent: CommandNode
): CommandLiteral(parent, "value") {
    fun value(value: String): RootDataModifyBlockTargetPosTargetPathSetValueValueCommand {
        return RootDataModifyBlockTargetPosTargetPathSetValueValueCommand(this, value)
    }

    operator fun invoke(value: String): RootDataModifyBlockTargetPosTargetPathSetValueValueCommand {
        return value(value)
    }
}

class RootDataModifyBlockTargetPosTargetPathSetCommand(
    parent: CommandNode
): CommandLiteral(parent, "set") {
    val from = RootDataModifyBlockTargetPosTargetPathSetFromCommand(this)
    val value = RootDataModifyBlockTargetPosTargetPathSetValueCommand(this)
}

class RootDataModifyBlockTargetPosTargetPathCommand(
    parent: CommandNode,
    targetPath: String
): CommandArgument(parent, targetPath) {
    val append = RootDataModifyBlockTargetPosTargetPathAppendCommand(this)
    val insert = RootDataModifyBlockTargetPosTargetPathInsertCommand(this)
    val merge = RootDataModifyBlockTargetPosTargetPathMergeCommand(this)
    val prepend = RootDataModifyBlockTargetPosTargetPathPrependCommand(this)
    val set = RootDataModifyBlockTargetPosTargetPathSetCommand(this)
}

class RootDataModifyBlockTargetPosCommand(
    parent: CommandNode,
    targetPos: String
): CommandArgument(parent, targetPos) {
    fun targetPath(targetPath: String): RootDataModifyBlockTargetPosTargetPathCommand {
        return RootDataModifyBlockTargetPosTargetPathCommand(this, targetPath)
    }
}

class RootDataModifyBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun targetPos(targetPos: String): RootDataModifyBlockTargetPosCommand {
        return RootDataModifyBlockTargetPosCommand(this, targetPos)
    }

    operator fun invoke(targetPos: String, targetPath: String): RootDataModifyBlockTargetPosTargetPathCommand {
        return targetPos(targetPos).targetPath(targetPath)
    }
}

class RootDataModifyEntityTargetTargetPathAppendFromBlockSourcePosSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyEntityTargetTargetPathAppendFromBlockSourcePosCommand(
    parent: CommandNode,
    sourcePos: String
): CommandArgument(parent, sourcePos) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyEntityTargetTargetPathAppendFromBlockSourcePosSourcePathCommand {
        return RootDataModifyEntityTargetTargetPathAppendFromBlockSourcePosSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathAppendFromBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun sourcePos(sourcePos: String): RootDataModifyEntityTargetTargetPathAppendFromBlockSourcePosCommand {
        return RootDataModifyEntityTargetTargetPathAppendFromBlockSourcePosCommand(this, sourcePos)
    }

    operator fun invoke(sourcePos: String, sourcePath: String? = null): RootDataModifyEntityTargetTargetPathAppendFromBlockSourcePosSourcePathCommand {
        return sourcePos(sourcePos).sourcePath(sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathAppendFromEntitySourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyEntityTargetTargetPathAppendFromEntitySourceCommand(
    parent: CommandNode,
    source: Selector
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyEntityTargetTargetPathAppendFromEntitySourceSourcePathCommand {
        return RootDataModifyEntityTargetTargetPathAppendFromEntitySourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathAppendFromEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun source(source: Selector): RootDataModifyEntityTargetTargetPathAppendFromEntitySourceCommand {
        return RootDataModifyEntityTargetTargetPathAppendFromEntitySourceCommand(this, source)
    }

    operator fun invoke(source: Selector, sourcePath: String? = null): RootDataModifyEntityTargetTargetPathAppendFromEntitySourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathAppendFromStorageSourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyEntityTargetTargetPathAppendFromStorageSourceCommand(
    parent: CommandNode,
    source: String
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyEntityTargetTargetPathAppendFromStorageSourceSourcePathCommand {
        return RootDataModifyEntityTargetTargetPathAppendFromStorageSourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathAppendFromStorageCommand(
    parent: CommandNode
): CommandLiteral(parent, "storage") {
    fun source(source: String): RootDataModifyEntityTargetTargetPathAppendFromStorageSourceCommand {
        return RootDataModifyEntityTargetTargetPathAppendFromStorageSourceCommand(this, source)
    }

    operator fun invoke(source: String, sourcePath: String? = null): RootDataModifyEntityTargetTargetPathAppendFromStorageSourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathAppendFromCommand(
    parent: CommandNode
): CommandLiteral(parent, "from") {
    val block = RootDataModifyEntityTargetTargetPathAppendFromBlockCommand(this)
    val entity = RootDataModifyEntityTargetTargetPathAppendFromEntityCommand(this)
    val storage = RootDataModifyEntityTargetTargetPathAppendFromStorageCommand(this)
}

class RootDataModifyEntityTargetTargetPathAppendValueValueCommand(
    parent: CommandNode,
    value: String
): CommandArgument(parent, value)

class RootDataModifyEntityTargetTargetPathAppendValueCommand(
    parent: CommandNode
): CommandLiteral(parent, "value") {
    fun value(value: String): RootDataModifyEntityTargetTargetPathAppendValueValueCommand {
        return RootDataModifyEntityTargetTargetPathAppendValueValueCommand(this, value)
    }

    operator fun invoke(value: String): RootDataModifyEntityTargetTargetPathAppendValueValueCommand {
        return value(value)
    }
}

class RootDataModifyEntityTargetTargetPathAppendCommand(
    parent: CommandNode
): CommandLiteral(parent, "append") {
    val from = RootDataModifyEntityTargetTargetPathAppendFromCommand(this)
    val value = RootDataModifyEntityTargetTargetPathAppendValueCommand(this)
}

class RootDataModifyEntityTargetTargetPathInsertIndexFromBlockSourcePosSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyEntityTargetTargetPathInsertIndexFromBlockSourcePosCommand(
    parent: CommandNode,
    sourcePos: String
): CommandArgument(parent, sourcePos) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyEntityTargetTargetPathInsertIndexFromBlockSourcePosSourcePathCommand {
        return RootDataModifyEntityTargetTargetPathInsertIndexFromBlockSourcePosSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathInsertIndexFromBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun sourcePos(sourcePos: String): RootDataModifyEntityTargetTargetPathInsertIndexFromBlockSourcePosCommand {
        return RootDataModifyEntityTargetTargetPathInsertIndexFromBlockSourcePosCommand(this, sourcePos)
    }

    operator fun invoke(sourcePos: String, sourcePath: String? = null): RootDataModifyEntityTargetTargetPathInsertIndexFromBlockSourcePosSourcePathCommand {
        return sourcePos(sourcePos).sourcePath(sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathInsertIndexFromEntitySourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyEntityTargetTargetPathInsertIndexFromEntitySourceCommand(
    parent: CommandNode,
    source: Selector
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyEntityTargetTargetPathInsertIndexFromEntitySourceSourcePathCommand {
        return RootDataModifyEntityTargetTargetPathInsertIndexFromEntitySourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathInsertIndexFromEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun source(source: Selector): RootDataModifyEntityTargetTargetPathInsertIndexFromEntitySourceCommand {
        return RootDataModifyEntityTargetTargetPathInsertIndexFromEntitySourceCommand(this, source)
    }

    operator fun invoke(source: Selector, sourcePath: String? = null): RootDataModifyEntityTargetTargetPathInsertIndexFromEntitySourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathInsertIndexFromStorageSourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyEntityTargetTargetPathInsertIndexFromStorageSourceCommand(
    parent: CommandNode,
    source: String
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyEntityTargetTargetPathInsertIndexFromStorageSourceSourcePathCommand {
        return RootDataModifyEntityTargetTargetPathInsertIndexFromStorageSourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathInsertIndexFromStorageCommand(
    parent: CommandNode
): CommandLiteral(parent, "storage") {
    fun source(source: String): RootDataModifyEntityTargetTargetPathInsertIndexFromStorageSourceCommand {
        return RootDataModifyEntityTargetTargetPathInsertIndexFromStorageSourceCommand(this, source)
    }

    operator fun invoke(source: String, sourcePath: String? = null): RootDataModifyEntityTargetTargetPathInsertIndexFromStorageSourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathInsertIndexFromCommand(
    parent: CommandNode
): CommandLiteral(parent, "from") {
    val block = RootDataModifyEntityTargetTargetPathInsertIndexFromBlockCommand(this)
    val entity = RootDataModifyEntityTargetTargetPathInsertIndexFromEntityCommand(this)
    val storage = RootDataModifyEntityTargetTargetPathInsertIndexFromStorageCommand(this)
}

class RootDataModifyEntityTargetTargetPathInsertIndexValueValueCommand(
    parent: CommandNode,
    value: String
): CommandArgument(parent, value)

class RootDataModifyEntityTargetTargetPathInsertIndexValueCommand(
    parent: CommandNode
): CommandLiteral(parent, "value") {
    fun value(value: String): RootDataModifyEntityTargetTargetPathInsertIndexValueValueCommand {
        return RootDataModifyEntityTargetTargetPathInsertIndexValueValueCommand(this, value)
    }

    operator fun invoke(value: String): RootDataModifyEntityTargetTargetPathInsertIndexValueValueCommand {
        return value(value)
    }
}

class RootDataModifyEntityTargetTargetPathInsertIndexCommand(
    parent: CommandNode,
    index: Int
): CommandArgument(parent, index) {
    val from = RootDataModifyEntityTargetTargetPathInsertIndexFromCommand(this)
    val value = RootDataModifyEntityTargetTargetPathInsertIndexValueCommand(this)
}

class RootDataModifyEntityTargetTargetPathInsertCommand(
    parent: CommandNode
): CommandLiteral(parent, "insert") {
    fun index(index: Int): RootDataModifyEntityTargetTargetPathInsertIndexCommand {
        return RootDataModifyEntityTargetTargetPathInsertIndexCommand(this, index)
    }

    operator fun invoke(index: Int): RootDataModifyEntityTargetTargetPathInsertIndexCommand {
        return index(index)
    }
}

class RootDataModifyEntityTargetTargetPathMergeFromBlockSourcePosSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyEntityTargetTargetPathMergeFromBlockSourcePosCommand(
    parent: CommandNode,
    sourcePos: String
): CommandArgument(parent, sourcePos) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyEntityTargetTargetPathMergeFromBlockSourcePosSourcePathCommand {
        return RootDataModifyEntityTargetTargetPathMergeFromBlockSourcePosSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathMergeFromBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun sourcePos(sourcePos: String): RootDataModifyEntityTargetTargetPathMergeFromBlockSourcePosCommand {
        return RootDataModifyEntityTargetTargetPathMergeFromBlockSourcePosCommand(this, sourcePos)
    }

    operator fun invoke(sourcePos: String, sourcePath: String? = null): RootDataModifyEntityTargetTargetPathMergeFromBlockSourcePosSourcePathCommand {
        return sourcePos(sourcePos).sourcePath(sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathMergeFromEntitySourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyEntityTargetTargetPathMergeFromEntitySourceCommand(
    parent: CommandNode,
    source: Selector
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyEntityTargetTargetPathMergeFromEntitySourceSourcePathCommand {
        return RootDataModifyEntityTargetTargetPathMergeFromEntitySourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathMergeFromEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun source(source: Selector): RootDataModifyEntityTargetTargetPathMergeFromEntitySourceCommand {
        return RootDataModifyEntityTargetTargetPathMergeFromEntitySourceCommand(this, source)
    }

    operator fun invoke(source: Selector, sourcePath: String? = null): RootDataModifyEntityTargetTargetPathMergeFromEntitySourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathMergeFromStorageSourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyEntityTargetTargetPathMergeFromStorageSourceCommand(
    parent: CommandNode,
    source: String
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyEntityTargetTargetPathMergeFromStorageSourceSourcePathCommand {
        return RootDataModifyEntityTargetTargetPathMergeFromStorageSourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathMergeFromStorageCommand(
    parent: CommandNode
): CommandLiteral(parent, "storage") {
    fun source(source: String): RootDataModifyEntityTargetTargetPathMergeFromStorageSourceCommand {
        return RootDataModifyEntityTargetTargetPathMergeFromStorageSourceCommand(this, source)
    }

    operator fun invoke(source: String, sourcePath: String? = null): RootDataModifyEntityTargetTargetPathMergeFromStorageSourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathMergeFromCommand(
    parent: CommandNode
): CommandLiteral(parent, "from") {
    val block = RootDataModifyEntityTargetTargetPathMergeFromBlockCommand(this)
    val entity = RootDataModifyEntityTargetTargetPathMergeFromEntityCommand(this)
    val storage = RootDataModifyEntityTargetTargetPathMergeFromStorageCommand(this)
}

class RootDataModifyEntityTargetTargetPathMergeValueValueCommand(
    parent: CommandNode,
    value: String
): CommandArgument(parent, value)

class RootDataModifyEntityTargetTargetPathMergeValueCommand(
    parent: CommandNode
): CommandLiteral(parent, "value") {
    fun value(value: String): RootDataModifyEntityTargetTargetPathMergeValueValueCommand {
        return RootDataModifyEntityTargetTargetPathMergeValueValueCommand(this, value)
    }

    operator fun invoke(value: String): RootDataModifyEntityTargetTargetPathMergeValueValueCommand {
        return value(value)
    }
}

class RootDataModifyEntityTargetTargetPathMergeCommand(
    parent: CommandNode
): CommandLiteral(parent, "merge") {
    val from = RootDataModifyEntityTargetTargetPathMergeFromCommand(this)
    val value = RootDataModifyEntityTargetTargetPathMergeValueCommand(this)
}

class RootDataModifyEntityTargetTargetPathPrependFromBlockSourcePosSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyEntityTargetTargetPathPrependFromBlockSourcePosCommand(
    parent: CommandNode,
    sourcePos: String
): CommandArgument(parent, sourcePos) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyEntityTargetTargetPathPrependFromBlockSourcePosSourcePathCommand {
        return RootDataModifyEntityTargetTargetPathPrependFromBlockSourcePosSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathPrependFromBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun sourcePos(sourcePos: String): RootDataModifyEntityTargetTargetPathPrependFromBlockSourcePosCommand {
        return RootDataModifyEntityTargetTargetPathPrependFromBlockSourcePosCommand(this, sourcePos)
    }

    operator fun invoke(sourcePos: String, sourcePath: String? = null): RootDataModifyEntityTargetTargetPathPrependFromBlockSourcePosSourcePathCommand {
        return sourcePos(sourcePos).sourcePath(sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathPrependFromEntitySourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyEntityTargetTargetPathPrependFromEntitySourceCommand(
    parent: CommandNode,
    source: Selector
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyEntityTargetTargetPathPrependFromEntitySourceSourcePathCommand {
        return RootDataModifyEntityTargetTargetPathPrependFromEntitySourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathPrependFromEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun source(source: Selector): RootDataModifyEntityTargetTargetPathPrependFromEntitySourceCommand {
        return RootDataModifyEntityTargetTargetPathPrependFromEntitySourceCommand(this, source)
    }

    operator fun invoke(source: Selector, sourcePath: String? = null): RootDataModifyEntityTargetTargetPathPrependFromEntitySourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathPrependFromStorageSourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyEntityTargetTargetPathPrependFromStorageSourceCommand(
    parent: CommandNode,
    source: String
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyEntityTargetTargetPathPrependFromStorageSourceSourcePathCommand {
        return RootDataModifyEntityTargetTargetPathPrependFromStorageSourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathPrependFromStorageCommand(
    parent: CommandNode
): CommandLiteral(parent, "storage") {
    fun source(source: String): RootDataModifyEntityTargetTargetPathPrependFromStorageSourceCommand {
        return RootDataModifyEntityTargetTargetPathPrependFromStorageSourceCommand(this, source)
    }

    operator fun invoke(source: String, sourcePath: String? = null): RootDataModifyEntityTargetTargetPathPrependFromStorageSourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathPrependFromCommand(
    parent: CommandNode
): CommandLiteral(parent, "from") {
    val block = RootDataModifyEntityTargetTargetPathPrependFromBlockCommand(this)
    val entity = RootDataModifyEntityTargetTargetPathPrependFromEntityCommand(this)
    val storage = RootDataModifyEntityTargetTargetPathPrependFromStorageCommand(this)
}

class RootDataModifyEntityTargetTargetPathPrependValueValueCommand(
    parent: CommandNode,
    value: String
): CommandArgument(parent, value)

class RootDataModifyEntityTargetTargetPathPrependValueCommand(
    parent: CommandNode
): CommandLiteral(parent, "value") {
    fun value(value: String): RootDataModifyEntityTargetTargetPathPrependValueValueCommand {
        return RootDataModifyEntityTargetTargetPathPrependValueValueCommand(this, value)
    }

    operator fun invoke(value: String): RootDataModifyEntityTargetTargetPathPrependValueValueCommand {
        return value(value)
    }
}

class RootDataModifyEntityTargetTargetPathPrependCommand(
    parent: CommandNode
): CommandLiteral(parent, "prepend") {
    val from = RootDataModifyEntityTargetTargetPathPrependFromCommand(this)
    val value = RootDataModifyEntityTargetTargetPathPrependValueCommand(this)
}

class RootDataModifyEntityTargetTargetPathSetFromBlockSourcePosSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyEntityTargetTargetPathSetFromBlockSourcePosCommand(
    parent: CommandNode,
    sourcePos: String
): CommandArgument(parent, sourcePos) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyEntityTargetTargetPathSetFromBlockSourcePosSourcePathCommand {
        return RootDataModifyEntityTargetTargetPathSetFromBlockSourcePosSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathSetFromBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun sourcePos(sourcePos: String): RootDataModifyEntityTargetTargetPathSetFromBlockSourcePosCommand {
        return RootDataModifyEntityTargetTargetPathSetFromBlockSourcePosCommand(this, sourcePos)
    }

    operator fun invoke(sourcePos: String, sourcePath: String? = null): RootDataModifyEntityTargetTargetPathSetFromBlockSourcePosSourcePathCommand {
        return sourcePos(sourcePos).sourcePath(sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathSetFromEntitySourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyEntityTargetTargetPathSetFromEntitySourceCommand(
    parent: CommandNode,
    source: Selector
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyEntityTargetTargetPathSetFromEntitySourceSourcePathCommand {
        return RootDataModifyEntityTargetTargetPathSetFromEntitySourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathSetFromEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun source(source: Selector): RootDataModifyEntityTargetTargetPathSetFromEntitySourceCommand {
        return RootDataModifyEntityTargetTargetPathSetFromEntitySourceCommand(this, source)
    }

    operator fun invoke(source: Selector, sourcePath: String? = null): RootDataModifyEntityTargetTargetPathSetFromEntitySourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathSetFromStorageSourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyEntityTargetTargetPathSetFromStorageSourceCommand(
    parent: CommandNode,
    source: String
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyEntityTargetTargetPathSetFromStorageSourceSourcePathCommand {
        return RootDataModifyEntityTargetTargetPathSetFromStorageSourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathSetFromStorageCommand(
    parent: CommandNode
): CommandLiteral(parent, "storage") {
    fun source(source: String): RootDataModifyEntityTargetTargetPathSetFromStorageSourceCommand {
        return RootDataModifyEntityTargetTargetPathSetFromStorageSourceCommand(this, source)
    }

    operator fun invoke(source: String, sourcePath: String? = null): RootDataModifyEntityTargetTargetPathSetFromStorageSourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyEntityTargetTargetPathSetFromCommand(
    parent: CommandNode
): CommandLiteral(parent, "from") {
    val block = RootDataModifyEntityTargetTargetPathSetFromBlockCommand(this)
    val entity = RootDataModifyEntityTargetTargetPathSetFromEntityCommand(this)
    val storage = RootDataModifyEntityTargetTargetPathSetFromStorageCommand(this)
}

class RootDataModifyEntityTargetTargetPathSetValueValueCommand(
    parent: CommandNode,
    value: String
): CommandArgument(parent, value)

class RootDataModifyEntityTargetTargetPathSetValueCommand(
    parent: CommandNode
): CommandLiteral(parent, "value") {
    fun value(value: String): RootDataModifyEntityTargetTargetPathSetValueValueCommand {
        return RootDataModifyEntityTargetTargetPathSetValueValueCommand(this, value)
    }

    operator fun invoke(value: String): RootDataModifyEntityTargetTargetPathSetValueValueCommand {
        return value(value)
    }
}

class RootDataModifyEntityTargetTargetPathSetCommand(
    parent: CommandNode
): CommandLiteral(parent, "set") {
    val from = RootDataModifyEntityTargetTargetPathSetFromCommand(this)
    val value = RootDataModifyEntityTargetTargetPathSetValueCommand(this)
}

class RootDataModifyEntityTargetTargetPathCommand(
    parent: CommandNode,
    targetPath: String
): CommandArgument(parent, targetPath) {
    val append = RootDataModifyEntityTargetTargetPathAppendCommand(this)
    val insert = RootDataModifyEntityTargetTargetPathInsertCommand(this)
    val merge = RootDataModifyEntityTargetTargetPathMergeCommand(this)
    val prepend = RootDataModifyEntityTargetTargetPathPrependCommand(this)
    val set = RootDataModifyEntityTargetTargetPathSetCommand(this)
}

class RootDataModifyEntityTargetCommand(
    parent: CommandNode,
    target: Selector
): CommandArgument(parent, target) {
    fun targetPath(targetPath: String): RootDataModifyEntityTargetTargetPathCommand {
        return RootDataModifyEntityTargetTargetPathCommand(this, targetPath)
    }
}

class RootDataModifyEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun target(target: Selector): RootDataModifyEntityTargetCommand {
        return RootDataModifyEntityTargetCommand(this, target)
    }

    operator fun invoke(target: Selector, targetPath: String): RootDataModifyEntityTargetTargetPathCommand {
        return target(target).targetPath(targetPath)
    }
}

class RootDataModifyStorageTargetTargetPathAppendFromBlockSourcePosSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyStorageTargetTargetPathAppendFromBlockSourcePosCommand(
    parent: CommandNode,
    sourcePos: String
): CommandArgument(parent, sourcePos) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyStorageTargetTargetPathAppendFromBlockSourcePosSourcePathCommand {
        return RootDataModifyStorageTargetTargetPathAppendFromBlockSourcePosSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathAppendFromBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun sourcePos(sourcePos: String): RootDataModifyStorageTargetTargetPathAppendFromBlockSourcePosCommand {
        return RootDataModifyStorageTargetTargetPathAppendFromBlockSourcePosCommand(this, sourcePos)
    }

    operator fun invoke(sourcePos: String, sourcePath: String? = null): RootDataModifyStorageTargetTargetPathAppendFromBlockSourcePosSourcePathCommand {
        return sourcePos(sourcePos).sourcePath(sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathAppendFromEntitySourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyStorageTargetTargetPathAppendFromEntitySourceCommand(
    parent: CommandNode,
    source: Selector
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyStorageTargetTargetPathAppendFromEntitySourceSourcePathCommand {
        return RootDataModifyStorageTargetTargetPathAppendFromEntitySourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathAppendFromEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun source(source: Selector): RootDataModifyStorageTargetTargetPathAppendFromEntitySourceCommand {
        return RootDataModifyStorageTargetTargetPathAppendFromEntitySourceCommand(this, source)
    }

    operator fun invoke(source: Selector, sourcePath: String? = null): RootDataModifyStorageTargetTargetPathAppendFromEntitySourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathAppendFromStorageSourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyStorageTargetTargetPathAppendFromStorageSourceCommand(
    parent: CommandNode,
    source: String
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyStorageTargetTargetPathAppendFromStorageSourceSourcePathCommand {
        return RootDataModifyStorageTargetTargetPathAppendFromStorageSourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathAppendFromStorageCommand(
    parent: CommandNode
): CommandLiteral(parent, "storage") {
    fun source(source: String): RootDataModifyStorageTargetTargetPathAppendFromStorageSourceCommand {
        return RootDataModifyStorageTargetTargetPathAppendFromStorageSourceCommand(this, source)
    }

    operator fun invoke(source: String, sourcePath: String? = null): RootDataModifyStorageTargetTargetPathAppendFromStorageSourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathAppendFromCommand(
    parent: CommandNode
): CommandLiteral(parent, "from") {
    val block = RootDataModifyStorageTargetTargetPathAppendFromBlockCommand(this)
    val entity = RootDataModifyStorageTargetTargetPathAppendFromEntityCommand(this)
    val storage = RootDataModifyStorageTargetTargetPathAppendFromStorageCommand(this)
}

class RootDataModifyStorageTargetTargetPathAppendValueValueCommand(
    parent: CommandNode,
    value: String
): CommandArgument(parent, value)

class RootDataModifyStorageTargetTargetPathAppendValueCommand(
    parent: CommandNode
): CommandLiteral(parent, "value") {
    fun value(value: String): RootDataModifyStorageTargetTargetPathAppendValueValueCommand {
        return RootDataModifyStorageTargetTargetPathAppendValueValueCommand(this, value)
    }

    operator fun invoke(value: String): RootDataModifyStorageTargetTargetPathAppendValueValueCommand {
        return value(value)
    }
}

class RootDataModifyStorageTargetTargetPathAppendCommand(
    parent: CommandNode
): CommandLiteral(parent, "append") {
    val from = RootDataModifyStorageTargetTargetPathAppendFromCommand(this)
    val value = RootDataModifyStorageTargetTargetPathAppendValueCommand(this)
}

class RootDataModifyStorageTargetTargetPathInsertIndexFromBlockSourcePosSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyStorageTargetTargetPathInsertIndexFromBlockSourcePosCommand(
    parent: CommandNode,
    sourcePos: String
): CommandArgument(parent, sourcePos) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyStorageTargetTargetPathInsertIndexFromBlockSourcePosSourcePathCommand {
        return RootDataModifyStorageTargetTargetPathInsertIndexFromBlockSourcePosSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathInsertIndexFromBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun sourcePos(sourcePos: String): RootDataModifyStorageTargetTargetPathInsertIndexFromBlockSourcePosCommand {
        return RootDataModifyStorageTargetTargetPathInsertIndexFromBlockSourcePosCommand(this, sourcePos)
    }

    operator fun invoke(sourcePos: String, sourcePath: String? = null): RootDataModifyStorageTargetTargetPathInsertIndexFromBlockSourcePosSourcePathCommand {
        return sourcePos(sourcePos).sourcePath(sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathInsertIndexFromEntitySourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyStorageTargetTargetPathInsertIndexFromEntitySourceCommand(
    parent: CommandNode,
    source: Selector
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyStorageTargetTargetPathInsertIndexFromEntitySourceSourcePathCommand {
        return RootDataModifyStorageTargetTargetPathInsertIndexFromEntitySourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathInsertIndexFromEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun source(source: Selector): RootDataModifyStorageTargetTargetPathInsertIndexFromEntitySourceCommand {
        return RootDataModifyStorageTargetTargetPathInsertIndexFromEntitySourceCommand(this, source)
    }

    operator fun invoke(source: Selector, sourcePath: String? = null): RootDataModifyStorageTargetTargetPathInsertIndexFromEntitySourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathInsertIndexFromStorageSourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyStorageTargetTargetPathInsertIndexFromStorageSourceCommand(
    parent: CommandNode,
    source: String
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyStorageTargetTargetPathInsertIndexFromStorageSourceSourcePathCommand {
        return RootDataModifyStorageTargetTargetPathInsertIndexFromStorageSourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathInsertIndexFromStorageCommand(
    parent: CommandNode
): CommandLiteral(parent, "storage") {
    fun source(source: String): RootDataModifyStorageTargetTargetPathInsertIndexFromStorageSourceCommand {
        return RootDataModifyStorageTargetTargetPathInsertIndexFromStorageSourceCommand(this, source)
    }

    operator fun invoke(source: String, sourcePath: String? = null): RootDataModifyStorageTargetTargetPathInsertIndexFromStorageSourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathInsertIndexFromCommand(
    parent: CommandNode
): CommandLiteral(parent, "from") {
    val block = RootDataModifyStorageTargetTargetPathInsertIndexFromBlockCommand(this)
    val entity = RootDataModifyStorageTargetTargetPathInsertIndexFromEntityCommand(this)
    val storage = RootDataModifyStorageTargetTargetPathInsertIndexFromStorageCommand(this)
}

class RootDataModifyStorageTargetTargetPathInsertIndexValueValueCommand(
    parent: CommandNode,
    value: String
): CommandArgument(parent, value)

class RootDataModifyStorageTargetTargetPathInsertIndexValueCommand(
    parent: CommandNode
): CommandLiteral(parent, "value") {
    fun value(value: String): RootDataModifyStorageTargetTargetPathInsertIndexValueValueCommand {
        return RootDataModifyStorageTargetTargetPathInsertIndexValueValueCommand(this, value)
    }

    operator fun invoke(value: String): RootDataModifyStorageTargetTargetPathInsertIndexValueValueCommand {
        return value(value)
    }
}

class RootDataModifyStorageTargetTargetPathInsertIndexCommand(
    parent: CommandNode,
    index: Int
): CommandArgument(parent, index) {
    val from = RootDataModifyStorageTargetTargetPathInsertIndexFromCommand(this)
    val value = RootDataModifyStorageTargetTargetPathInsertIndexValueCommand(this)
}

class RootDataModifyStorageTargetTargetPathInsertCommand(
    parent: CommandNode
): CommandLiteral(parent, "insert") {
    fun index(index: Int): RootDataModifyStorageTargetTargetPathInsertIndexCommand {
        return RootDataModifyStorageTargetTargetPathInsertIndexCommand(this, index)
    }

    operator fun invoke(index: Int): RootDataModifyStorageTargetTargetPathInsertIndexCommand {
        return index(index)
    }
}

class RootDataModifyStorageTargetTargetPathMergeFromBlockSourcePosSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyStorageTargetTargetPathMergeFromBlockSourcePosCommand(
    parent: CommandNode,
    sourcePos: String
): CommandArgument(parent, sourcePos) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyStorageTargetTargetPathMergeFromBlockSourcePosSourcePathCommand {
        return RootDataModifyStorageTargetTargetPathMergeFromBlockSourcePosSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathMergeFromBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun sourcePos(sourcePos: String): RootDataModifyStorageTargetTargetPathMergeFromBlockSourcePosCommand {
        return RootDataModifyStorageTargetTargetPathMergeFromBlockSourcePosCommand(this, sourcePos)
    }

    operator fun invoke(sourcePos: String, sourcePath: String? = null): RootDataModifyStorageTargetTargetPathMergeFromBlockSourcePosSourcePathCommand {
        return sourcePos(sourcePos).sourcePath(sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathMergeFromEntitySourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyStorageTargetTargetPathMergeFromEntitySourceCommand(
    parent: CommandNode,
    source: Selector
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyStorageTargetTargetPathMergeFromEntitySourceSourcePathCommand {
        return RootDataModifyStorageTargetTargetPathMergeFromEntitySourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathMergeFromEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun source(source: Selector): RootDataModifyStorageTargetTargetPathMergeFromEntitySourceCommand {
        return RootDataModifyStorageTargetTargetPathMergeFromEntitySourceCommand(this, source)
    }

    operator fun invoke(source: Selector, sourcePath: String? = null): RootDataModifyStorageTargetTargetPathMergeFromEntitySourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathMergeFromStorageSourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyStorageTargetTargetPathMergeFromStorageSourceCommand(
    parent: CommandNode,
    source: String
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyStorageTargetTargetPathMergeFromStorageSourceSourcePathCommand {
        return RootDataModifyStorageTargetTargetPathMergeFromStorageSourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathMergeFromStorageCommand(
    parent: CommandNode
): CommandLiteral(parent, "storage") {
    fun source(source: String): RootDataModifyStorageTargetTargetPathMergeFromStorageSourceCommand {
        return RootDataModifyStorageTargetTargetPathMergeFromStorageSourceCommand(this, source)
    }

    operator fun invoke(source: String, sourcePath: String? = null): RootDataModifyStorageTargetTargetPathMergeFromStorageSourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathMergeFromCommand(
    parent: CommandNode
): CommandLiteral(parent, "from") {
    val block = RootDataModifyStorageTargetTargetPathMergeFromBlockCommand(this)
    val entity = RootDataModifyStorageTargetTargetPathMergeFromEntityCommand(this)
    val storage = RootDataModifyStorageTargetTargetPathMergeFromStorageCommand(this)
}

class RootDataModifyStorageTargetTargetPathMergeValueValueCommand(
    parent: CommandNode,
    value: String
): CommandArgument(parent, value)

class RootDataModifyStorageTargetTargetPathMergeValueCommand(
    parent: CommandNode
): CommandLiteral(parent, "value") {
    fun value(value: String): RootDataModifyStorageTargetTargetPathMergeValueValueCommand {
        return RootDataModifyStorageTargetTargetPathMergeValueValueCommand(this, value)
    }

    operator fun invoke(value: String): RootDataModifyStorageTargetTargetPathMergeValueValueCommand {
        return value(value)
    }
}

class RootDataModifyStorageTargetTargetPathMergeCommand(
    parent: CommandNode
): CommandLiteral(parent, "merge") {
    val from = RootDataModifyStorageTargetTargetPathMergeFromCommand(this)
    val value = RootDataModifyStorageTargetTargetPathMergeValueCommand(this)
}

class RootDataModifyStorageTargetTargetPathPrependFromBlockSourcePosSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyStorageTargetTargetPathPrependFromBlockSourcePosCommand(
    parent: CommandNode,
    sourcePos: String
): CommandArgument(parent, sourcePos) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyStorageTargetTargetPathPrependFromBlockSourcePosSourcePathCommand {
        return RootDataModifyStorageTargetTargetPathPrependFromBlockSourcePosSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathPrependFromBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun sourcePos(sourcePos: String): RootDataModifyStorageTargetTargetPathPrependFromBlockSourcePosCommand {
        return RootDataModifyStorageTargetTargetPathPrependFromBlockSourcePosCommand(this, sourcePos)
    }

    operator fun invoke(sourcePos: String, sourcePath: String? = null): RootDataModifyStorageTargetTargetPathPrependFromBlockSourcePosSourcePathCommand {
        return sourcePos(sourcePos).sourcePath(sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathPrependFromEntitySourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyStorageTargetTargetPathPrependFromEntitySourceCommand(
    parent: CommandNode,
    source: Selector
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyStorageTargetTargetPathPrependFromEntitySourceSourcePathCommand {
        return RootDataModifyStorageTargetTargetPathPrependFromEntitySourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathPrependFromEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun source(source: Selector): RootDataModifyStorageTargetTargetPathPrependFromEntitySourceCommand {
        return RootDataModifyStorageTargetTargetPathPrependFromEntitySourceCommand(this, source)
    }

    operator fun invoke(source: Selector, sourcePath: String? = null): RootDataModifyStorageTargetTargetPathPrependFromEntitySourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathPrependFromStorageSourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyStorageTargetTargetPathPrependFromStorageSourceCommand(
    parent: CommandNode,
    source: String
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyStorageTargetTargetPathPrependFromStorageSourceSourcePathCommand {
        return RootDataModifyStorageTargetTargetPathPrependFromStorageSourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathPrependFromStorageCommand(
    parent: CommandNode
): CommandLiteral(parent, "storage") {
    fun source(source: String): RootDataModifyStorageTargetTargetPathPrependFromStorageSourceCommand {
        return RootDataModifyStorageTargetTargetPathPrependFromStorageSourceCommand(this, source)
    }

    operator fun invoke(source: String, sourcePath: String? = null): RootDataModifyStorageTargetTargetPathPrependFromStorageSourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathPrependFromCommand(
    parent: CommandNode
): CommandLiteral(parent, "from") {
    val block = RootDataModifyStorageTargetTargetPathPrependFromBlockCommand(this)
    val entity = RootDataModifyStorageTargetTargetPathPrependFromEntityCommand(this)
    val storage = RootDataModifyStorageTargetTargetPathPrependFromStorageCommand(this)
}

class RootDataModifyStorageTargetTargetPathPrependValueValueCommand(
    parent: CommandNode,
    value: String
): CommandArgument(parent, value)

class RootDataModifyStorageTargetTargetPathPrependValueCommand(
    parent: CommandNode
): CommandLiteral(parent, "value") {
    fun value(value: String): RootDataModifyStorageTargetTargetPathPrependValueValueCommand {
        return RootDataModifyStorageTargetTargetPathPrependValueValueCommand(this, value)
    }

    operator fun invoke(value: String): RootDataModifyStorageTargetTargetPathPrependValueValueCommand {
        return value(value)
    }
}

class RootDataModifyStorageTargetTargetPathPrependCommand(
    parent: CommandNode
): CommandLiteral(parent, "prepend") {
    val from = RootDataModifyStorageTargetTargetPathPrependFromCommand(this)
    val value = RootDataModifyStorageTargetTargetPathPrependValueCommand(this)
}

class RootDataModifyStorageTargetTargetPathSetFromBlockSourcePosSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyStorageTargetTargetPathSetFromBlockSourcePosCommand(
    parent: CommandNode,
    sourcePos: String
): CommandArgument(parent, sourcePos) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyStorageTargetTargetPathSetFromBlockSourcePosSourcePathCommand {
        return RootDataModifyStorageTargetTargetPathSetFromBlockSourcePosSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathSetFromBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun sourcePos(sourcePos: String): RootDataModifyStorageTargetTargetPathSetFromBlockSourcePosCommand {
        return RootDataModifyStorageTargetTargetPathSetFromBlockSourcePosCommand(this, sourcePos)
    }

    operator fun invoke(sourcePos: String, sourcePath: String? = null): RootDataModifyStorageTargetTargetPathSetFromBlockSourcePosSourcePathCommand {
        return sourcePos(sourcePos).sourcePath(sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathSetFromEntitySourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyStorageTargetTargetPathSetFromEntitySourceCommand(
    parent: CommandNode,
    source: Selector
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyStorageTargetTargetPathSetFromEntitySourceSourcePathCommand {
        return RootDataModifyStorageTargetTargetPathSetFromEntitySourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathSetFromEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun source(source: Selector): RootDataModifyStorageTargetTargetPathSetFromEntitySourceCommand {
        return RootDataModifyStorageTargetTargetPathSetFromEntitySourceCommand(this, source)
    }

    operator fun invoke(source: Selector, sourcePath: String? = null): RootDataModifyStorageTargetTargetPathSetFromEntitySourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathSetFromStorageSourceSourcePathCommand(
    parent: CommandNode,
    sourcePath: String? = null
): CommandArgument(parent, sourcePath)

class RootDataModifyStorageTargetTargetPathSetFromStorageSourceCommand(
    parent: CommandNode,
    source: String
): CommandArgument(parent, source) {
    fun sourcePath(sourcePath: String? = null): RootDataModifyStorageTargetTargetPathSetFromStorageSourceSourcePathCommand {
        return RootDataModifyStorageTargetTargetPathSetFromStorageSourceSourcePathCommand(this, sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathSetFromStorageCommand(
    parent: CommandNode
): CommandLiteral(parent, "storage") {
    fun source(source: String): RootDataModifyStorageTargetTargetPathSetFromStorageSourceCommand {
        return RootDataModifyStorageTargetTargetPathSetFromStorageSourceCommand(this, source)
    }

    operator fun invoke(source: String, sourcePath: String? = null): RootDataModifyStorageTargetTargetPathSetFromStorageSourceSourcePathCommand {
        return source(source).sourcePath(sourcePath)
    }
}

class RootDataModifyStorageTargetTargetPathSetFromCommand(
    parent: CommandNode
): CommandLiteral(parent, "from") {
    val block = RootDataModifyStorageTargetTargetPathSetFromBlockCommand(this)
    val entity = RootDataModifyStorageTargetTargetPathSetFromEntityCommand(this)
    val storage = RootDataModifyStorageTargetTargetPathSetFromStorageCommand(this)
}

class RootDataModifyStorageTargetTargetPathSetValueValueCommand(
    parent: CommandNode,
    value: String
): CommandArgument(parent, value)

class RootDataModifyStorageTargetTargetPathSetValueCommand(
    parent: CommandNode
): CommandLiteral(parent, "value") {
    fun value(value: String): RootDataModifyStorageTargetTargetPathSetValueValueCommand {
        return RootDataModifyStorageTargetTargetPathSetValueValueCommand(this, value)
    }

    operator fun invoke(value: String): RootDataModifyStorageTargetTargetPathSetValueValueCommand {
        return value(value)
    }
}

class RootDataModifyStorageTargetTargetPathSetCommand(
    parent: CommandNode
): CommandLiteral(parent, "set") {
    val from = RootDataModifyStorageTargetTargetPathSetFromCommand(this)
    val value = RootDataModifyStorageTargetTargetPathSetValueCommand(this)
}

class RootDataModifyStorageTargetTargetPathCommand(
    parent: CommandNode,
    targetPath: String
): CommandArgument(parent, targetPath) {
    val append = RootDataModifyStorageTargetTargetPathAppendCommand(this)
    val insert = RootDataModifyStorageTargetTargetPathInsertCommand(this)
    val merge = RootDataModifyStorageTargetTargetPathMergeCommand(this)
    val prepend = RootDataModifyStorageTargetTargetPathPrependCommand(this)
    val set = RootDataModifyStorageTargetTargetPathSetCommand(this)
}

class RootDataModifyStorageTargetCommand(
    parent: CommandNode,
    target: String
): CommandArgument(parent, target) {
    fun targetPath(targetPath: String): RootDataModifyStorageTargetTargetPathCommand {
        return RootDataModifyStorageTargetTargetPathCommand(this, targetPath)
    }
}

class RootDataModifyStorageCommand(
    parent: CommandNode
): CommandLiteral(parent, "storage") {
    fun target(target: String): RootDataModifyStorageTargetCommand {
        return RootDataModifyStorageTargetCommand(this, target)
    }

    operator fun invoke(target: String, targetPath: String): RootDataModifyStorageTargetTargetPathCommand {
        return target(target).targetPath(targetPath)
    }
}

class RootDataModifyCommand(
    parent: CommandNode
): CommandLiteral(parent, "modify") {
    val block = RootDataModifyBlockCommand(this)
    val entity = RootDataModifyEntityCommand(this)
    val storage = RootDataModifyStorageCommand(this)
}

class RootDataRemoveBlockTargetPosPathCommand(
    parent: CommandNode,
    path: String
): CommandArgument(parent, path)

class RootDataRemoveBlockTargetPosCommand(
    parent: CommandNode,
    targetPos: String
): CommandArgument(parent, targetPos) {
    fun path(path: String): RootDataRemoveBlockTargetPosPathCommand {
        return RootDataRemoveBlockTargetPosPathCommand(this, path)
    }
}

class RootDataRemoveBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun targetPos(targetPos: String): RootDataRemoveBlockTargetPosCommand {
        return RootDataRemoveBlockTargetPosCommand(this, targetPos)
    }

    operator fun invoke(targetPos: String, path: String): RootDataRemoveBlockTargetPosPathCommand {
        return targetPos(targetPos).path(path)
    }
}

class RootDataRemoveEntityTargetPathCommand(
    parent: CommandNode,
    path: String
): CommandArgument(parent, path)

class RootDataRemoveEntityTargetCommand(
    parent: CommandNode,
    target: Selector
): CommandArgument(parent, target) {
    fun path(path: String): RootDataRemoveEntityTargetPathCommand {
        return RootDataRemoveEntityTargetPathCommand(this, path)
    }
}

class RootDataRemoveEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun target(target: Selector): RootDataRemoveEntityTargetCommand {
        return RootDataRemoveEntityTargetCommand(this, target)
    }

    operator fun invoke(target: Selector, path: String): RootDataRemoveEntityTargetPathCommand {
        return target(target).path(path)
    }
}

class RootDataRemoveStorageTargetPathCommand(
    parent: CommandNode,
    path: String
): CommandArgument(parent, path)

class RootDataRemoveStorageTargetCommand(
    parent: CommandNode,
    target: String
): CommandArgument(parent, target) {
    fun path(path: String): RootDataRemoveStorageTargetPathCommand {
        return RootDataRemoveStorageTargetPathCommand(this, path)
    }
}

class RootDataRemoveStorageCommand(
    parent: CommandNode
): CommandLiteral(parent, "storage") {
    fun target(target: String): RootDataRemoveStorageTargetCommand {
        return RootDataRemoveStorageTargetCommand(this, target)
    }

    operator fun invoke(target: String, path: String): RootDataRemoveStorageTargetPathCommand {
        return target(target).path(path)
    }
}

class RootDataRemoveCommand(
    parent: CommandNode
): CommandLiteral(parent, "remove") {
    val block = RootDataRemoveBlockCommand(this)
    val entity = RootDataRemoveEntityCommand(this)
    val storage = RootDataRemoveStorageCommand(this)
}

class RootDataCommand(
    parent: CommandNode?,
    literal: String? = "data"
): CommandLiteral(parent, literal) {
    val get = RootDataGetCommand(this)
    val merge = RootDataMergeCommand(this)
    val modify = RootDataModifyCommand(this)
    val remove = RootDataRemoveCommand(this)
}
val data = RootDataCommand(null)