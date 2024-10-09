package com.simon.login.viewModel

import android.os.Message
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel: ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> =_authState

    init {
        checkAuthStatus()
    }

    fun checkAuthStatus(){
        if(auth.currentUser==null){
            _authState.value=AuthState.Unauthenticated
        }else{
            _authState.value=AuthState.Authenticated
        }
    }
    fun login(userName: String,password:String){

        if (userName.isEmpty() || password.isEmpty()){
            _authState.value=AuthState.Error("Email/password can't be empty")
            return
        }

        _authState.value=AuthState.Loading
        auth.signInWithEmailAndPassword(userName,password)
            .addOnCompleteListener {task->
                if (task.isSuccessful){
                    _authState.value=AuthState.Authenticated
                }else{
                    _authState.value=AuthState.Error(task.exception?.message?:"something went wrong")
                }
            }
    }

    fun signup(userName: String,password:String){

        if (userName.isEmpty() || password.isEmpty()){
            _authState.value=AuthState.Error("Email/password can't be empty")
            return
        }

        _authState.value=AuthState.Loading
        auth.createUserWithEmailAndPassword(userName,password)
            .addOnCompleteListener {task->
                if (task.isSuccessful){
                    _authState.value=AuthState.Authenticated
                }else{
                    _authState.value=AuthState.Error(task.exception?.message?:"something went wrong")
                }
            }
    }
    fun signout(){
        auth.signOut()
        _authState.value=AuthState.Unauthenticated
    }

}


sealed class AuthState{
    object Authenticated : AuthState()
    object Unauthenticated : AuthState()
    object Loading : AuthState()
    data class Error(val message: String): AuthState()

}