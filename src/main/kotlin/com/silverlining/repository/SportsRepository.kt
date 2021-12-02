package com.silverlining.repository

import com.silverlining.entities.SportsDataClass

interface SportsRepository {

    fun initSportsData(): SportsDataClass
}