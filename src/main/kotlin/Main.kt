import nationalid.NationalIDReader

fun main() {
    val nationalIdReader = NationalIDReader(readln())
    println("Birthday: ${nationalIdReader.getYear()}/${nationalIdReader.getMonth()}/${nationalIdReader.getDay()}")
    println("Age: ${2023 - nationalIdReader.getYear()}")
    println("Year: ${nationalIdReader.getYear()}")
    println("Month: ${nationalIdReader.getMonth()}")
    println("Day: ${nationalIdReader.getDay()}")
    println("Gender: ${nationalIdReader.getGender()}")
    println("City: ${nationalIdReader.getGovernorate()}")
    println("Computer code: ${nationalIdReader.getGenerationComputerCode()}")
    println("Check digit: ${nationalIdReader.getCheckDigitOfNationalID()}")
}