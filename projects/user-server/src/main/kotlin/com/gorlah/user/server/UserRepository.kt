package com.gorlah.user.server

import org.springframework.data.mongodb.repository.MongoRepository
import java.util.UUID

interface UserRepository : MongoRepository<User, UUID>
