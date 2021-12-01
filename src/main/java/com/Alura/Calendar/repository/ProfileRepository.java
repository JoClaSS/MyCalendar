package com.Alura.Calendar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Alura.Calendar.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile,Long>{

	
	@Query(value= "select * from profile e where (:name is null or e.name= :name)", nativeQuery = true)
	Profile findByName(@Param("name") String name);
	
	@Query(value= "select * from profile e where (:email is null or e.email= :email)", nativeQuery = true)
	Profile findByEmail(@Param("email") String email);
	
	@Query(nativeQuery =true,value = "SELECT * FROM profile as e WHERE e.name IN (:names)")
	List<Profile> findByList(@Param("names") List<String> names);
}
