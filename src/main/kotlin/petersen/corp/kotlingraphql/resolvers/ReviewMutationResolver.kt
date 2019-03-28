package petersen.corp.kotlingraphql.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component
import petersen.corp.kotlingraphql.entity.Review
import petersen.corp.kotlingraphql.repository.ReviewRepository

@Component
class ReviewMutationResolver (private val reviewRepository: ReviewRepository): GraphQLMutationResolver {
    fun newReview(snackId: String, rating: Int, text:String): Review {
        val review = Review(snackId, rating, text)
        reviewRepository.save(review)
        return review
    }
}