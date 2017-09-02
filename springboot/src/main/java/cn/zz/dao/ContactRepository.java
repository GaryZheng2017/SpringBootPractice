package cn.zz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.zz.entity.Contact;

/**
 * 注入jdbctemplate实现数据库的读取和写入
 * @author gary
 * @time 2017年9月2日 19:39:05
 */
@Repository
public class ContactRepository {
	private JdbcTemplate jdbc;
	
	@Autowired
	public ContactRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	/**
	 * 查询联系人
	 * @return 用户信息
	 */
	public List<Contact> findAll(){
		return jdbc.query("select id,firstName,lastName,phoneNumber,emailAddress"
				+ " from contacts order by lastName", new RowMapper<Contact>() {
					public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
						Contact contact = new Contact();
						contact.setId(rs.getLong(1));
						contact.setFirstName(rs.getString(2));
						contact.setLastName(rs.getString(3));
						contact.setPhoneNumber(rs.getString(4));
						contact.setEmailAddress(rs.getString(5));
						return contact;
					}
					
				});
	}
	
	
	/**
	 * 插入联系人
	 * @param contact 用户信息
	 */
	public void save(Contact contact) {
		jdbc.update("insert into contacts (firstName,lastName,phoneNumber,emailAddress) "
				+ "values (?, ?, ?, ?)",contact.getFirstName(),contact.getLastName(),
				contact.getPhoneNumber(),contact.getEmailAddress());
	}
	
	
	
}
