package com.hometech.cleanarchitecture.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String = "default",
    val phone: String = "111-111-111",
    val email: String = "default@test.ca"
) {
}