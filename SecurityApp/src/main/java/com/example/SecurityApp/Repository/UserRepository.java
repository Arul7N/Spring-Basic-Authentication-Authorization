package com.example.SecurityApp.Repository;

import com.example.SecurityApp.Model.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Info, Long> {

    Optional<Info> findByName(String username);

}
