package com.github.bkenn.repository

import com.github.bkenn.model.Greeter
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * Created: Brian
 * Date:    8/14/2017
 */
@Repository interface GreeterRepository: CrudRepository<Greeter, Int>