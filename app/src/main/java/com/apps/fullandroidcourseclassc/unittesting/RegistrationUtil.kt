package com.apps.fullandroidcourseclassc.unittesting

object RegistrationUtil {
    /*
    Username and password is not empty
    username is already taken
    password and confirm password are the same
    password is complex , password must has at least 2 digits
     */
    private val alreadyTakenUser = listOf("Omar","Jad","Nouf","Hager")
    fun validateRegistrationInputs(
        username:String,
        password:String,
        confirmPassword:String
    ):Boolean{
        if (username.isEmpty() || password.isEmpty()){
            return false
        }
        if (password != confirmPassword){
            return false
        }
        if (username in alreadyTakenUser){
            return false
        }
        if (password.count{it.isDigit()} < 2){
            return true
        }


        return true
    }
}