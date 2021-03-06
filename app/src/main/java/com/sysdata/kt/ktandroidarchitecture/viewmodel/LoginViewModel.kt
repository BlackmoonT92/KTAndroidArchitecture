package com.sysdata.kt.ktandroidarchitecture.viewmodel

import androidx.lifecycle.viewModelScope
import com.sysdata.kt.ktandroidarchitecture.repository.model.UIUserLogged
import com.sysdata.kt.ktandroidarchitecture.repository.model.UserLogged
import com.sysdata.kt.ktandroidarchitecture.usecase.LoginActionParams
import com.sysdata.kt.ktandroidarchitecture.usecase.LoginUseCase
import it.sysdata.ktandroidarchitecturecore.interactor.Action
import it.sysdata.ktandroidarchitecturecore.platform.BaseViewModel

class LoginViewModel(loginUseCase: LoginUseCase) : BaseViewModel() {




     val actionLogin = Action.Builder<LoginActionParams, UserLogged, UIUserLogged>()
            .useCase(loginUseCase)
            .buildWithUiModel { UIUserLogged(it.username) }


    fun login(username: String, password: String) {
        actionLogin.execute(LoginActionParams(username, password), viewModelScope)

    }


}