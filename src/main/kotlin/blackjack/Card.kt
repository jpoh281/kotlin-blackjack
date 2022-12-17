package blackjack

private const val FACE_CARD_VALUE = 10
private const val A_MIN_VALUE = 1
private const val A_MAX_VALUE = 11

data class Card(val number: CardNumber, val suit: Suit = Suit.Spade) {

    val isNumberCard: Boolean
        get() = number.isNumber

    val isFaceCard: Boolean
        get() = number.isFace

    val isAceCard: Boolean
        get() = number.isAce

    fun calculateValue(): Int {
        if (isFaceCard) return FACE_CARD_VALUE
        return number.value
    }

    fun calculateValue(isGreaterThan10: Boolean, hasMoreAce: Boolean): Int {
        if(isGreaterThan10) return A_MIN_VALUE
        if(hasMoreAce) return A_MIN_VALUE
        return A_MAX_VALUE
    }

    override fun toString(): String {
        return "$number${suit.character}"
    }
}
