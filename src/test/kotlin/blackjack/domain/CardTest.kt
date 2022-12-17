package blackjack.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

fun Int.toCard(): Card {
    return Card(CardNumber(this), suit = Suit.Spade)
}

internal class CardTest {

    @ParameterizedTest
    @ValueSource(ints = [2, 3, 4, 5, 6, 7, 8, 9, 10])
    fun `2부터 10까지의 숫자는 동일한 가치를 지닌다`(number: Int) {
        assertThat(number.toCard().calculateValue()).isEqualTo(number)
    }

    @ParameterizedTest
    @ValueSource(ints = [11, 12, 13])
    fun `J Q K는 10의 가치를 지닌다`(number: Int) {
        assertThat(number.toCard().calculateValue()).isEqualTo(10)
    }

    @ParameterizedTest
    @ValueSource(booleans = [true, false])
    fun `10보다 큰 점수를 가질 때는 A를 더 가지고 있는지 없는지 유무와 관계없이 1의 가치를 지닌다`(hasMoreAce: Boolean) {
        assertThat(1.toCard().calculateValue(isGreaterThan10 = true, hasMoreAce = hasMoreAce)).isEqualTo(1)
    }

    @Test
    fun `10보다 크지 않을 때 A를 더 가지고 있다면 1의 가치를 지닌다`() {
        assertThat(1.toCard().calculateValue(isGreaterThan10 = false, hasMoreAce = true)).isEqualTo(1)
    }

    @Test
    fun `10보다 크지 않을 때 A를 더 가지고 있지 않다면 1의 가치를 지닌다`() {
        assertThat(1.toCard().calculateValue(isGreaterThan10 = false, hasMoreAce = false)).isEqualTo(11)
    }

    @Test
    fun `숫자 문양의 형태로 출력된다`() {
        assertThat(Card(CardNumber(1), Suit.Spade).toString()).isEqualTo("A스페이드")
    }
}
