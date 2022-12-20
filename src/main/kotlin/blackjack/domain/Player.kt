package blackjack.domain

class Player(val name: String) {
    init {
        require(name.isNotBlank()) {
            "이름은 공백이 될 수 없습니다"
        }
    }
}
