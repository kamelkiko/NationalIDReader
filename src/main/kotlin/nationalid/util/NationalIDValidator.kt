package nationalid.util

import nationalid.model.NationalIDFormatException

class NationalIDValidator(private val nationalID: String) : INationalIDValidator {
    override fun validate() {
        require(nationalID.length == 14) {
            throw NationalIDFormatException(NATIONAL_ID_LENGTH_EXCEPTION_MSG)
        }
        require(nationalID.first().digitToInt() > 0) {
            throw NationalIDFormatException(NATIONAL_ID_FIRST_NUMBER_EXCEPTION_MSG)
        }
        require(containsNumericCharacters(nationalID)) {
            throw NationalIDFormatException(NATIONAL_ID_REQUIRE_CHARACTERS_EXCEPTION_MSG)
        }
    }

    private fun containsNumericCharacters(input: String): Boolean {
        val regex = Regex(NATIONAL_ID_PATTERN)
        return regex.containsMatchIn(input).not()
    }


    companion object {
        private const val NATIONAL_ID_PATTERN = "[^0-9]"
        private const val NATIONAL_ID_LENGTH_EXCEPTION_MSG = "National ID must be 14 numbers"
        private const val NATIONAL_ID_FIRST_NUMBER_EXCEPTION_MSG = "National ID should start with 1 or bigger than it"
        private const val NATIONAL_ID_REQUIRE_CHARACTERS_EXCEPTION_MSG = "National ID shouldn't contain any characters"
    }
}