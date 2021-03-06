package com.capg.movie.capg.movie.booking.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.capg.movie.capg.movie.booking.entities.Admin;

@Component
public interface AdminService {

	
	@Transactional
	public void addAdmin(Admin admin);
	public List<Admin> viewAllAdmin();
	public Admin viewAdminById(int id);
	public void deleteAdmin(int id);
	public Admin updateAdmin(Admin a);

}