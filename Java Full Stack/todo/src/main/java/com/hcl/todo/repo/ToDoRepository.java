package com.hcl.todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.hcl.todo.model.Todo;

@Repository
public interface ToDoRepository extends JpaRepository<Todo, Integer>{
	
	@Query("select t from Todo t where t.user.username = :username")
	List<Todo> findAllByUsername(String username);
	


}
											