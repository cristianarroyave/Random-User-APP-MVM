package com.example.mvvmaristi.data.firebase

import com.example.mvvmaristi.data.model.fullUserInfo.FullUserInfo
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Firebase @Inject constructor(
    private val db:FirebaseFirestore
){
    fun insertData(user: FullUserInfo){
        db.collection("users").document(user.name).set(hashMapOf(
            "image" to user.image,
            "email" to user.email,
            "street" to user.street,
            "city" to user.city,
            "country" to user.country,
            "age" to user.age
        ))
    }

    suspend fun getUserData(name: String): FullUserInfo {
        val result = db.collection("users").document(name).get().await()
        return FullUserInfo(name, result.get("image").toString(), result.get("email").toString(), result.get("street").toString(), result.get("city").toString(), result.get("country").toString(), result.get("age").toString().toInt())
    }


}