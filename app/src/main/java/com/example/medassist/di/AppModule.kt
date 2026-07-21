// AppModule.kt
package com.example.medassist.di

import android.content.Context
import com.example.medassist.data.DosezyDatabase
import com.example.medassist.data.repository.MedicineRepository
import com.example.medassist.data.repository.ScheduleRepository
import com.example.medassist.data.repository.UserRepository
import com.example.medassist.notifications.MedicineNotificationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): DosezyDatabase {
        return DosezyDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideUserRepository(database: DosezyDatabase): UserRepository {
        return UserRepository(database)
    }

    @Provides
    @Singleton
    fun provideMedicineRepository(
        database: DosezyDatabase,
        scheduleRepository: ScheduleRepository
    ): MedicineRepository {
        return MedicineRepository(database, scheduleRepository)
    }

    @Provides
    @Singleton
    fun provideScheduleRepository(database: DosezyDatabase): ScheduleRepository {
        return ScheduleRepository(database)
    }

    @Provides
    @Singleton
    fun provideMedicineNotificationManager(
        @ApplicationContext context: Context,
        database: DosezyDatabase
    ): MedicineNotificationManager {
        return MedicineNotificationManager(context, database)
    }
}