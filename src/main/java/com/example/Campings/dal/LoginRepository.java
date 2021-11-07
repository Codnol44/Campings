package com.example.Campings.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Campings.bo.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{
	Login findByUsernameAndPassword(String username, String password);
 
}
