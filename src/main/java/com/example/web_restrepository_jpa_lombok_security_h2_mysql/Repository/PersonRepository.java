package com.example.web_restrepository_jpa_lombok_security_h2_mysql.Repository;

import com.example.web_restrepository_jpa_lombok_security_h2_mysql.Entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface  PersonRepository  extends CrudRepository<Person, String > {
    public Person findByEmailIgnoreCase(@Param("email") String email);
}
