// !DIAGNOSTICS: -UNUSED_EXPRESSION, -UNUSED_PARAMETER
// !WITH_NEW_INFERENCE

class A

fun test1() {
    val <!UNUSED_VARIABLE!>foo<!> = ::<!UNRESOLVED_REFERENCE!>foo<!>

    ::<!UNRESOLVED_REFERENCE!>bar<!>

    A::<!UNRESOLVED_REFERENCE!>bar<!>

    <!UNRESOLVED_REFERENCE!>B<!>::<!DEBUG_INFO_MISSING_UNRESOLVED!>bar<!>
}

fun test2() {
    fun foo(x: Any) {}
    fun foo() {}

    <!UNRESOLVED_REFERENCE!>Unresolved<!>::<!DEBUG_INFO_MISSING_UNRESOLVED!>foo<!>
    foo(<!UNRESOLVED_REFERENCE!>Unresolved<!>::<!CALLABLE_REFERENCE_RESOLUTION_AMBIGUITY{NI}, DEBUG_INFO_MISSING_UNRESOLVED{OI}!>foo<!>)
    foo(<!UNRESOLVED_REFERENCE!>Unresolved<!>::<!DEBUG_INFO_MISSING_UNRESOLVED{OI}, UNRESOLVED_REFERENCE{NI}!>unresolved<!>)
    ::<!UNRESOLVED_REFERENCE!>unresolved<!>
}