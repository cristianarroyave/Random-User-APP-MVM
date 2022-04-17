package com.example.mvvmaristi.domain

import com.example.mvvmaristi.data.FullUserInfoRepository
import com.example.mvvmaristi.data.model.fullUserInfo.FullUserInfo
import javax.inject.Inject

class FullUserInfoUseCase @Inject constructor(
    private val fullUserInfoRepository: FullUserInfoRepository,
) {
    suspend operator fun invoke(name: String): FullUserInfo? = fullUserInfoRepository.getUserInfo(name)
}