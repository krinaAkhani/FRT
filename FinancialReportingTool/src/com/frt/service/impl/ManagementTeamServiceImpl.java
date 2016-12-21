package com.frt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.frt.model.ManagementTeam;
import com.frt.repository.ManagementTeamRepositry;
import com.frt.service.ManagementTeamService;

@Service
public class ManagementTeamServiceImpl implements ManagementTeamService {

	@Autowired
	public ManagementTeamRepositry managementTeamRepositry;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Double getManagementTeamPersonRevenue(String columnName,
			String personName) {
		Double financeData = managementTeamRepositry
				.getManagementTeamPersonRevenue(columnName, personName);
		return financeData;
	}

}
