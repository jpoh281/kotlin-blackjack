package blackjack.domain

private val NUMBER_RANGE = IntRange(2, 10)
private val FACE_RANGE = IntRange(11, 13)

data class CardNumber(val value: Int) {

    val isNumber
        get() = value in NUMBER_RANGE

    val isFace
        get() = value in FACE_RANGE

    val isAce
        get() = value == 1

    init {
        require(value in IntRange(1, 13)) {
            "카드의 숫자는 1과 13의 범위에 포함되어야 합니다."
        }
    }

    override fun toString(): String {
        return when (value) {
            1 -> "A"
            11 -> "J"
            12 -> "Q"
            13 -> "K"
            else -> value.toString()
        }
    }
}
