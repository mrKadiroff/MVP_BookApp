package com.example.experiment.Model.bessellerResult

data class BessellerResult(
    val copyright: String,
    val num_results: Int,
    val results: List<Result>,
    val status: String
)