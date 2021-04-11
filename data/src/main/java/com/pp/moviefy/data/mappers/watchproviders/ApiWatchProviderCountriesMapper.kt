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
package com.pp.moviefy.data.mappers.watchproviders

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.common.model.ApiWatchProviderCountries
import com.pp.moviefy.domain.model.WatchProviderCountries
import javax.inject.Inject

class ApiWatchProviderCountriesMapper @Inject constructor(
    private val apiCountryWatchProvidersMapper: ApiCountryWatchProvidersMapper
) : ApiMapper<ApiWatchProviderCountries?, WatchProviderCountries> {
    override fun mapToDomain(obj: ApiWatchProviderCountries?): WatchProviderCountries {
        return WatchProviderCountries(
            aR = apiCountryWatchProvidersMapper.mapToDomain(obj?.aR),
            aT = apiCountryWatchProvidersMapper.mapToDomain(obj?.aT),
            aU = apiCountryWatchProvidersMapper.mapToDomain(obj?.aU),
            bE = apiCountryWatchProvidersMapper.mapToDomain(obj?.bE),
            bR = apiCountryWatchProvidersMapper.mapToDomain(obj?.bR),
            cA = apiCountryWatchProvidersMapper.mapToDomain(obj?.cA),
            cH = apiCountryWatchProvidersMapper.mapToDomain(obj?.cH),
            cL = apiCountryWatchProvidersMapper.mapToDomain(obj?.cL),
            cO = apiCountryWatchProvidersMapper.mapToDomain(obj?.cO),
            cZ = apiCountryWatchProvidersMapper.mapToDomain(obj?.cZ),
            dE = apiCountryWatchProvidersMapper.mapToDomain(obj?.dE),
            dK = apiCountryWatchProvidersMapper.mapToDomain(obj?.dK),
            eC = apiCountryWatchProvidersMapper.mapToDomain(obj?.eC),
            eE = apiCountryWatchProvidersMapper.mapToDomain(obj?.eE),
            eS = apiCountryWatchProvidersMapper.mapToDomain(obj?.eS),
            fI = apiCountryWatchProvidersMapper.mapToDomain(obj?.fI),
            fR = apiCountryWatchProvidersMapper.mapToDomain(obj?.fR),
            gB = apiCountryWatchProvidersMapper.mapToDomain(obj?.gB),
            gR = apiCountryWatchProvidersMapper.mapToDomain(obj?.gR),
            hU = apiCountryWatchProvidersMapper.mapToDomain(obj?.hU),
            iD = apiCountryWatchProvidersMapper.mapToDomain(obj?.iD),
            iE = apiCountryWatchProvidersMapper.mapToDomain(obj?.iE),
            iN = apiCountryWatchProvidersMapper.mapToDomain(obj?.iN),
            iT = apiCountryWatchProvidersMapper.mapToDomain(obj?.iT),
            jP = apiCountryWatchProvidersMapper.mapToDomain(obj?.jP),
            kR = apiCountryWatchProvidersMapper.mapToDomain(obj?.kR),
            lT = apiCountryWatchProvidersMapper.mapToDomain(obj?.lT),
            lV = apiCountryWatchProvidersMapper.mapToDomain(obj?.lV),
            mX = apiCountryWatchProvidersMapper.mapToDomain(obj?.mX),
            mY = apiCountryWatchProvidersMapper.mapToDomain(obj?.mY),
            nL = apiCountryWatchProvidersMapper.mapToDomain(obj?.nL),
            nO = apiCountryWatchProvidersMapper.mapToDomain(obj?.nO),
            nZ = apiCountryWatchProvidersMapper.mapToDomain(obj?.nZ),
            pE = apiCountryWatchProvidersMapper.mapToDomain(obj?.pE),
            pH = apiCountryWatchProvidersMapper.mapToDomain(obj?.pH),
            pL = apiCountryWatchProvidersMapper.mapToDomain(obj?.pL),
            pT = apiCountryWatchProvidersMapper.mapToDomain(obj?.pT),
            rO = apiCountryWatchProvidersMapper.mapToDomain(obj?.rO),
            rU = apiCountryWatchProvidersMapper.mapToDomain(obj?.rU),
            sE = apiCountryWatchProvidersMapper.mapToDomain(obj?.sE),
            sG = apiCountryWatchProvidersMapper.mapToDomain(obj?.sG),
            tH = apiCountryWatchProvidersMapper.mapToDomain(obj?.tH),
            tR = apiCountryWatchProvidersMapper.mapToDomain(obj?.tR),
            uS = apiCountryWatchProvidersMapper.mapToDomain(obj?.uS),
            vE = apiCountryWatchProvidersMapper.mapToDomain(obj?.vE),
            zA = apiCountryWatchProvidersMapper.mapToDomain(obj?.zA)
        )
    }
}
