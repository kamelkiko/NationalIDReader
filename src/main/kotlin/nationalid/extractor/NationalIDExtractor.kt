package nationalid.extractor

import nationalid.model.Governorate
import nationalid.model.UnknownCityException


class NationalIDExtractor(private val nationalID: String) : INationalIDExtractor {

    override fun extractMonth() = mapFromIDToData(*MONTH_INDEXES)


    override fun extractDay() = mapFromIDToData(*DAY_INDEXES)


    override fun extractYear() = calculateYear()

    private fun calculateYear() = mapFromIDToData(*YEAR_INDEXES) + extractCentury()


    private fun extractCentury() = calculateCentury(mapFromIDToData(CENTURY_INDEX))


    private fun calculateCentury(centuryCode: Int) =
        if (centuryCode == BASE_CENTURY_CODE) BASE_YEAR
        else ((centuryCode * CENTURY) - CENTURY) + BASE_YEAR


    override fun extractGenderCode() = mapFromIDToData(GENDER_INDEX)


    override fun extractGovernorate() =
        Governorate.getGovernorate(mapFromIDToData(*GOVERNORATE_INDEXES))
            ?: throw UnknownCityException(UN_KNOWN_CITY_CODE)


    override fun extractGenerationComputerCode() = mapFromIDToData(*GENERATION_COMPUTER_CODE_INDEXES)


    override fun extractCheckDigit() = mapFromIDToData(nationalID.lastIndex)

    private fun mapFromIDToData(vararg indexes: Int): Int {
        var data = ""
        indexes.forEach { index ->
            data += nationalID[index].toString()
        }
        return data.toInt()
    }


    companion object {
        private const val BASE_YEAR = 1800
        private const val BASE_CENTURY_CODE = 1
        private const val CENTURY = 100
        private val MONTH_INDEXES = intArrayOf(3, 4)
        private val DAY_INDEXES = intArrayOf(5, 6)
        private val YEAR_INDEXES = intArrayOf(1, 2)
        private const val CENTURY_INDEX = 0
        private val GOVERNORATE_INDEXES = intArrayOf(7, 8)
        private val GENERATION_COMPUTER_CODE_INDEXES = intArrayOf(9, 10, 11, 12)
        private const val GENDER_INDEX = 12
        private const val UN_KNOWN_CITY_CODE = "Unknown city code"
    }
}