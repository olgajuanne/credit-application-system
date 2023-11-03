

import org.hibernate.validator.constraints.UUID

interface ICreditService {
 
    fun save(credit: Credit): Credit
    fun findAllByCustomer(customerId: Long): List<Credit>
    fun findByCreditCode(creditCode: UUID): Credit
}