package com.register.users.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name="tb_user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Size(min=5, max=200, message="Por favor, digite um nome com pelo menos 5 caractéres.")
	private String name_user;
	
	@NotNull
	@CPF
	private String cpf;
	
	@NotNull
	@Email(message="Por favor, insira um e-mail válido.")
	private String email;
	
	@NotNull
	private String phone;
	
	@NotNull
	private String uf;
	
	@NotNull
	@Size(min=5, max=255, message="Por favor, digite um endereço com pelo menos 5 caractéres.")
	private String address;
	
	@NotNull
	private String number;
	
	@NotNull
	private String neighborhood;
	
	@NotNull
	private String cep;
	
	public User() {}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName_user() {
		return name_user;
	}

	public void setName_user(String name_user) {
		this.name_user = name_user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name_user=" + name_user + ", cpf=" + cpf + ", email=" + email + ", phone=" + phone
				+ ", uf=" + uf + ", address=" + address + ", number=" + number + ", neighborhood=" + neighborhood
				+ ", cep=" + cep + "]";
	}
	
}













