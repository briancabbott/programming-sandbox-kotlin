fun goo() {
    var a = 2
    val b = 4
    <!CAN_BE_REPLACED_WITH_OPERATOR_ASSIGNMENT{LT}!>a <!CAN_BE_REPLACED_WITH_OPERATOR_ASSIGNMENT{PSI}!>=<!> a + 1 + b<!>
    <!CAN_BE_REPLACED_WITH_OPERATOR_ASSIGNMENT{LT}!>a <!CAN_BE_REPLACED_WITH_OPERATOR_ASSIGNMENT{PSI}!>=<!> (a + 1)<!>
    <!ASSIGNED_VALUE_IS_NEVER_READ!>a<!> = a * b + 1
}