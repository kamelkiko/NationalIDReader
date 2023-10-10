package nationalid.model

data class NationalID(
    val generationCode: Int,
    val month: Int,
    val day: Int,
    val year: Int,
    val gender: String,
    val governorate: String,
    val checkDigit: Int,
)
