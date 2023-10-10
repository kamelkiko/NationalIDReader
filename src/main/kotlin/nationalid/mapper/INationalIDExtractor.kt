package nationalid.mapper

interface INationalIDExtractor {
    fun extractMonth(id: String, vararg indexes: Int): Int

    fun extractDay(id: String, vararg indexes: Int): Int

    fun extractYear(id: String, vararg indexes: Int): Int

    fun extractCentury(id: String,vararg indexes: Int): Int

    fun extractGenderCode(id: String, vararg indexes: Int): Int

    fun extractGovernorate(id: String, vararg indexes: Int): String

    fun extractGenerationComputerCode(id: String, vararg indexes: Int): Int

    fun extractCheckDigit(id: String, vararg indexes: Int): Int
}