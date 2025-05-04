package com.Convo.Convo.repositorys;

import com.Convo.Convo.models.ApplicationUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationUsersRepository  extends JpaRepository<ApplicationUsers,Long> {

    Optional<ApplicationUsers> findByusername(String username);  // to avoid duplicate values in username

    Optional<ApplicationUsers> findByUsername(String username);
}
