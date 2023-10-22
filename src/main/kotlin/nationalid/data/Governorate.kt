package nationalid.data

object Governorate {
    private val code = mapOf(
        1 to "Cairo",
        2 to "Alexandria",
        3 to "Port Said",
        4 to "Suez",
        5 to "Helwan",
        6 to "6-Octobor",
        11 to "Damietta",
        12 to "Dakahlia",
        13 to "Sharqia",
        14 to "Qalyubia",
        15 to "Kafr El-Sheikh",
        16 to "Gharbia",
        17 to "Monufia",
        18 to "Beheira",
        19 to "Ismailia",
        21 to "Giza",
        22 to "Beni Suef",
        23 to "Fayoum",
        24 to "Minya",
        25 to "Asyut",
        26 to "Sohag",
        27 to "Qena",
        28 to "Aswan",
        29 to "Luxor",
        31 to "Red Sea",
        32 to "New Valley",
        33 to "Matrouh",
        34 to "North Sinai",
        35 to "South Sinai",
        88 to "Outside Republic",
    )

    fun getGovernorate(key: Int) = code[key]
}