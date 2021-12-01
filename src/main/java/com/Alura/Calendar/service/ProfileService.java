package com.Alura.Calendar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.Alura.Calendar.model.Profile;
import com.Alura.Calendar.model.ProfileDTO;
import com.Alura.Calendar.model.UserWeb;
import com.Alura.Calendar.repository.ProfileRepository;
import com.Alura.Calendar.repository.UserWebRepository;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository repository;
	@Autowired
	private UserWebRepository repositoryUser;

	public String saveUpdate(ProfileDTO dto) {
		final UserWeb newUser = this.repositoryUser.findUser(dto.getUser());
		final Profile newProfile = new Profile();
		newProfile.setName(dto.getName());
		newProfile.setCountry(dto.getCountry());
		newProfile.setEmail(dto.getEmail());
		newProfile.setNumber(dto.getNumber());
		newProfile.setRole(dto.getRole());
		newProfile.setFk_user(newUser);
		if(newUser == null) return "Usuário "+ dto.getUser()+" não existe";
		try {
			this.repository.save(newProfile);
			return "usuário " + newProfile.getName() + " criado com sucesso!";
		} catch (NullPointerException e) {
			return "NullPointException";
		} catch (DataIntegrityViolationException e) {
			return "Não foi possível criar o usuário, há informações obrigatórias pendentes";
		}
	}
	
	public List<Profile> findList(List<String> list) {
		return repository.findByList(list);
	}
	
	public List<Profile> findAll() {
		return this.repository.findAll();
	}

}
