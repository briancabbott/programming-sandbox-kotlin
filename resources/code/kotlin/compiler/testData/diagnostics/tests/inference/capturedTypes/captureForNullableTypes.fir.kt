// !WITH_NEW_INFERENCE
// !DIAGNOSTICS: -UNUSED_VARIABLE -UNUSED_PARAMETER
// !CHECK_TYPE

fun <T: Any> bar(a: Array<T>): Array<T?> =  null!!

fun test1(a: Array<out Int>) {
    val r: Array<out Int?> = bar(a)
    val t = bar(a)
    t checkType { <!INAPPLICABLE_CANDIDATE!>_<!><Array<out Int?>>() }
}

fun <T: Any> foo(l: Array<T>): Array<Array<T?>> = null!!

fun test2(a: Array<out Int>) {
    val r: Array<out Array<out Int?>> = foo(a)
    val t = foo(a)
    t checkType { <!INAPPLICABLE_CANDIDATE!>_<!><Array<out Array<out Int?>>>() }
}