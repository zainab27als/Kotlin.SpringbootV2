package `ordering-service`.orders

import com.coded.spring.ordering.UserEntity
import jakarta.persistence.*

@Entity
@Table(name = "orders")
data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "name_id")
    val user: UserEntity,

    val restaurant: String,

    @Column(columnDefinition = "TEXT")
    val items: String = ""
)

    {
    constructor() : this(null, UserEntity(), "", "")
}


