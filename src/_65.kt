class _65 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            isNumber("0")
        }

        enum class State {
            STATE_INITIAL,
            STATE_INT_SIGN,
            STATE_INTEGER,
            STATE_POINT,
            STATE_POINT_WITHOUT_INT,
            STATE_FRACTION,
            STATE_EXP,
            STATE_EXP_SIGN,
            STATE_EXP_NUMBER,
            STATE_END,
        }

        enum class CharType {
            CHAR_NUMBER,
            CHAR_EXP,
            CHAR_POINT,
            CHAR_SIGN,
            CHAR_ILLEGAL,
        }

        private fun Char.toCharType(): CharType {
            when {
                this.isDigit() -> return CharType.CHAR_NUMBER
                this == 'e' || this == 'E' -> {
                    return CharType.CHAR_EXP
                }
                this == '.' -> {
                    return CharType.CHAR_POINT
                }
                this == '+' || this == '-' -> {
                    return CharType.CHAR_SIGN
                }
                else -> return CharType.CHAR_ILLEGAL
            }
        }

        fun isNumber(s: String): Boolean {
            val transfer = mutableMapOf<State, Map<CharType, State>>()
            transfer[State.STATE_INITIAL] = mapOf(
                CharType.CHAR_NUMBER to State.STATE_INTEGER,
                CharType.CHAR_POINT to State.STATE_POINT_WITHOUT_INT,
                CharType.CHAR_SIGN to State.STATE_INT_SIGN
            )
            transfer[State.STATE_INT_SIGN] = mapOf(
                CharType.CHAR_NUMBER to State.STATE_INTEGER,
                CharType.CHAR_POINT to State.STATE_POINT_WITHOUT_INT,
            )
            transfer[State.STATE_INTEGER] = mapOf(
                CharType.CHAR_NUMBER to State.STATE_INTEGER,
                CharType.CHAR_EXP to State.STATE_EXP,
                CharType.CHAR_POINT to State.STATE_POINT,
            )
            transfer[State.STATE_POINT] = mapOf(
                CharType.CHAR_EXP to State.STATE_EXP,
                CharType.CHAR_NUMBER to State.STATE_FRACTION,
            )
            transfer[State.STATE_POINT_WITHOUT_INT] = mapOf(
                CharType.CHAR_NUMBER to State.STATE_FRACTION
            )
            transfer[State.STATE_FRACTION] = mapOf(
                CharType.CHAR_NUMBER to State.STATE_FRACTION,
                CharType.CHAR_EXP to State.STATE_EXP,
            )
            transfer[State.STATE_EXP] = mapOf(
                CharType.CHAR_SIGN to State.STATE_EXP_SIGN,
                CharType.CHAR_NUMBER to State.STATE_EXP_NUMBER
            )
            transfer[State.STATE_EXP_SIGN] = mapOf(
                CharType.CHAR_NUMBER to State.STATE_EXP_NUMBER
            )
            transfer[State.STATE_EXP_NUMBER] = mapOf(
                CharType.CHAR_NUMBER to State.STATE_EXP_NUMBER
            )

            var state = State.STATE_INITIAL
            for (c in s) {
                val type = c.toCharType()
                if (!transfer[state]!!.contains(type)) {
                    return false
                }
                state = transfer[state]!![type]!!
            }

            return state == State.STATE_INTEGER || state == State.STATE_POINT
                    || state == State.STATE_FRACTION || state == State.STATE_EXP_NUMBER
                    || state == State.STATE_END
        }
    }
}