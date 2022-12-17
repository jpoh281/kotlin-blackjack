package blackjack

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CardNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13])
    fun `카드는 1과 13사이의 값이어야 한다`(value: Int) {
        assertThat(CardNumber(value)).isEqualTo(CardNumber(value))
    }

    @Test
    fun `범위에 포함되지 않는 값을 넣으면 오류를 반환한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            CardNumber(0)
        }
        assertThat(exception.message).isEqualTo("카드의 숫자는 1과 13의 범위에 포함되어야 합니다.")
    }

    @Test
    fun `1은 A로 출력된다`() {
        assertThat(CardNumber(1).toString()).isEqualTo("A")
    }

    @ParameterizedTest
    @ValueSource(ints = [2, 3, 4, 5, 6, 7, 8, 9, 10])
    fun `2에서 10까지는 숫자 그대로 출력된다`(value: Int) {
        assertThat(CardNumber(value).toString()).isEqualTo(value.toString())
    }

    @Test
    fun `11은 J로 출력된다`() {
        assertThat(CardNumber(11).toString()).isEqualTo("J")
    }

    @Test
    fun `12은 Q로 출력된다`() {
        assertThat(CardNumber(12).toString()).isEqualTo("Q")
    }

    @Test
    fun `13은 K로 출력된다`() {
        assertThat(CardNumber(13).toString()).isEqualTo("K")
    }
}
