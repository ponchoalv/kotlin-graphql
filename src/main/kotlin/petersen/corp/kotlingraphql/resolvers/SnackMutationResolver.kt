package petersen.corp.kotlingraphql.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component
import petersen.corp.kotlingraphql.entity.Snack
import petersen.corp.kotlingraphql.repository.SnackRepository
import java.util.*

@Component
class SnackMutationResolver(
        private val snackRepository: SnackRepository) : GraphQLMutationResolver {

    fun newSnack(name: String, amount: Float): Snack {
        val snack = Snack(name, amount)
        snack.id = UUID.randomUUID().toString()
        snackRepository.save(snack)
        return snack
    }

    fun deleteSnack(id: String): Boolean {
        snackRepository.deleteById(id)
        return true
    }

    fun updateSnack(id: String, amount: Float): Snack {
        val snack = snackRepository.findById(id)
        snack.ifPresent {
            it.amount = amount
            snackRepository.save(it)
        }
        return snack.get()
    }
}