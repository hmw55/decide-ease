package com.hmw.decideease.domain.coinflip.util

import kotlin.random.Random

interface RandomGenerator {
    fun nextInt(util: Int): Int
}

class DefaultRandomGenerator : RandomGenerator {
    private val random = Random(System.currentTimeMillis())
    override fun nextInt(until: Int): Int = random.nextInt(until)
}

class TestRandomGenerator(private val sequence: List<Int>) : RandomGenerator {
    private var index = 0
    override fun nextInt(until: Int): Int {
        val value = sequence[index % sequence.size] % until
        index++
        return value
    }
}