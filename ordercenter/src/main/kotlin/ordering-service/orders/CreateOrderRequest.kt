package `ordering-service`.orders

data class CreateOrderRequest(
    val userId: Long,
    val restaurant: String,
    val items: List<ItemRequest>
)

data class ItemRequest(
    val name: String,
    val quantity: Int
)
