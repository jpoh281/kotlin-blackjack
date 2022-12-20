package blackjack.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PlayerTest {

    @Test
    fun `공백 문자열을 넣으면 Player 객체를 생성할 수 없다`() {
        val exception = org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            Player(" ")
        }

        assertThat(exception.message).isEqualTo("이름은 공백이 될 수 없습니다")
    }

    @Test
    fun `빈 문자열을 넣으면 Player 객체를 생성할 수 없다`() {
        val exception = org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            Player("")
        }

        assertThat(exception.message).isEqualTo("이름은 공백이 될 수 없습니다")
    }

    @Test
    fun `문자열을 넣으면 Player 객체를 생성할 수 있다`() {
        assertThat(Player("홍종표").name).isEqualTo("홍종표")
    }
}
