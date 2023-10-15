package nationalid

import nationalid.extractor.INationalIDExtractor
import nationalid.extractor.NationalIDExtractor
import nationalid.model.NationalIDFormatException
import nationalid.util.INationalIDValidator
import nationalid.util.NationalIDValidator

class NationalIDReader(nationalID: String) {
    private val validator: INationalIDValidator = NationalIDValidator(nationalID)
    private val extractor: INationalIDExtractor = NationalIDExtractor(nationalID)

    init {
        validator.validate()
    }

    fun getCheckDigitOfNationalID() = extractor.extractCheckDigit()


    fun getGender(): String {
        val genderCode = extractor.extractGenderCode()
        return if (genderCode % 2 == 0) FEMALE else MALE
    }


    fun getGenerationComputerCode() = extractor.extractGenerationComputerCode()


    fun getGovernorate() = extractor.extractGovernorate()


    fun getMonth(): Int {
        val month = extractor.extractMonth()
        return if (month in 1..12) month
        else throw NationalIDFormatException("$INVALID_MONTH: $month")
    }


    fun getDay(): Int {
        val day = extractor.extractDay()
        return if (day in 1..31) day
        else throw NationalIDFormatException("$INVALID_DAY: $day")
    }


    fun getYear() = extractor.extractYear()


    companion object {
        private const val MALE = "Male"
        private const val FEMALE = "Female"
        private const val INVALID_MONTH = "Invalid month"
        private const val INVALID_DAY = "Invalid day"
    }

}