package edu.mga.restapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mga.restapi.model.Book;
import edu.mga.restapi.model.Branch;
import edu.mga.restapi.service.BranchService;

@RestController
@RequestMapping(value = {
		 "/api"
		})
public class BranchController {
	
	private static Logger logger = LoggerFactory.getLogger(BranchController.class);
	
	@Autowired
	private BranchService branchService;
	
	/**
	 * @URL http://xxx.xxx.xxx.xxx:8080/branch/create
	 * @Method Post
	 * @param   {
	 *				"name": "Macon Branch",
	 * 				"address": "100 University Parkway",
	 * 				"city": "Macon",
	 * 				"state": "GA",
	 * 				"zip": "31206",
	 * 				"phone": "478-471-2800"
     * 			}
	 * @return
	 */	
	@RequestMapping(method=RequestMethod.POST, value="/branch/create")
	public Branch addBranch(@Valid @RequestBody Branch model) {
		logger.info("Branch: "+model);
		
		return branchService.addBranch(model);
	}
	
	/**
	 * @URL http://xxx.xxx.xxx.xxx:8080/branch/{id}
	 * @Method GET
	 * @param   
	 * @return {
	 * 				"id": 1,
	 *				"name": "Macon Branch",
	 * 				"address": "100 University Parkway",
	 * 				"city": "Macon",
	 * 				"state": "GA",
	 * 				"zip": "31206",
	 * 				"phone": "478-471-2800"
     * 			}
	 */	
	@RequestMapping(method=RequestMethod.GET, value="/branch/{id}")
	public Branch getBranch(@PathVariable Long id) {
		logger.info("branchid: "+id);
		
		return branchService.findBranch(id);
	}
	
	/**
	 * @URL http://xxx.xxx.xxx.xxx:8080/branch/get
	 * @Method GET
	 * @param   
	 * @return [{
	 * 				"id": 1,
	 *				"name": "Macon Branch",
	 * 				"address": "100 University Parkway",
	 * 				"city": "Macon",
	 * 				"state": "GA",
	 * 				"zip": "31206",
	 * 				"phone": "478-471-2800"
     * 			},
     * 			...
     * 			]
	 */	
	@RequestMapping(method=RequestMethod.GET, value="/branch/get")
	public List<Branch> getAllBranches() {
		logger.info("branchid: ");
		
		return branchService.findAllBranches();
	}
	
	/**
	 * @URL http://xxx.xxx.xxx.xxx:8080/branch/{id}
	 * @Method DELETE
	 * @param   
	 * @return "MESSAGE"
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="/branch/{id}")
	public String deleteBranch(@PathVariable Long id) {
		logger.info("branchid: " + id);
		Branch branch = branchService.findBranch(id);
		branchService.deleteBranch(branch);
		
		return "Successfully deleted";
	}
}
