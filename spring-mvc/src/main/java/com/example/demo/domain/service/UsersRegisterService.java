package com.example.demo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.demo.domain.entity.Users;
import com.example.demo.domain.model.UserForm;
import com.example.demo.domain.repository.UsersRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UsersRegisterService {

	@Autowired
	private UsersRepository usersRepository;

	//1-6 存在チェックメソッド定義
	public boolean isValid(UserForm userForm, BindingResult bindingResult) {

		String  email = userForm.getEmail();
	// E-Mailが重複しているかチェック
	    if (usersRepository.existsByEmail(email)) {
	        bindingResult.rejectValue("email", "", "既に登録されているE-Mailです。");
	        return true;
	  }

	  return false;
	 }

	public void register(final UserForm userForm) {
		Users entity = new Users();
		entity.setName(userForm.getName());
		entity.setEmail(userForm.getEmail());
		entity.setAge(userForm.getAge());
		entity.setNote(userForm.getNote());
		usersRepository.save(entity);
	}

}