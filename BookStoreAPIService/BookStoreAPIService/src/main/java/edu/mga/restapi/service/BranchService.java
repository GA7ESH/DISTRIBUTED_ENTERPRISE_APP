package edu.mga.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mga.restapi.model.Branch;
import edu.mga.restapi.repo.BranchRepository;

@Service
public class BranchService {

	@Autowired
	protected BranchRepository branchRepository;
	
	public Branch addBranch(Branch branch) {
		return branchRepository.saveAndFlush(branch);
	}
	
	public Branch findBranch(Long branchId) {
		return branchRepository.findById(branchId).get();
	}
	
	public List<Branch> findAllBranches() {
		return branchRepository.findAll();
	}
	
	public void deleteBranch(Branch branch) {
		branchRepository.delete(branch);
	}
}
