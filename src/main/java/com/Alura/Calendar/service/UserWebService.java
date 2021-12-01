package com.Alura.Calendar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.Alura.Calendar.model.UserWeb;
import com.Alura.Calendar.repository.UserWebRepository;

@Service
public class UserWebService {
	
	@Autowired
	private UserWebRepository repository;
	
	public String saveUpdate(UserWeb user) {
		try {
		this.repository.save(user);
		return "usuário " + user.getLogin() + " criado com sucesso!";
		}
		catch(NullPointerException e) {
			return "NullPointException";
		}
		catch(DataIntegrityViolationException e) {
			return "Não foi possível criar o usuário, há informações obrigatórias pendentes";
		}
	}
	
	public List<UserWeb> findAll() {
		return this.repository.findAll();
	}
	
	public UserWeb searchUser(String login) {
		return this.repository.findUser(login);
	}

	public Optional<UserWeb> searchActive(Boolean active) {
		return this.repository.findActive(active);
	}
}