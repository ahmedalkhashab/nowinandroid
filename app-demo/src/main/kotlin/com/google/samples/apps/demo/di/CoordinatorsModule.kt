package com.google.samples.apps.demo.di

import com.google.samples.apps.demo.coordinator.AuthNavigationCoordinator
import com.google.samples.apps.demo.coordinator.PaymentNavigationCoordinator
import com.google.samples.apps.demo.coordinator.LandingNavigationCoordinator
import com.google.samples.apps.demo.coordinator.StoreNavigationCoordinator
import com.google.samples.apps.demo.coordinator.WelcomeNavigationCoordinator
import com.google.samples.apps.demo.coordinator.landing.LandingNavigationEventListener
import com.google.samples.apps.demo.feature.auth.AuthNavigationEventListener
import com.google.samples.apps.demo.feature.payment.PaymentNavigationEventListener
import com.google.samples.apps.demo.feature.store.StoreNavigationEventListener
import com.google.samples.apps.demo.feature.welcome.WelcomeNavigationEventListener
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class) // We Should use ActivityComponent::class
object CoordinatorsModule {

    @Provides // Don't add @Singleton
    fun providesLandingNavigationCoordinator() : LandingNavigationEventListener = LandingNavigationCoordinator()

    @Provides // Don't add @Singleton
    fun providesAuthNavigationCoordinator() : AuthNavigationEventListener = AuthNavigationCoordinator()

    @Provides // Don't add @Singleton
    fun providesWelcomeNavigationCoordinator() : WelcomeNavigationEventListener = WelcomeNavigationCoordinator()

    @Provides // Don't add @Singleton
    fun providesStoreNavigationCoordinator() : StoreNavigationEventListener = StoreNavigationCoordinator()

    @Provides // Don't add @Singleton
    fun providesPaymentNavigationCoordinator() : PaymentNavigationEventListener = PaymentNavigationCoordinator()

}