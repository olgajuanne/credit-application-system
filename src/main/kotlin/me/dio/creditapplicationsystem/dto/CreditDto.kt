
import Customer
import java.math.BigDecimal
import java.time.LocalDate
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.Max

class CreditDto (
  @field:NotEmpty(message = "Invalid input") val creditValue: BigDecimal,
  @field:Future val dayFirstOfInstallment: LocalDate,
  @field:Min(value = 1) @field:Max(value = 48) val numberOfInstallments: Int,
  @field:NotEmpty(message = "Invalid input") val customerId: Long
) {

  fun toEntity(): Credit = Credit(
    creditValue = this.creditValue,
    dayFirstOfInstallment = this.dayFirstOfInstallment,
    numberOfInstallments = this.numberOfInstallments,
    customer = Customer(id = this.customerId)
  )
}
  
