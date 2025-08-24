package com.hexagonal.user.domain.vo

@JvmInline
value class Email(
    val value: String,
) {
    init {
        require(value.contains("@")) { "Invalid email format: $value" }
    }
}
