package spring.pratice.employeedemorelasions.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import spring.pratice.employeedemorelasions.model.Designation;
import spring.pratice.employeedemorelasions.repository.DesignationRepository;

@Service
public class DesignationService {

	@Autowired
	DesignationRepository designationRepository;

	public List<Designation> getDesignation(int id) {
		Optional<Designation> op = designationRepository.findById(id);

		if (op.isPresent()) {
			List<Designation> deslist = new ArrayList<>();
			deslist.add(op.get());
			return deslist;
		} else {
			try {
				throw new RuntimeException("Error Occured");

			} catch (RuntimeException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id is Not Found " + id);
			}
		}
	}

	public boolean addDesignation(Designation d) {

		List<Designation> deslist = (List<Designation>) designationRepository.findAll();

		for (Designation de : deslist) {
			if (de.getDid() == d.getDid()) {
				try {
					throw new RuntimeException("Error Occured");

				} catch (RuntimeException ex) {
					throw new ResponseStatusException(HttpStatus.CONFLICT, "Id is present in database " + d.getDid());
				}
			}
		}
		designationRepository.save(d);
		return true;
	}

	public List<Designation> getallDesignations() {
		return (List<Designation>) designationRepository.findAll();
	}

	public boolean removeDesignation(int id) {

		Optional<Designation> op = designationRepository.findById(id);

		if (op.isPresent()) {
			designationRepository.deleteById(id);
			return true;
		} else {
			try {
				throw new RuntimeException("Error Occured");

			} catch (RuntimeException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id is Not Found " + id);
			}
		}
	}

	public void updateDesignation(int id, Designation d) {

		removeDesignation(id);
		addDesignation(d);

	}

}
