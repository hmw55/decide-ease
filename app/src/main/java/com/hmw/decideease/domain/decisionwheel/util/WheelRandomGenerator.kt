package com.hmw.decideease.domain.decisionwheel.util


import kotlin.random.Random

class WheelRandomGenerator {
    fun nextInt(upperBound: Int): Int {
        return Random.nextInt(upperBound)
    }
}