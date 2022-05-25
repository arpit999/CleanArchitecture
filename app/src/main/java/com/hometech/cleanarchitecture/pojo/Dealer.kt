package com.hometech.cleanarchitecture.pojo

data class Dealer(
    val address: String,
    val backfill: Boolean,
    val carfaxId: String,
    val city: String,
    val dealerAverageRating: String,
    val dealerInventoryUrl: String,
    val dealerLeadType: String,
    val dealerReviewComments: String,
    val dealerReviewCount: String,
    val dealerReviewDate: String,
    val dealerReviewRating: String,
    val dealerReviewReviewer: String,
    val dealerReviewTitle: String,
    val latitude: String,
    val longitude: String,
    val name: String,
    val onlineOnly: Boolean,
    val phone: String,
    val state: String,
    val zip: String
)