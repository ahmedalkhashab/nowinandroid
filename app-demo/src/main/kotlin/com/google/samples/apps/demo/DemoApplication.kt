package com.google.samples.apps.demo

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import com.google.samples.apps.nowinandroid.sync.initializers.Sync
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

/**
 * [Application] class for NiA
 */
@HiltAndroidApp
class DemoApplication : Application(), ImageLoaderFactory {
    @Inject
    lateinit var imageLoader: dagger.Lazy<ImageLoader>

    override fun onCreate() {
        super.onCreate()
        // Initialize Sync; the system responsible for keeping data in the app up to date.
        Sync.initialize(context = this)
    }

    override fun newImageLoader(): ImageLoader = imageLoader.get()
}
