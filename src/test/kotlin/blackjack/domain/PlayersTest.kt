package blackjack.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class PlayersTest {

    @Test
    fun `빈 배열을 넣으면 Players 객체를 생성할 수 없다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Players(emptyList())
        }

        assertThat(exception.message).isEqualTo("참가자가 한명도 없을 수 없습니다.")
    }

    @Test
    fun `문자열 배열을 넣으면 Players 객체를 생성할 수 있다`() {
        val players = Players(listOf("홍종표", "박재성"))

        assertThat(players.value.size).isEqualTo(2)
    }
}
