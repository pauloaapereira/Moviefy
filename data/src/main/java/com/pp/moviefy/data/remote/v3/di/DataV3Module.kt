/*
 * Copyright 2021 Paulo Pereira
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pp.moviefy.data.remote.v3.di

import com.pp.moviefy.data.remote.v3.certifications.api.CertificationsDao
import com.pp.moviefy.data.remote.v3.collections.api.CollectionsDao
import com.pp.moviefy.data.remote.v3.movies.api.MoviesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object DataV3Module {

    private const val RETROFIT_NAMED_INJECT = "v3Retrofit"

    @Provides
    fun provideCertificationsDao(@Named(RETROFIT_NAMED_INJECT) retrofit: Retrofit): CertificationsDao {
        return retrofit.create(CertificationsDao::class.java)
    }

    @Provides
    fun provideCollectionsDao(@Named(RETROFIT_NAMED_INJECT) retrofit: Retrofit): CollectionsDao {
        return retrofit.create(CollectionsDao::class.java)
    }

    @Provides
    fun provideMoviesDao(@Named(RETROFIT_NAMED_INJECT) retrofit: Retrofit): MoviesDao {
        return retrofit.create(MoviesDao::class.java)
    }
}
