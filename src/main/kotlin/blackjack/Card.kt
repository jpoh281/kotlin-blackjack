package blackjack

data class Card(val value: Int, val suit: Suit = Suit.Spade) {

    init {
        print(value)
        require(value in IntRange(1, 13)) {
            "카드의 숫자는 1과 13의 범위에 포함되어야 합니다."
        }
    }
}
