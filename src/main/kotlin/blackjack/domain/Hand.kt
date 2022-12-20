package blackjack.domain

private const val MAX_HAND_VALUE = 21

class Hand(cards: List<Card> = emptyList()) {

    private val _cards = cards.toMutableList()

    val cards
        get() = _cards.toList()

    val value: Int
        get() = calculateValue()

    val isMax: Boolean
        get() = value >= MAX_HAND_VALUE

    fun add(vararg cards: Card) {
        require(!isMax) {
            "21 이상인 경우 카드를 더 뽑을 수 없습니다"
        }

        _cards.addAll(cards)
    }

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
