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

import com.pp.moviefy.data.remote.di.V3Api
import com.pp.moviefy.data.remote.v3.certifications.api.CertificationsDao
import com.pp.moviefy.data.remote.v3.collections.api.CollectionsDao
import com.pp.moviefy.data.remote.v3.movies.api.MoviesDao
import com.pp.moviefy.data.remote.v3.persons.api.PersonsDao
import com.pp.moviefy.data.remote.v3.tv.api.TvDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object DataV3Module {

    @Provides
    fun provideCertificationsDao(@V3Api retrofit: Retrofit): CertificationsDao {
        return retrofit.create(CertificationsDao::class.java)
    }

    @Provides
    fun provideCollectionsDao(@V3Api retrofit: Retrofit): CollectionsDao {
        return retrofit.create(CollectionsDao::class.java)
    }

    @Provides
    fun provideMoviesDao(@V3Api retrofit: Retrofit): MoviesDao {
        return retrofit.create(MoviesDao::class.java)
    }

    @Provides
    fun provideTvDao(@V3Api retrofit: Retrofit): TvDao {
        return retrofit.create(TvDao::class.java)
    }

    @Provides
    fun providePersonsDao(@V3Api retrofit: Retrofit): PersonsDao {
        return retrofit.create(PersonsDao::class.java)
    }
}
