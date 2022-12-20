package blackjack.domain

class Players(names: List<String>) {
    val value: List<Player>

    init {
        require(names.isNotEmpty()) {
            "참가자가 한명도 없을 수 없습니다."
        }
        value = names.map { Player(name = it) }
    }
}
