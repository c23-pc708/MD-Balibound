package com.bangkit.capstone.balibound.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.bangkit.capstone.balibound.data.api.ApiAuthInterface
import com.bangkit.capstone.balibound.data.model.request.LoginRequest
import com.bangkit.capstone.balibound.data.model.request.RegisterRequest
import com.bangkit.capstone.balibound.data.model.response.LoginResponse
import com.bangkit.capstone.balibound.data.model.response.RegisterResponse
import javax.inject.Inject
import com.bangkit.capstone.balibound.utils.Result
import com.google.gson.Gson
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class AuthRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>,
    private val apiService: ApiAuthInterface
) {
    private val userData = stringPreferencesKey("UserData_Key")

    suspend fun login(
        email: String,
        password: String
    ): Result<LoginResponse> {
        return try {
            Result.Success(apiService.login(LoginRequest(email, password)))
        } catch (e: Exception) {
            Result.Error(e.message.toString())
        }
    }

    suspend fun register(
        registerBody: RegisterRequest,
    ): Result<RegisterResponse> {
        return try {
            Result.Success(apiService.register(registerBody))
        } catch (e: Exception) {
            Result.Error(e.message.toString())
        }
    }

    suspend fun getUserData(): LoginResponse? {
        return dataStore.data.map {
            Gson().fromJson(it[userData], LoginResponse::class.java)
        }.first()
    }

    suspend fun saveUserData(user: LoginResponse) {
        dataStore.edit {
            it[userData] = Gson().toJson(user)
        }
    }

    suspend fun clearUserData() {
        dataStore.edit {
            it[userData] = ""
        }
    }

}