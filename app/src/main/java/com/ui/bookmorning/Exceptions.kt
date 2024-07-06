//package com.ui.bookmorning
//
//import java.lang.ClassCastException
//import java.lang.IllegalArgumentException
//import java.lang.NullPointerException
//
//fun printLength(userName: String? = null) {
//    println(userName!!.length)
//}
//
//fun classCastExpt() {
//    val obj: Any = "1"
//    val num: Int = obj as Int
//    println(num)
//}
//
//fun validateAge(age: Int) {
//    if (age < 0) {
//        // throw Ex
//        throw IllegalArgumentException("Age cannot be zero")
//    }
//}
//
//class ApiException(val code: Int, message: String): Exception(message)
//
//fun callApi() {
//    val apiResponseCode = 500// Ktor
//    if (apiResponseCode != 200) {
//        throw ApiException(
//            code = apiResponseCode,
//            message = "Something went wrong"
//        )
//    }
//}
//fun main() {
//    try {
//        printLength(userName = "Test")
//        validateAge(age = 10)
//        callApi()
//    } catch (nullPointerException: NullPointerException) {
//        println("NPE ${nullPointerException.message}")
//    } catch (classCastEx: ClassCastException) {
//        println("CE ${classCastEx.message}")
//    } catch (illegalArgEx: IllegalArgumentException) {
//        println("ILE ${illegalArgEx.message}")
//    } catch (apiException: ApiException) {
//        println("Code = ${apiException.code}, Message = ${apiException.message}")
//    } catch (e: Exception) {
//        println(e)
//    }
//    finally {
//        println("finally")
//    }
//}