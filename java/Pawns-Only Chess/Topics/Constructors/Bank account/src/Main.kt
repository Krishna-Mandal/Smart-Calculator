data class BankAccount(val deposited: Long, val withdrawn: Long) {
    var balance = deposited - withdrawn
}