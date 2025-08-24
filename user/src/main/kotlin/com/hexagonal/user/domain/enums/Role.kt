package com.hexagonal.user.domain.enums

enum class Role {
    ADMIN,
    USER,
    REVIEWER,
    ;

    companion object {
        fun from(value: String): Role =
            entries.firstOrNull {
                it.name.equals(value, ignoreCase = true)
            } ?: throw IllegalArgumentException("Unknown role: $value")
    }
}
