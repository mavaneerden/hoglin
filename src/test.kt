import command.commands.advancement
import command.commands.bossbar
import command.commands.playsound
import command.commands.tp
import command.commands.execute
import command.commands.stopsound
import nbt.baseclasses.Compound
import nbt.baseclasses.TagByte
import nbt.baseclasses.TagCompound
import nbt.baseclasses.TagIntArray
import nbt.baseclasses.TagList
import nbt.baseclasses.TagShort
import nbt.baseclasses.TagString
import target.EntitySelector
import target.PlayerSelector
import vector.Coordinates

fun main() {
    // val target = FakePlayer("player")
    // val objective = Objective("obj")
    // val objective2 = Objective("obj2")
    // val objective3 = Objective("obj3")
    // val score = Score(target, objective)
    // var score2 = Score(target, objective2)
    // var score3 = Score(target, objective3)
    //
    // score.set((score2 - score) / score3 + 1)
    //
    // ifBlock (!((score lt score2) and (score2 gt score)) or (score matches 4..10)) {
    //     // Stuff
    // }
    // elseBlock {
    //     // Stuff
    // }
    //
    // val component = JSONText(
    //     ScoreComponent(score),
    //     TranslateComponent("item.carrot_on_a_stick.name", TextComponent("Carrot Stick")).extra(
    //         SelectorComponent(PlayerSelector()).extra(
    //             KeybindComponent(KeybindIdentifier.LOAD_TOOLBAR_ACTIVATOR),
    //             InsertionComponent("Insert text here")
    //         )
    //     ),
    //     NBTComponent(NBTPath(), entity = PlayerSelector(), interpret = true),
    //     TextComponent("The end")
    // )
    //
    // println(component)
    testCommands()
    testNBT()
}

fun testCommands() {
    val advancementCommand = advancement.grant(PlayerSelector()).everything
    val teleportCommand = tp(PlayerSelector(), Coordinates.forward(.1))
    val playsoundCommand = playsound("").hostile.targets(EntitySelector())
    val executeCommand = execute.unless.data.storage("minecraft:test", "Item.item.item.item.item").store.success
        .block("~~~","Item.block.block").double.scale(1.0).run.xp.query(EntitySelector()).levels
    val bossbarCommand = bossbar.set("s").style.notched12
    val stopsoundCommand = stopsound(PlayerSelector()).all.sound("sound")
    val executeCommand2 = execute.`if`.block("~~~", "")

    println(executeCommand2)
    println(advancementCommand)
    println(teleportCommand)
    println(playsoundCommand)
    println(executeCommand)
    println(bossbarCommand)
    println(stopsoundCommand)

    println(ByteArray(3).apply { set(0, 1); set(1, 127); set(2, -128) }.contentToString())
}

fun testNBT() {
    val a = test {
        Items(
            {
                id("minecraft")
                Count(8)
                tag {
                    Damage(7)
                    someList(1, 2, 3)
                    someList2("hi", "hi", "LOL")
                }
            },
            {
                id("aaaa")
                tag {
                    someList(84, -3)
                }
            }
        )
    }

    println(a)
}

val test = ItemsRoot()
// fun test(func: Compound<ItemsRoot>): ItemsRoot {
//     return ItemsRoot()
// }

class ItemsRoot(
    // value: Compound<ItemsRoot>
// ): TagCompound<ItemsRoot>("", value) {
): TagCompound<ItemsRoot>("") {
    val Items = registerTag(TagList<Item>("Items"))
    // fun Items(vararg values: Compound<Item>) {
    //     registerTag(TagList("Items", values))
    // }
}

class Item(
    name: String = "Item"
    // value: Compound<Item>
// ): TagCompound<Item>(name, value) {
): TagCompound<Item>(name) {
    val id = registerTag(TagString("id"))
    val Count = registerTag(TagByte("Count"))
    val tag = registerTag(ItemTag())
    // fun id(value: String) {
    //     registerTag(TagString("id", value))
    // }
    // fun Count(value: Byte) {
    //     registerTag(TagByte("Count", value))
    // }
    // fun tag(value: Compound<ItemTag>) {
    //     registerTag(ItemTag(value))
    // }
}

class ItemTag(
    // value: Compound<ItemTag>
// ): TagCompound<ItemTag>("tag", value) {
): TagCompound<ItemTag>("tag") {
    val Damage = registerTag(TagShort("Damage"))
    val someList = registerTag(TagIntArray("someList"))
    val someList2 = registerTag(TagList<String>("someList2"))
    // fun Damage(value: Short) {
    //     registerTag(TagShort("Damage", value))
    // }
    // fun someList(vararg value: Int) {
    //     registerTag(TagIntArray("someList", value))
    // }
    // fun someList2(vararg value: String) {
    //     registerTag(TagList("someList2", value))
    // }
}

