package com.example.clase10.model

class CovidCaseEntityMapper : EntityMapper<CovidCaseEntity, CovidCaseModel> {

    override fun mapFromCached(type: CovidCaseEntity): CovidCaseModel {
        return CovidCaseModel(
            null,
            type.country,
            CountryInfo(type.flag),
            type.cases.toLong(),
            type.todayCases.toLong(),
            type.death.toLong(),
            type.todayDeaths.toLong(),
            type.recovered.toLong(),
            type.active.toLong()
        )
    }

    override fun mapToCached(type: CovidCaseModel): CovidCaseEntity {
        return CovidCaseEntity(
            type.country,
            type.countryInfo.flag,
            type.cases.toString(),
            type.deaths.toString(),
            type.todayCases.toString(),
            type.todayDeaths.toString(),
            type.recovered.toString(),
            type.active.toString()
        )
    }

}

