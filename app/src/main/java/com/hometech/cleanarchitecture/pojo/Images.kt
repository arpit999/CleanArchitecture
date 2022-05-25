package com.hometech.cleanarchitecture.pojo

data class Images(
    val baseUrl: String,
    val firstPhoto: FirstPhoto,
    val large: List<String>,
    val medium: List<String>,
    val small: List<String>
)