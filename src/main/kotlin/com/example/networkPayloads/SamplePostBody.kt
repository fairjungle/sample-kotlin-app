package com.example.networkPayloads

import kotlinx.serialization.Serializable

@Serializable
data class SamplePostBody(
    val attribute1: String,
    val attribute2: Int
)
