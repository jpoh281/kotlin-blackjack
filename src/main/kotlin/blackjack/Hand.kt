package blackjack

private const val MAX_HAND_VALUE = 21

class Hand(cards: List<Card> = emptyList()) {

    private val _cards = cards.toMutableList()

    val cards
        get() = _cards.toList()

    val value: Int
        get() = calculateValue()

    val isBust: Boolean
        get() = value > 21

    private fun calculateValue(): Int {
        var score = 0

        val numberOrFaceCards = _cards.filter { it.isNumberCard || it.isFaceCard }
        numberOrFaceCards.forEach {
            score += it.calculateValue()
        }

        val aceCards = _cards.filter { it.isAceCard }
        aceCards.forEachIndexed { index, card ->
            score += card.calculateValue(score > 10, index < aceCards.size - 1)
        }

        return score
    }
}
