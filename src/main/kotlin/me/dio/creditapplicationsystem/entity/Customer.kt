

import Address
import Credit
import jakarta.persistence.*
import kotlin.arrayOf

@Entity
@Table(name = "Cliente")
data class Customer(
  @Column(nullable = false) var firstName: String = "",
  @Column(nullable = false) var lastName: String = "",
  @Column(nullable = false, unique = true) val cpf: String = "",
  @Column(nullable = false, unique = true) var email: String = "",
  @Column(nullable = false) var password: String = "",
  @Column(nullable = false) @Embedded var address: Address = Address(),
  @Column(nullable = false) @OneToMany(fetch = FetchType.LAZY, 
  cascade = arrayOf(CascadeType.REMOVE, CascadeType.PERSIST), mappedBy = "customer") var credts: List<Credit> = mutableListOf(),
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)