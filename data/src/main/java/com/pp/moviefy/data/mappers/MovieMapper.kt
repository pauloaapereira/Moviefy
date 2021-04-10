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
package com.pp.moviefy.data.mappers

import com.pp.moviefy.data.remote.common.model.NetworkMovie
import com.pp.moviefy.domain.model.Movie
import javax.inject.Inject

class MovieMapper @Inject constructor(
    private val accountRatingMapper: AccountRatingMapper,
    private val genreMapper: GenreMapper,
    private val productionCompanyMapper: ProductionCompanyMapper,
    private val productionCountryMapper: ProductionCountryMapper,
    private val spokenLanguageMapper: SpokenLanguageMapper
) : ApiMapper<NetworkMovie, Movie> {

    override fun mapToDomain(obj: NetworkMovie): Movie {
        return Movie(
            accountRating = accountRatingMapper.mapToDomain(obj.accountRating),
            adult = obj.adult ?: false,
            backdropPath = obj.backdropPath ?: "",
            belongsToCollection = obj.belongsToCollection,
            budget = obj.budget ?: 0,
            genres = obj.genres?.map { genreMapper.mapToDomain(it) } ?: listOf(),
            genreIds = obj.genreIds ?: listOf(),
            homepage = obj.homepage ?: "",
            id = obj.id ?: 0,
            imdbId = obj.imdbId ?: "",
            mediaType = obj.mediaType ?: "",
            originalLanguage = obj.originalLanguage ?: "",
            originalTitle = obj.originalTitle ?: "",
            overview = obj.overview ?: "",
            popularity = obj.popularity ?: 0.0,
            posterPath = obj.posterPath ?: "",
            productionCompanies = obj.productionCompanies?.map { productionCompanyMapper.mapToDomain(it) } ?: listOf(),
            productionCountries = obj.productionCountries?.map { productionCountryMapper.mapToDomain(it) } ?: listOf(),
            releaseDate = obj.releaseDate ?: "",
            revenue = obj.revenue ?: 0,
            runtime = obj.runtime ?: 0,
            spokenLanguages = obj.spokenLanguages?.map { spokenLanguageMapper.mapToDomain(it) } ?: listOf(),
            status = obj.status ?: "",
            tagline = obj.tagline ?: "",
            title = obj.title ?: "",
            video = obj.video ?: false,
            voteAverage = obj.voteAverage ?: 0.0,
            voteCount = obj.voteCount ?: 0
        )
    }
}
