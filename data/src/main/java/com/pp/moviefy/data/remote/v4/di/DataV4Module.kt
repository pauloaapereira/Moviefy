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
package com.pp.moviefy.data.remote.v4.di

import com.pp.moviefy.data.remote.v4.account.api.AccountDao
import com.pp.moviefy.data.remote.v4.auth.api.AuthDao
import com.pp.moviefy.data.remote.v4.lists.api.ListsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object DataV4Module {

    private const val RETROFIT_NAMED_INJECT = "v4Retrofit"

    @Provides
    fun provideAuthDao(@Named(RETROFIT_NAMED_INJECT) retrofit: Retrofit): AuthDao {
        return retrofit.create(AuthDao::class.java)
    }

    @Provides
    fun provideAccountDao(@Named(RETROFIT_NAMED_INJECT) retrofit: Retrofit): AccountDao {
        return retrofit.create(AccountDao::class.java)
    }

    @Provides
    fun provideListsDao(@Named(RETROFIT_NAMED_INJECT) retrofit: Retrofit): ListsDao {
        return retrofit.create(ListsDao::class.java)
    }
}
