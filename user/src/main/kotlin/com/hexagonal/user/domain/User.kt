package com.hexagonal.user.domain

import com.hexagonal.user.domain.enums.Role
import com.hexagonal.user.domain.enums.UserStatus
import com.hexagonal.user.domain.vo.Email
import com.hexagonal.user.domain.vo.UserId

class User private constructor(
    val id: UserId,
    email: Email,
    name: String,
    role: Role,
    status: UserStatus,
) {
    var email: Email = email
        private set

    var name: String = name
        private set

    var role: Role = role
        private set

    var status: UserStatus = status
        private set

    companion object {
        fun create(
            id: UserId,
            email: Email,
            name: String,
            role: Role = Role.USER,
            status: UserStatus = UserStatus.PENDING,
        ): User = User(id, email, name, role, status)
    }

    fun activate() {
        this.status = UserStatus.ACTIVE
    }

    fun deactivate() {
        this.status = UserStatus.INACTIVE
    }

    fun changeRole(newRole: Role) {
        this.role = newRole
    }

    fun rename(newName: String) {
        this.name = newName
    }
}
