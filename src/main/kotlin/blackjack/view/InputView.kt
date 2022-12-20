package blackjack.view

import blackjack.domain.Players

object InputView {

    fun inputPlayerName(): Players {
        println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)")
        val playerNames: String? = readLine()
        require(!playerNames.isNullOrBlank())

        val names = playerNames.split(',')
        return Players(names)
    }
}
