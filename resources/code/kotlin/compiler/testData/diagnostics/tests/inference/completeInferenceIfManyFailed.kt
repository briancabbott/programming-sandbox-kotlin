// !WITH_NEW_INFERENCE
// !CHECK_TYPE

package d

import checkSubtype

fun <T: Any> joinT(<!UNUSED_PARAMETER!>x<!>: Int, vararg <!UNUSED_PARAMETER!>a<!>: T): T? {
    return null
}

fun <T: Any> joinT(<!UNUSED_PARAMETER!>x<!>: Comparable<*>, <!UNUSED_PARAMETER!>y<!>: T): T? {
    return null
}

fun test() {
    val x2 = <!TYPE_INFERENCE_PARAMETER_CONSTRAINT_ERROR{OI}!>joinT<!>(<!TYPE_MISMATCH!>Unit<!>, "2")
    checkSubtype<String?>(x2)
}