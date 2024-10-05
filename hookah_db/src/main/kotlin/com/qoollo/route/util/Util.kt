package com.qoollo.route.util

import java.util.UUID

fun String.toUUID(): UUID = UUID.fromString(this)


