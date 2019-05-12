package br.com.edmardesenv.springrest.dto;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class ClientDto {

	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotEmpty(message = "Client name could not be empty.")
	@Length(min= 3, max = 200, message = "Client name must have between 3 and 200 characters.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ClientDto)) {
			return false;
		}
		ClientDto other = (ClientDto) obj;
		return Objects.equals(id, other.id);
	}

}
