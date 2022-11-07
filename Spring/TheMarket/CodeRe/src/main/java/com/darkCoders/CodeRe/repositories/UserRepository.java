package com.darkCoders.CodeRe.repositories;

import com.darkCoders.CodeRe.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
