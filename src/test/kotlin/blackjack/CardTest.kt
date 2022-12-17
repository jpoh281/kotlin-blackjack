package blackjack

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CardTest {

    @Test
    fun `숫자 문양의 형태로 출력된다`() {
        assertThat(Card(CardNumber(1), Suit.Spade).toString()).isEqualTo("A스페이드")
    }
}
