package com.apps.fullandroidcourseclassc.unittesting

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun `check username or password is not empty`() {
       val result =  RegistrationUtil.validateRegistrationInputs(
            "",
            "123",
            "123"
        )
       assertThat(result).isFalse() // check if result is returning false
    }

    @Test
    fun `check password and confirm password are not the same`(){
        val result = RegistrationUtil.validateRegistrationInputs(
            "Eslam",
            "123",
            "gsdfs"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `username is already taken`(){
        val result = RegistrationUtil.validateRegistrationInputs(
            "Nouf",
            "1234",
            "1234"
        )
        assertThat(result).isFalse()
    }
    
    @Test
    fun `check password has at least 2 digits`(){
        val result = RegistrationUtil.validateRegistrationInputs(
            "Eslam",
            "Eslam12",
            "Eslam12"
        )
        assertThat(result).isTrue()
    }

}