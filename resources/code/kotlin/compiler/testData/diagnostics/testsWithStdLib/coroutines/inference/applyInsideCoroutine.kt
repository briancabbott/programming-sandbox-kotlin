// !DIAGNOSTICS: -UNUSED_EXPRESSION -UNUSED_PARAMETER -UNUSED_ANONYMOUS_PARAMETER -UNUSED_VARIABLE
// !WITH_NEW_INFERENCE
// !WITH_NEW_INFERENCE
// NI_EXPECTED_FILE

class Controller<T> {
    suspend fun yield(t: T) {}
}

fun <S> generate(g: suspend Controller<S>.() -> Unit): S = TODO()

val test1 = <!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER{NI}, TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER{OI}!>generate<!> {
    <!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER, NI;NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER{OI}!>apply<!> {
        <!DEBUG_INFO_MISSING_UNRESOLVED, NI;DEBUG_INFO_MISSING_UNRESOLVED{OI}!>yield<!>(4)
    }
}

val test2 = <!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER{NI}, TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER{OI}!>generate<!> {
    yield(B)
    <!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER, NI;NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER{OI}!>apply<!> {
        <!DEBUG_INFO_MISSING_UNRESOLVED, NI;DEBUG_INFO_MISSING_UNRESOLVED{OI}!>yield<!>(<!DEBUG_INFO_MISSING_UNRESOLVED, NI;DEBUG_INFO_MISSING_UNRESOLVED{OI}!>C<!>)
    }
}

val test3 = <!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER, NI;NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER{OI}, OI;TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER{OI}!>generate<!> {
    this.<!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER, OI;TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER{OI}!>let<!> {
        yield(B)
    }

    <!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER, NI;NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER{OI}!>apply<!> {
        <!DEBUG_INFO_MISSING_UNRESOLVED, NI;DEBUG_INFO_MISSING_UNRESOLVED{OI}!>yield<!>(<!DEBUG_INFO_MISSING_UNRESOLVED, NI;DEBUG_INFO_MISSING_UNRESOLVED{OI}!>C<!>)
    }
}

interface A
object B : A
object C : A