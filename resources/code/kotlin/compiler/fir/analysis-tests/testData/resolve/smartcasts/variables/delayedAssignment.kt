// !DUMP_CFG
class A {
    fun foo() {}
}

fun test(b: Boolean) {
    val a: A?
    if (b) {
        a = A()
        a.foo()
    } else {
        a = null
    }
    a.<!INAPPLICABLE_CANDIDATE{LT}!><!INAPPLICABLE_CANDIDATE{PSI}!>foo<!>()<!>
}