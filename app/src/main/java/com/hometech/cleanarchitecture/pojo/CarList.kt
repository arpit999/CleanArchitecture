package com.hometech.cleanarchitecture.pojo

data class CarList(
    val backfillCount: Int,
    val dealerNewCount: Int,
    val dealerUsedCount: Int,
    val enhancedCount: Int,
    val listings: List<Listings>,
    val page: Int,
    val pageSize: Int,
    val seoUrl: String,
    val totalListingCount: Int,
    val totalPageCount: Int
)