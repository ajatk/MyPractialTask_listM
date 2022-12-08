package com.example.mypractialtask2.view


import androidx.test.ext.junit.runners.AndroidJUnit4

import com.google.common.truth.Truth.assertThat


import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ValidatorUnitTest{

    @Test
    fun whenInputIsValidate() {
        val amount=100
        val des = "My input test on validator"
        val result = ValidatorUnit.validateInput(amount,des)
        assertThat(result).isEqualTo(true)

    }
}