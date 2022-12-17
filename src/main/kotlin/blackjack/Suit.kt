package blackjack

enum class Suit(val character: String) {
    Spade(character = "스페이드") {
        override fun makeSuitSet(): List<Card> {
            return List(13) { Card(it + 1, Spade) }
        }
    },
    Diamond(character = "다이아몬드") {
        override fun makeSuitSet(): List<Card> {
            return List(13) { Card(it + 1, Diamond) }
        }
    },
    Heart(character = "하트") {
        override fun makeSuitSet(): List<Card> {
            return List(13) { Card(it + 1, Heart) }
        }
    },
    Club(character = "클로버") {
        override fun makeSuitSet(): List<Card> {
            return List(13) { Card(it + 1, Club) }
        }
    };

    abstract fun makeSuitSet(): List<Card>
}
