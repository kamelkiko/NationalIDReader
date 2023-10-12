package nationalid.util

import nationalid.model.NationalIDFormatException

class NationalIDValidator(private val nationalID: String) : INationalIDValidator {
    override fun validate() {
        if (nationalID.length != 14)
            throw NationalIDFormatException("National ID must be 14 numbers")
        if (containsNonNumericCharacters(nationalID))
            throw NationalIDFormatException("National ID shouldn't contain any characters")
        if (nationalID.first().digitToInt() <= 0)
            throw NationalIDFormatException("National ID should start with 1 or bigger than it")
    }

    private fun containsNonNumericCharacters(input: String): Boolean {
        val regex = Regex(NATIONAL_ID_PATTERN)
        return regex.containsMatchIn(input)
    }


    companion object {
        private const val NATIONAL_ID_PATTERN = "[^0-9]"
    }
}