package nationalid

import nationalid.mapper.INationalIDExtractor
import nationalid.model.NationalIDFormatException
import nationalid.model.UnknownCityException

class NationalIDReader(
    private val nationalID: String, private val extractor: INationalIDExtractor
) {
    init {
        validateNationalID()
    }

    fun getCheckDigitOfNationalID() = extractor.extractCheckDigit(nationalID, nationalID.lastIndex)


    fun getGender(): String {
        val genderCode = extractor.extractGenderCode(nationalID, 12)
        return if (genderCode % 2 == 0) FEMALE else MALE
    }


    fun getGenerationComputerCode() = extractor.extractGenerationComputerCode(nationalID, 9, 10, 11, 12)


    fun getGovernorate() =
        try {
            extractor.extractGovernorate(nationalID, 7, 8)
        } catch (e: Exception) {
            throw UnknownCityException(e.message)
        }


    fun getMonth(): Int {
        val month = extractor.extractMonth(nationalID, 3, 4)
        return if (month in 1..12) month
        else throw NationalIDFormatException("Invalid month: $month")
    }


    fun getDay(): Int {
        val day = extractor.extractMonth(nationalID, 5, 6)
        return if (day in 1..31) day
        else throw NationalIDFormatException("Invalid day: $day")
    }


    fun getYear() = calculateYear()

    private fun calculateYear() = extractor.extractYear(nationalID, 1, 2).plus(
        extractor.extractCentury(nationalID, 0)
    )


    private fun validateNationalID() {
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
        private const val MALE = "Male"
        private const val FEMALE = "Female"
    }
}