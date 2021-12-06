package spring.pratice.studentdemorelations.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import spring.pratice.studentdemorelations.model.Branch;
import spring.pratice.studentdemorelations.repository.BranchRepository;

@Service
public class BranchService {

	@Autowired
	BranchRepository branchRepository;

	public Branch getBranch(int id) {

		Optional<Branch> op = branchRepository.findById(id);

		if (op.isPresent()) {
			return op.get();
		} else {
			try {
				throw new RuntimeException("Error Occured");

			} catch (RuntimeException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id is Not Found " + id);
			}
		}
	}

	public boolean addBranch(Branch b) {

		List<Branch> branchlist = (List<Branch>) branchRepository.findAll();

		for (Branch br : branchlist) {
			if (br.getBid() == b.getBid()) {
				try {
					throw new RuntimeException("Error Occured");

				} catch (RuntimeException e) {
					throw new ResponseStatusException(HttpStatus.CONFLICT, "Id is present in database " + b.getBid());
				}
			}
		}
		branchRepository.save(b);
		return true;
	}

	public List<Branch> getallBranch() {
		return (List<Branch>) branchRepository.findAll();
	}

	public boolean removeBranch(int id) {

		Optional<Branch> op = branchRepository.findById(id);

		if (op.isPresent()) {

			branchRepository.deleteById(id);
			return true;
		} else {
			try {
				throw new RuntimeException("Error Occured");

			} catch (RuntimeException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id is Not Found " + id);
			}
		}

	}

	public void updateBranch(int id, Branch b) {

		removeBranch(id);
		addBranch(b);
	}

}
