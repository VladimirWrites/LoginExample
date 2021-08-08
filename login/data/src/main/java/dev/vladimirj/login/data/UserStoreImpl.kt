package dev.vladimirj.login.data

import com.google.firebase.auth.FirebaseAuth
import dev.vladimirj.login.domain.entity.LoginResult
import dev.vladimirj.login.domain.store.UserStore
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class UserStoreImpl(private val auth: FirebaseAuth): UserStore {
    override suspend fun login(email: String, password: String): LoginResult {
        return suspendCancellableCoroutine  { cont ->
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    cont.resume(LoginResult.Successful(auth.currentUser!!.uid, auth.currentUser!!.email!!))
                } else {
                    cont.resume(LoginResult.Error(task.exception!!.message!!))
                }
            }
        }
    }
}