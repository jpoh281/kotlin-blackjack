package blackjack

data class Card(val value: CardNumber, val suit: Suit = Suit.Spade) {

    override fun toString(): String {
        return "$value${suit.character}"
    }
}
