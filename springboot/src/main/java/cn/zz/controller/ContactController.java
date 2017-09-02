package cn.zz.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.zz.entity.Contact;
import cn.zz.service.ContactService;

@Controller
@RequestMapping("/")
public class ContactController {
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Map<String,Object> model) {
		List<Contact> contacts = contactService.findAll();
		model.put("contacts", contacts);
		return "home";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String save(Contact contact) {
		contactService.save(contact);
		return "redirect:/";
	}
}
