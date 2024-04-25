package com.ougi.callme.di

import io.ktor.client.*
import io.ktor.client.engine.java.*
import org.koin.dsl.module

val appModule = module {
    single { HttpClient(Java) }
}