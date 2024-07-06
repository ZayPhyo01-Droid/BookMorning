package com.ui.bookmorning.exceptions

class ApiException(val code: Int, message: String): Exception(message)