// UserRepository.java
package com.anoushka.finance.repository;

import com.anoushka.finance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Additional query methods if needed
}
