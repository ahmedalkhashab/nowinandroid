package com.google.samples.apps.demo.di

import com.google.samples.apps.demo.coordinator.StoreNavigationCoordinator
import com.google.samples.apps.demo.coordinator.WelcomeNavigationCoordinator
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
    fun providesStoreNavigationCoordinator() : StoreNavigationEventListener = StoreNavigationCoordinator()

    @Provides
    @Singleton
    fun providesWelcomeNavigationCoordinator() : WelcomeNavigationEventListener = WelcomeNavigationCoordinator()

}
