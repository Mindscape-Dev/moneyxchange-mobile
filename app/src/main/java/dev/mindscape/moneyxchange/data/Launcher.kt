package dev.mindscape.moneyxchange.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

val Context.ds : DataStore<Preferences> by preferencesDataStore("Launch")

class Launcher (private var context : Context){
    companion object{
        val launchKey = booleanPreferencesKey("launch")
    }

    suspend fun isFirstLaunch(launchState : Boolean){
        context.ds.edit {
            it[launchKey] = launchState
        }
    }

    suspend fun checkFirstLaunch() : Boolean{
        val launchState = context.ds.data.first()
        return launchState[launchKey] ?: true
    }

}