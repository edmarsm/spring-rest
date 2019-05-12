package br.com.edmardesenv.springrest.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {
	private static final long serialVersionUID = 201905110930L;

	@Id
	@SequenceGenerator(name = "SEQ_CLIENT", sequenceName = "SEQ_CLIENT")
	@GeneratedValue(generator = "SEQ_CLIENT")
	@Column(name = "ID")
	private Integer id;
	@Column(name = "NAME")
	private String name;

	public Client() {
		// Default constructor
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
		if (!(obj instanceof Client)) {
			return false;
		}
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}

}
