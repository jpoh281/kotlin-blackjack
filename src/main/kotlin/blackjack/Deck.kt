package blackjack

class Deck(
    cards: List<Card> = Suit.Spade.makeSuitSet() + Suit.Diamond.makeSuitSet() + Suit.Heart.makeSuitSet() + Suit.Club.makeSuitSet()
) {

    private val _cards = cards.toMutableList()
    val cards
        get() = _cards.toList()

    fun shuffle() {
        _cards.shuffle()
    }

    fun draw(count: Int): List<Card> {

        require(_cards.size >= count) {
            "남아있는 카드보다 많은 수의 카드를 뽑을 수 없습니다"
        }

        val drawnCards = mutableListOf<Card>()
        repeat(count) {
            drawnCards.add(_cards.removeFirst())
        }
        return drawnCards
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Deck) return false

        if (_cards != other._cards) return false

        return true
    }

    override fun hashCode(): Int {
        return _cards.hashCode()
    }
}
