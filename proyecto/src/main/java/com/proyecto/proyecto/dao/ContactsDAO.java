package com.proyecto.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.proyecto.entidades.Contacts;

public interface ContactsDAO  extends JpaRepository<Contacts, Long> {
	
	
	

}
