package com.spring.sample.person;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Integer>  {
}
