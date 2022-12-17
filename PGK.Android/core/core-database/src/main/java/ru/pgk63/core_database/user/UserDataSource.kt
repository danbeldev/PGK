package ru.pgk63.core_database.user

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.pgk63.core_common.extension.decodeFromString
import ru.pgk63.core_common.extension.encodeToString
import ru.pgk63.core_database.user.model.UserLocalDatabase
import javax.inject.Inject

class UserDataSource @Inject constructor(
   @ApplicationContext private val context: Context
) {
    private val userSharedPreferences = context.getSharedPreferences(
        userSharedPreferencesKey,Context.MODE_PRIVATE)
    
    fun saveAccessToken(accessToken: String?){
        userSharedPreferences.edit()
            .putString(accessTokenKey,accessToken)
            .apply()
    }
    
    fun getAccessToken(): String? {
        return userSharedPreferences.getString(accessTokenKey,null)
    }

    fun saveRefreshToken(accessToken: String?){
        userSharedPreferences.edit()
            .putString(refreshTokenKey,accessToken)
            .apply()
    }

    fun getRefreshToken(): String? {
        return userSharedPreferences.getString(refreshTokenKey,null)
    }

    suspend fun save(user: UserLocalDatabase){
        context.userDataStore.edit { preferences ->
            preferences[USER_DATA_STORE] = user.encodeToString()
        }
    }

    fun get(): Flow<UserLocalDatabase> {
        return context.userDataStore.data
            .map { preferences ->
                preferences[USER_DATA_STORE]?.decodeFromString() ?: UserLocalDatabase()
            }
    }

    companion object{
        private val Context.userDataStore by preferencesDataStore(name = "user_data_store")
        private val USER_DATA_STORE = stringPreferencesKey("user_key")
        
        private const val userSharedPreferencesKey = "user_key"
        private const val accessTokenKey = "accessToken"
        private const val refreshTokenKey = "refreshToken"
    }

}