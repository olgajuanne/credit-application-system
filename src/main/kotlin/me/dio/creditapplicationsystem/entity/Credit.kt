
import Status

import java.util.UUID
import java.math.BigDecimal
import java.time.LocalDate
import jakarta.persistence.*

@Entity
@Table(name = "Credito")
data class Credit(
  @Column(nullable = false, unique = true) val creditCode: UUID = UUID.randomUUID(),
  @Column(nullable = false) val creditValue: BigDecimal = BigDecimal.ZERO,
  @Column(nullable = false) val dayFirstInstallments: LocalDate,
  @Column(nullable = false) val numberOfInstallments: Int = 0,
  @Enumerated val status: Status = Status.IN_PROGRESS,
  @ManyToOne var costomer: Customer? = null,
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)