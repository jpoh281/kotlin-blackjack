package blackjack.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class HandTest {

    @Test
    fun `처음 생성된 핸드는 빈 배열을 가지며 value = 0, isMax = false 이다`() {
        val hand = Hand()
        assertThat(hand.cards).isEqualTo(emptyList<Card>())
        assertThat(hand.isMax).isEqualTo(false)
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
    fun `21 이상 때 isMax = true 이다`() {
        val hand = Hand(listOf(2.toCard(), 12.toCard(), 13.toCard()))
        assertThat(hand.isMax).isEqualTo(true)
    }

    @Test
    fun `isMax = false 일 때 카드를 더 가질 수 있다`() {
        val hand = Hand(listOf(2.toCard(), 8.toCard()))
        assertThat(hand.value).isEqualTo(10)

        hand.add(1.toCard())
        assertThat(hand.value).isEqualTo(21)
    }

    @Test
    fun `isMax = true 일 때 카드를 더 가질 수 없다`() {
        val hand = Hand(listOf(2.toCard(), 12.toCard(), 13.toCard()))

        val exception = assertThrows<IllegalArgumentException> {
            hand.add(1.toCard())
        }

        assertThat(exception.message).isEqualTo("21 이상인 경우 카드를 더 뽑을 수 없습니다")
    }
}
