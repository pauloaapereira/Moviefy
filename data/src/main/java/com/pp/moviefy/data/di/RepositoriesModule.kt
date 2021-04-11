package com.pp.moviefy.data.di

import com.pp.moviefy.data.repositories.AuthRepository
import com.pp.moviefy.data.repositories.MoviesRepository
import com.pp.moviefy.domain.repositories.IAuthRepository
import com.pp.moviefy.domain.repositories.IMoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun bindAuthRepository(
        authRepository: AuthRepository
    ): IAuthRepository

    @Binds
    fun bindMoviesRepository(
        moviesRepository: MoviesRepository
    ): IMoviesRepository
}