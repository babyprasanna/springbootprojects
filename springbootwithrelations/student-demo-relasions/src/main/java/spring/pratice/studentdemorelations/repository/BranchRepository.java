package spring.pratice.studentdemorelations.repository;

import org.springframework.data.repository.CrudRepository;

import spring.pratice.studentdemorelations.model.Branch;

public interface BranchRepository extends CrudRepository<Branch, Integer> {

}
