package edu.mga.restapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mga.restapi.model.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long> {

}
