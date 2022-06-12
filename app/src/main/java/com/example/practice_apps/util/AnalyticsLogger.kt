package com.example.practice_apps.util

import com.example.practice_apps.di.AnalyticsScope
import javax.inject.Inject

@AnalyticsScope
class AnalyticsLogger

// Notice that even though we don't actually inject anything in this constructor,
// we use @Inject annotation to make Dagger generate a provider for this class
// so that we don't actually need to create a module and write a @Provide method.
// This is a very common mistake beginners do with Dagger. This is possible since
// this class doesn't implement any interface which we're injecting somewhere.
@Inject
constructor() {
    fun logEvent(event: String) {
    }
}
