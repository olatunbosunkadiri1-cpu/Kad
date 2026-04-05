package com.example.arbitragescanner

import kotlin.math.max

class ArbitrageDetector {
    data class Bet(val bookmaker: String, val odds: Double)

    fun parseOdds(oddsList: List<Double>): List<Bet> {
        return oddsList.mapIndexed { index, odds ->
            Bet(bookmaker = "Bookmaker ${index + 1}", odds = odds)
        }
    }

    fun calculateProfit(bets: List<Bet>): Double {
        val totalInvestment = 100.0  // Example investment
        val totalOdds = bets.sumOf { 1 / it.odds }
        val potentialReturn = totalInvestment * totalOdds

        return potentialReturn - totalInvestment
    }
}