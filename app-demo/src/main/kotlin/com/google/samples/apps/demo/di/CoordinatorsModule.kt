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
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoordinatorsModule {

    @Provides
    @Singleton
    fun providesLandingNavigationCoordinator() : LandingNavigationEventListener = LandingNavigationCoordinator()

    @Provides
    @Singleton
    fun providesAuthNavigationCoordinator() : AuthNavigationEventListener = AuthNavigationCoordinator()

    @Provides
    @Singleton
    fun providesWelcomeNavigationCoordinator() : WelcomeNavigationEventListener = WelcomeNavigationCoordinator()

    @Provides
    @Singleton
    fun providesStoreNavigationCoordinator() : StoreNavigationEventListener = StoreNavigationCoordinator()

    @Provides
    @Singleton
    fun providesPaymentNavigationCoordinator() : PaymentNavigationEventListener = PaymentNavigationCoordinator()

}