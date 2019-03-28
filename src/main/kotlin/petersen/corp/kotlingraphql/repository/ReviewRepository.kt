package petersen.corp.kotlingraphql.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import petersen.corp.kotlingraphql.entity.Review

@Repository
interface ReviewRepository : MongoRepository<Review, String>