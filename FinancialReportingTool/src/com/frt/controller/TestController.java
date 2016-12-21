package com.frt.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.frt.model.Client;
import com.frt.model.FinancialData;
import com.frt.model.ManagementTeam;
import com.frt.model.Project;
import com.frt.model.ProjectResource;
import com.frt.model.SubProject;
import com.frt.service.ManagementTeamService;
import com.frt.service.TestService;

@Controller
public class TestController {

	@Autowired
	TestService testService;

	@Autowired
	HttpServletRequest request;

	@Autowired
	ManagementTeamService managementTeamService;

	/*
	 * @RequestMapping(value = "/") public String projectData() {
	 * 
	 * projectx();
	 * 
	 * projecty();
	 * 
	 * projectz();
	 * 
	 * return "index"; }
	 */

	@RequestMapping(value = "/")
	public String projectData1() {
		// managementTeamService.getManagementTeamPerson("projectManager",
		// "Anand Shah");
		return "data-fetch";
	}

	@RequestMapping(value = "fetch")
	public String dataFetch() {
		String name = request.getParameter("data");
		String finance = request.getParameter("finance");
		System.out.println(name);
		String[] parts = name.split("-");
		String part1 = parts[0];
		String part2 = parts[1];

		if (finance.equals("Revenue")) {
			parseDataColumnRevenue(part1, part2);
		} else if (finance.equals("Cost")) {
			//parseDataColumnCost(part1, part2);
		} else {
			//parseDataColumnMargin(part1, part2);
		}

		System.out.println(part1);
		System.out.println(part2);
		return "data-fetch";
	}

	private void parseDataColumnRevenue(String part1, String part2) {
		Double revenueData = null;
		switch (part1) {
		case "projectManager":
			revenueData = managementTeamService.getManagementTeamPersonRevenue(part1, part2);
			break;

		case "salesPerson":
			revenueData = managementTeamService.getManagementTeamPersonRevenue(part1, part2);
			break;

		case "salesHead":
			revenueData = managementTeamService.getManagementTeamPersonRevenue(part1, part2);
			break;

		case "deliveryHead":
			revenueData = managementTeamService.getManagementTeamPersonRevenue(part1, part2);
			break;	
			
		}
		
		request.setAttribute("financeData",revenueData);
	}

	public void sendDataToFrontEnd(){
		
		
	}
	
	public void projectz() {

		Project project3 = new Project("Licence", "Licence", "NN", "Existing",
				"Licence", "Licence", "Magento Licence", "Magento Licence",
				"Licence", new Date(), "USA", "Licence", "Vishal");

		ProjectResource projectResource7 = new ProjectResource("Licence",
				"Licence", "Licence", "Licence", "Licence", "Licence",
				"Licence");

		Client client3 = new Client("Microsoft", "IT", "USA", "Existing");

		ManagementTeam managementTeam4 = new ManagementTeam("Jogen G",
				"Pinkal K", "Pinkal K", "PKV Sastry", new Date(), new Date());

		FinancialData financialData7 = new FinancialData("april", 2015,
				new Date(), new Date(), 0, 0.00, 0.00, 0.00, 0.00, 0, 0.00,
				0.00, 0.00, 0.00);

		List<Project> projectList3 = new ArrayList<>();
		projectList3.add(project3);

		client3.setProjectList(projectList3);

		financialData7.setManagementTeam(managementTeam4);
		financialData7.setProject(project3);
		financialData7.setClient(client3);
		financialData7.setProjectResource(projectResource7);

		List<ProjectResource> projectResourcesList3 = new ArrayList<>();
		projectResourcesList3.add(projectResource7);
		project3.setProjectResourcesList(projectResourcesList3);

		List<ManagementTeam> managementTeamList3 = new ArrayList<>();
		managementTeamList3.add(managementTeam4);
		project3.setManagementTeamList(managementTeamList3);

		testService.testData(project3, client3, projectResource7,
				managementTeam4, financialData7);
	}

	public void projecty() {

		Project project2 = new Project("Apple IOS game", "Apple IOS game",
				"EE", "New", "Fixed Bid", "onsite", "portal", "liferay",
				"consulting", new Date(), "INDIA", "IOS", "Vishal");

		ProjectResource projectResource4 = new ProjectResource("CAD150506E",
				"Vishal Rangras", "Technical Lead", "IOS", "Ahmedabad",
				"Resource", "Offshore Employee");
		ProjectResource projectResource5 = new ProjectResource("CAD150508F",
				"Isha Mehta", "Developer", "Testing", "Noida", "Resource",
				"Offshore Employee");
		ProjectResource projectResource6 = new ProjectResource("CAD150508R",
				"Nehal Soni", "Developer", "UI", "Ahmedabad", "Resource",
				"Offshore Employee");

		Client client2 = new Client("Apple", "Entertainment", "APJ", "Existing");

		ManagementTeam managementTeam2 = new ManagementTeam("Jogen G",
				"Ashish T", "Ashish T", "PKV Sastry", new Date(), new Date());
		ManagementTeam managementTeam3 = new ManagementTeam("Kruti Shah",
				"Paul Anthony", "Paul Anthony", "PKV Sastry", new Date(),
				new Date());

		FinancialData financialData4 = new FinancialData("april", 2015,
				new Date(), new Date(), 30, 15000.00, 6200.00, 8800.00, 58.61,
				120, 55000.00, 26000.00, 29000.00, 52.73);
		FinancialData financialData5 = new FinancialData("april", 2015,
				new Date(), new Date(), 30, 14200.00, 6200.00, 8000.00, 56.36,
				120, 55000.00, 26000.00, 29000.00, 52.73);
		FinancialData financialData6 = new FinancialData("april", 2015,
				new Date(), new Date(), 30, 9000.00, 5200.00, 3800.00, 42.22,
				120, 55000.00, 26000.00, 29000.00, 52.73);

		SubProject subProject4 = new SubProject("IOS");
		SubProject subProject5 = new SubProject("IOS");
		SubProject subProject6 = new SubProject("UX");

		List<Project> projectList2 = new ArrayList<>();
		projectList2.add(project2);
		projectResource4.setProjectList(projectList2);

		client2.setProjectList(projectList2);

		List<ManagementTeam> managementTeamList2 = new ArrayList<>();
		managementTeamList2.add(managementTeam2);
		managementTeamList2.add(managementTeam3);
		project2.setManagementTeamList(managementTeamList2);

		List<SubProject> subProjectList2 = new ArrayList<SubProject>();
		subProjectList2.add(subProject4);
		subProjectList2.add(subProject5);
		subProjectList2.add(subProject6);
		project2.setSubProjectList(subProjectList2);

		financialData4.setClient(client2);
		financialData5.setClient(client2);
		financialData6.setClient(client2);

		financialData4.setProject(project2);
		financialData5.setProject(project2);
		financialData6.setProject(project2);

		financialData4.setSubProject(subProject4);
		financialData5.setSubProject(subProject5);
		financialData6.setSubProject(subProject6);

		financialData4.setProjectResource(projectResource4);
		financialData5.setProjectResource(projectResource5);
		financialData6.setProjectResource(projectResource6);

		financialData4.setManagementTeam(managementTeam2);
		financialData5.setManagementTeam(managementTeam2);
		financialData6.setManagementTeam(managementTeam2);

		List<ProjectResource> projectResourcesList2 = new ArrayList<>();
		projectResourcesList2.add(projectResource4);
		projectResourcesList2.add(projectResource5);
		projectResourcesList2.add(projectResource6);
		project2.setProjectResourcesList(projectResourcesList2);

		testService.testData(project2, client2, projectResource4,
				projectResource5, projectResource6, subProject4, subProject5,
				subProject6, managementTeam2, financialData4, financialData5,
				financialData6);
	}

	public void projectx() {

		Project project1 = new Project("IBM Portal",
				"IBM User Management Portal", "EE", "New", "Managed T&M",
				"onsite", "portal", "liferay", "consulting", new Date(), "USA",
				"Java", "Vishal");

		ProjectResource projectResource1 = new ProjectResource("CAD1111111A",
				"Juhi Soni", "Developer", "Java", "USA", "Resource",
				"Onsite Vendor");
		ProjectResource projectResource2 = new ProjectResource("CAD1111111B",
				"Charmy Raval", "Developer", "Java", "Ahmedabad", "Resource",
				"Offshore Employee");
		ProjectResource projectResource3 = new ProjectResource("CAD1111111C",
				"Krina Akhani", "QA", "D3", "Ahmedabad", "Resource",
				"Offshore Employee");

		Client client1 = new Client("IBM", "Networking", "USA", "New");

		ManagementTeam managementTeam1 = new ManagementTeam("Anand Shah",
				"Paul Anthony", "Paul Anthony", "Srinivas Tadeparti",
				new Date(), new Date());

		SubProject subProject1 = new SubProject("Liferay Portal");
		SubProject subProject2 = new SubProject("Liferay Portal");
		SubProject subProject3 = new SubProject("Liferay Portal");

		FinancialData financialData1 = new FinancialData("april", 2015,
				new Date(), new Date(), 30, 10000.00, 5940.00, 4060.00, 40.60,
				120, 55000.00, 26000.00, 29000.00, 52.73);
		FinancialData financialData2 = new FinancialData("april", 2015,
				new Date(), new Date(), 28, 9400.00, 5940.00, 3460.00, 36.81,
				110, 52000.00, 24000.00, 28000.00, 55.73);
		FinancialData financialData3 = new FinancialData("april", 2015,
				new Date(), new Date(), 29, 9600.00, 5940.00, 3460.00, 36.81,
				110, 52000.00, 24000.00, 28000.00, 55.73);

		List<Project> projectList1 = new ArrayList<>();
		projectList1.add(project1);
		projectResource1.setProjectList(projectList1);

		client1.setProjectList(projectList1);

		financialData1.setClient(client1);
		financialData2.setClient(client1);
		financialData3.setClient(client1);

		financialData1.setProject(project1);
		financialData2.setProject(project1);
		financialData3.setProject(project1);

		financialData1.setSubProject(subProject1);
		financialData2.setSubProject(subProject2);
		financialData3.setSubProject(subProject3);

		financialData1.setProjectResource(projectResource1);
		financialData2.setProjectResource(projectResource2);
		financialData3.setProjectResource(projectResource3);

		financialData1.setManagementTeam(managementTeam1);
		financialData2.setManagementTeam(managementTeam1);
		financialData3.setManagementTeam(managementTeam1);

		List<ProjectResource> projectResourcesList1 = new ArrayList<>();
		projectResourcesList1.add(projectResource1);
		projectResourcesList1.add(projectResource2);
		projectResourcesList1.add(projectResource3);
		project1.setProjectResourcesList(projectResourcesList1);

		List<SubProject> subProjectList1 = new ArrayList<SubProject>();
		subProjectList1.add(subProject1);
		subProjectList1.add(subProject2);
		subProjectList1.add(subProject3);
		project1.setSubProjectList(subProjectList1);

		List<ManagementTeam> managementTeamList1 = new ArrayList<>();
		managementTeamList1.add(managementTeam1);
		project1.setManagementTeamList(managementTeamList1);

		testService.testData(project1, client1, projectResource1,
				projectResource2, projectResource3, subProject1, subProject2,
				subProject3, managementTeam1, financialData1, financialData2,
				financialData3);
	}
}
