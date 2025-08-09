package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class FindCandidateBean {
	private int candid;
	private Candidate candidate;
	
	public FindCandidateBean() {
	}

	public int getCandid() {
		return candid;
	}

	public void setCandid(int candid) {
		this.candid = candid;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
	public void findCandidate() {
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			this.candidate = candDao.findById(this.candid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
