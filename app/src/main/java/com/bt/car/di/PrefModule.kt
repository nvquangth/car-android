package com.bt.car.di

import android.content.Context
import android.content.SharedPreferences
import com.bt.car.data.pref.PrefHelper
import com.bt.car.data.pref.PrefHelperImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object PrefModule {

    @Provides
    @Singleton
    fun providePrefHelper(prefHelperImpl: PrefHelperImpl): PrefHelper {
        return prefHelperImpl
    }

    @Provides
    @Singleton
    fun provideAppPref(sharedPreferences: SharedPreferences, gson: Gson): PrefHelperImpl {
        return PrefHelperImpl(sharedPreferences, gson)
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }
}
