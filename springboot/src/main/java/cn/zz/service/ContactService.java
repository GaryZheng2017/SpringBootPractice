package cn.zz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zz.dao.ContactRepository;
import cn.zz.entity.Contact;

@Service
public class ContactService {
	@Autowired
	private ContactRepository contactRepository;
	
	public List<Contact> findAll(){
		return contactRepository.findAll();
	}
	
	public void save(Contact contact) {
		contactRepository.save(contact);
	}
}
