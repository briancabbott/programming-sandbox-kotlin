class Owner {

    fun foo() {
        bar()
        this.bar()
    }

    fun bar() {
        val n = Nested()
        n.baz()
    }

    class Nested {
        fun baz() {
            gau()
            this.gau()
        }

        fun gau() {
            val o = Owner()
            o.foo()
        }

        fun err() {
            <!UNRESOLVED_REFERENCE{LT}!><!UNRESOLVED_REFERENCE{PSI}!>foo<!>()<!>
            this.<!UNRESOLVED_REFERENCE{LT}!><!UNRESOLVED_REFERENCE{PSI}!>foo<!>()<!>
        }
    }
}

fun test() {
    val o = Owner()
    o.foo()
    val n = Owner.Nested()
    n.baz()
}