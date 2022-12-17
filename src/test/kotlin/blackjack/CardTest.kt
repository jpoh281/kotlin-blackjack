package blackjack

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CardTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13])
    fun `카드는 1과 13사이의 값이어야 한다`(value: Int) {
        assertThat(Card(value = value)).isEqualTo(Card(value = value))
    }

    @Test
    fun `범위에 포함되지 않는 값을 넣으면 오류를 반환한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Card(value = 0)
        }
        assertThat(exception.message).isEqualTo("카드의 숫자는 1과 13의 범위에 포함되어야 합니다.")
    }
}
