package br.com.edmardesenv.springrest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.edmardesenv.springrest.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	Page<Client> findAll(Pageable pageable);

	Optional<Client> findByName(String name);

	List<Client> findByNameLike(String name);

}
