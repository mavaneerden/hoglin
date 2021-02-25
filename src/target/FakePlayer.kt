package target

class FakePlayer(val name: String): Target() {
    override fun toString(): String {
        return name
    }
}