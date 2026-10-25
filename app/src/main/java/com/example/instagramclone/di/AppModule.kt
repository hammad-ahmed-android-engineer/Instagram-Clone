package com.example.instagramclone.di

import com.example.instagramclone.data.repository.DummyFeedRepository
import com.example.instagramclone.data.repository.FeedRepository
import dagger.Binds
import dagger.hilt.components.SingletonComponent
import dagger.hilt.InstallIn
import dagger.Module
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindFeedRepository(
        dummyFeedRepository: DummyFeedRepository
    ): FeedRepository
}
