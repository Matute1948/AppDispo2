package com.lugmana_andres.appdispo2.data.local.firabase

import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import com.lugmana_andres.appdispo2.ui.entity.users.UserLogin
import kotlinx.coroutines.tasks.await

class FirestoreRepository {

    private var db: FirebaseFirestore = Firebase.firestore

    suspend fun saveUserLogin(user: UserLogin) = runCatching {
        val id = db.collection("users")
            .add(user)
            .await()
        return@runCatching true
    }

    suspend fun getUserById(id: String) = runCatching {
        var items = arrayListOf<UserLogin>()
        db.collection("users")
            .whereEqualTo("uuid", id)
            .get()
            .await()
            .forEach {
                items.add(it.toObject<UserLogin>())
            }
        return@runCatching items
    }

}