package nationalid.model

open class NationalIDException(message: String?) : Exception(message)

class UnknownCityException(message: String?) : NationalIDException(message)

open class ValidationException(message: String?) : NationalIDException(message)

class NationalIDFormatException(message: String?) : ValidationException(message)