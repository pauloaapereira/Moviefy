package com.pp.moviefy.domain.model

data class WatchProviders(
    val id: Int,
    val countries: WatchProviderCountries,
    val success: Boolean
)

data class WatchProviderCountries(
    val aR: CountryWatchProviders,
    val aT: CountryWatchProviders,
    val aU: CountryWatchProviders,
    val bE: CountryWatchProviders,
    val bR: CountryWatchProviders,
    val cA: CountryWatchProviders,
    val cH: CountryWatchProviders,
    val cL: CountryWatchProviders,
    val cO: CountryWatchProviders,
    val cZ: CountryWatchProviders,
    val dE: CountryWatchProviders,
    val dK: CountryWatchProviders,
    val eC: CountryWatchProviders,
    val eE: CountryWatchProviders,
    val eS: CountryWatchProviders,
    val fI: CountryWatchProviders,
    val fR: CountryWatchProviders,
    val gB: CountryWatchProviders,
    val gR: CountryWatchProviders,
    val hU: CountryWatchProviders,
    val iD: CountryWatchProviders,
    val iE: CountryWatchProviders,
    val iN: CountryWatchProviders,
    val iT: CountryWatchProviders,
    val jP: CountryWatchProviders,
    val kR: CountryWatchProviders,
    val lT: CountryWatchProviders,
    val lV: CountryWatchProviders,
    val mX: CountryWatchProviders,
    val mY: CountryWatchProviders,
    val nL: CountryWatchProviders,
    val nO: CountryWatchProviders,
    val nZ: CountryWatchProviders,
    val pE: CountryWatchProviders,
    val pH: CountryWatchProviders,
    val pL: CountryWatchProviders,
    val pT: CountryWatchProviders,
    val rO: CountryWatchProviders,
    val rU: CountryWatchProviders,
    val sE: CountryWatchProviders,
    val sG: CountryWatchProviders,
    val tH: CountryWatchProviders,
    val tR: CountryWatchProviders,
    val uS: CountryWatchProviders,
    val vE: CountryWatchProviders,
    val zA: CountryWatchProviders
)

data class CountryWatchProviders(
    val buy: List<WatchProvider>,
    val flatRate: List<WatchProvider>,
    val link: String,
    val rent: List<WatchProvider>
)

data class WatchProvider(
    val displayPriority: Int,
    val logoPath: String,
    val providerId: Int,
    val providerName: String
)
