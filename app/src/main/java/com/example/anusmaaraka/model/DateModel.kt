package com.example.anusmaaraka.model

data class DateModel(
    var name: String,
    var type: DateType = DateType.EKADASHI,
    var date: String,
)


enum class DateType {
    EKADASHI,
    STANDARD,
    CHATURDASHI
}