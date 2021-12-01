package com.Alura.Calendar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Alura.Calendar.model.UserWeb;

public interface UserWebRepository extends JpaRepository<UserWeb, Long> {

	@Query(value= "select * from userweb e where (:login is null or e.login= :login)", nativeQuery = true)
	UserWeb findUser(@Param("login") String login);
	
	
	@Query(value= "select * from userweb e where (:active is null or e.active= :active)", nativeQuery = true)
	Optional<UserWeb> findActive(@Param("active") Boolean active);
}

