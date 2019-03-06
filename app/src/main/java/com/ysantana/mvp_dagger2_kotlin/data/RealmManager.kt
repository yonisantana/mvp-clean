package com.ysantana.mvp_dagger2_kotlin.data

import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmObject
import io.realm.exceptions.RealmMigrationNeededException

class RealmManager {

    private val REALM_NAME = "myapp.realm"
    private var realmConfig: RealmConfiguration? = null
    private var realm: Realm? = null

    init {
        realmConfig.let {
            realmConfig = RealmConfiguration.Builder()
                .name(REALM_NAME)
                .build()
        }
    }

    private fun open() {
        realm = try {
            Realm.getInstance(realmConfig)
        } catch (e: RealmMigrationNeededException) {
            Realm.deleteRealm(realmConfig)
            Realm.getInstance(realmConfig)
        }
    }

    fun <T : RealmObject> saveFirst(tClass: T) {
        val newInts = Realm.getInstance(realmConfig)
        newInts.executeTransaction { realm ->
            realm.copyToRealmOrUpdate(tClass)
        }
    }

    fun <T : RealmObject> saveAll(tClass: List<T>) {
        val newInts = Realm.getInstance(realmConfig)
        newInts.executeTransaction { realm ->
            realm.copyToRealmOrUpdate(tClass)
        }
    }

    fun <T : RealmObject> findAll(tClass: Class<T>): List<T> {
        open()
        val result = realm?.where(tClass)?.findAll()
        val list = mutableListOf<T>()
        if (result != null) {
            list.addAll(realm?.copyFromRealm(result)!!)
        }
        close()
        return list
    }

    private fun close() {
        realm?.close()
    }
}