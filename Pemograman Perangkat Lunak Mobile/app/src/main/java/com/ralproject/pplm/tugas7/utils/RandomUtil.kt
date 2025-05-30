package com.ralproject.pplm.tugas7.utils

import java.util.concurrent.atomic.AtomicInteger

object RandomUtil  {
    private val seed = AtomicInteger()
    fun getRandomInt(): Int = seed.incrementAndGet() + System.currentTimeMillis().toInt()
}
