package com.example.networkPayloads

import kotlinx.serialization.Serializable

@Serializable
data class SamplePostResponse(
    val stringValue: String,
    val numberValue: Int,
    val message: String,
)
