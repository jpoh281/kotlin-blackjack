package blackjack.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

private const val INIT_DECK_COUNT = 52

internal class DeckTest {

    @Test
    fun `처음 덱의 카드 장 수는 52장이다`() {
        assertThat(Deck().cards.size).isEqualTo(52)
    }

    @Test
    fun `셔플을 통해 덱을 섞을 수 있다`() {
        val deck = Deck()
        assertThat(deck).isEqualTo(Deck())
        deck.shuffle()
        assertThat(deck).isNotEqualTo(Deck())
    }

    @Test
    fun `카드를 뽑을 수 있다`() {
        val deck = Deck()

        assertThat(deck.cards.size).isEqualTo(INIT_DECK_COUNT)
        val drawnCards = deck.draw(1)

        assertThat(deck.cards.size).isEqualTo(51)
        assertThat(drawnCards.size).isEqualTo(1)
    }

    @Test
    fun `덱에 카드가 존재하지 않을 때 뽑으면 에러를 반환한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Deck(emptyList()).draw(1)
        }

        assertThat(exception.message).isEqualTo("남아있는 카드보다 많은 수의 카드를 뽑을 수 없습니다")
    }
}
