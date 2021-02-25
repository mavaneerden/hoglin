package block.blocks

import block.Block
import block.properties.Direction

object FurnaceBlock {
    const val name = "minecraft:furnace"

    operator fun invoke(
        facing: Direction? = null,
        lit: Boolean? = null,
        nbtFunction: (() -> String)? = null
    ): Block {
        return Block(name, nbtFunction, facing, lit)
    }

    override fun toString(): String {
        return name
    }
}

val furnace: FurnaceBlock = FurnaceBlock

val a = furnace(facing = Direction.EAST, lit = false){"Items:[{id:'minecraft:stone', Count:1b}]"}
