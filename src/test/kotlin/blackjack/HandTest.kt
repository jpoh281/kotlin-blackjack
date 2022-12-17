package blackjack

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
internal class HandTest {

    @Test
    fun `처음 생성된 핸드는 빈 배열을 가지며 value = 0, isBust = false 이다`() {
        val hand = Hand()
        assertThat(hand.cards).isEqualTo(emptyList<Card>())
        assertThat(hand.isBust).isEqualTo(false)
        assertThat(hand.value).isEqualTo(0)
    }

    @Test
    fun `A, K, Q를 가질 때 점수는 21이다`() {
        val hand = Hand(listOf(1.toCard(), 12.toCard(), 13.toCard()))
        assertThat(hand.value).isEqualTo(21)
    }

    @Test
    fun `A, A를 가질 때 점수는 12이다`() {
        val hand = Hand(listOf(1.toCard(), 1.toCard()))
        assertThat(hand.value).isEqualTo(12)
    }

    @Test
    fun `10, A, A를 가질 때 점수는 12이다`() {
        val hand = Hand(listOf(1.toCard(), 1.toCard(), 10.toCard()))
        assertThat(hand.value).isEqualTo(12)
    }

    @Test
    fun `9, A, A를 가질 때 점수는 21이다`() {
        val hand = Hand(listOf(1.toCard(), 1.toCard(), 9.toCard()))
        assertThat(hand.value).isEqualTo(21)
    }

    @Test
    fun `21을 초과할 때 isBust = true이다`() {
        val hand = Hand(listOf(2.toCard(), 12.toCard(), 13.toCard()))
        assertThat(hand.isBust).isEqualTo(true)
    }
}
