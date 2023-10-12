package nationalid.extractor

interface INationalIDExtractor {
    fun extractMonth(): Int

    fun extractDay(): Int

    fun extractYear(): Int

    fun extractCentury(): Int

    fun extractGenderCode(): Int

    fun extractGovernorate(): String

    fun extractGenerationComputerCode(): Int

    fun extractCheckDigit(): Int
}