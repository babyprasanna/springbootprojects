package spring.pratice.studentdemorelations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.pratice.studentdemorelations.model.Branch;
import spring.pratice.studentdemorelations.service.BranchService;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;

	@RequestMapping(value = "add/branch", method = RequestMethod.POST)
	public boolean addBranch(@RequestBody Branch b) {
		return branchService.addBranch(b);
	}

	@RequestMapping(value = "get/brach/{id}", method = RequestMethod.GET)
	public Branch getBranch(@PathVariable int id) {
		return branchService.getBranch(id);
	}

	@RequestMapping(value = "getall/brach", method = RequestMethod.GET)
	public List<Branch> getallBranchs() {
		return branchService.getallBranch();
	}

	@RequestMapping(value = "update/branch/{id}", method = RequestMethod.PUT)
	public void updateBranch(@PathVariable int id, Branch b) {
		branchService.updateBranch(id, b);
	}

	@RequestMapping(value = "remove/branch/{id}", method = RequestMethod.DELETE)
	public boolean removeBrach(@PathVariable int id) {
		return branchService.removeBranch(id);
	}

}
