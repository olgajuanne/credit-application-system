
import me.dio.credit.application.system.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository): ICustomerService {

    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)
     
    override fun findById(id: Long): Customer = 
        this.customerRepository.findById(id).orElseThrow(){
            throw RuntimeException("Id $id not found")
        }

    override fun delete(id: Long) {
        val customer: Customer = this.findById(id)
        this.customerRepository.delete(customer)
    }
    
  
}