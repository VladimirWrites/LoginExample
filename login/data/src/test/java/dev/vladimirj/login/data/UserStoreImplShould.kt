package dev.vladimirj.login.data

import com.google.firebase.auth.FirebaseAuth
import com.nhaarman.mockitokotlin2.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope

import org.junit.Test

class UserStoreImplShould {

    private val job = Job()
    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(job + testDispatcher)

    private val firebaseAuthMock = mock<FirebaseAuth>()
    private val userStoreImpl = UserStoreImpl(firebaseAuthMock)

    @Test
    fun passDataToFirebaseAuth() {
        testScope.launch {
            userStoreImpl.login("test@email.com", "test123")
            job.cancel()
        }
        verify(firebaseAuthMock).signInWithEmailAndPassword("test@email.com", "test123")
    }
}