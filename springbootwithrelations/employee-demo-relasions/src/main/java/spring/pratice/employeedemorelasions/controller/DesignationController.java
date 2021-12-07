package spring.pratice.employeedemorelasions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.pratice.employeedemorelasions.model.Designation;
import spring.pratice.employeedemorelasions.service.DesignationService;

@RestController
public class DesignationController {

	@Autowired
	DesignationService designationService;

	@RequestMapping(value = "add/designation", method = RequestMethod.POST)
	public boolean addDesignation(@RequestBody Designation d) {
		return designationService.addDesignation(d);
	}

	@RequestMapping(value = "get/designation/{id}", method = RequestMethod.GET)
	public List<Designation> getDesignation(@PathVariable int id) {
		return designationService.getDesignation(id);
	}
	@RequestMapping(value = "getall/designation", method = RequestMethod.GET)
	public List<Designation> getallDesignations() {
		return designationService.getallDesignations();
	}

	@RequestMapping(value = "update/designation/{id}", method = RequestMethod.PUT)
	public void updateDesignation(@PathVariable int id, Designation d) {
		designationService.updateDesignation(id, d);
	}

	@RequestMapping(value = "remove/designation/{id}", method = RequestMethod.DELETE)
	public boolean removeDesignation(@PathVariable int id) {
		return designationService.removeDesignation(id);
	}

}
