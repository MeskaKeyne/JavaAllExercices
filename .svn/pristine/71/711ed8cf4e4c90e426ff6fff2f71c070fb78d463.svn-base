package be.steformations.pc.timesheets.rs;

import java.util.Calendar;
import java.util.GregorianCalendar;

import be.steformations.pc.timesheets.dto.EmployeeDto;
import be.steformations.pc.timesheets.dto.PrestationDto;
import be.steformations.pc.timesheets.dto.ProjectDto;

public class TestUtils {

	protected Calendar calendar;
	
	public TestUtils() {
		super();
		this.calendar = GregorianCalendar.getInstance();
		this.calendar.set(1970, 0, 1, 0, 0, 0);
		this.calendar.set(Calendar.MILLISECOND, 0);
	}
	
	public EmployeeDto createBatman() {
		EmployeeDto batman = new EmployeeDto();
		batman.setId(1L);
		batman.setFirstname("bruce");
		batman.setName("wayne");
		batman.setLogin("batman");
		batman.setPassword("I am Batman");
		return batman;
	}
	
	public EmployeeDto createSuperman() {
		EmployeeDto superman = new EmployeeDto();
		superman.setId(3L);
		superman.setFirstname("clark");
		superman.setName("kent");
		superman.setLogin("superman");
		superman.setPassword("kal-el");
		return superman;
	}
	
	public EmployeeDto createWonderWoman() {
		EmployeeDto wonderWoman = new EmployeeDto();
		wonderWoman.setId(2L);
		wonderWoman.setFirstname("diana");
		wonderWoman.setName("prince");
		wonderWoman.setLogin("wonder");
		wonderWoman.setPassword("woman");
		return wonderWoman;
	}
	
	public ProjectDto createJusticeLeague() {
		ProjectDto justiceLeague = new ProjectDto();
		justiceLeague.setId(1L);
		justiceLeague.setName("Justice League");
		justiceLeague.setDescription("Superheros League");
		this.calendar.set(2017, 5, 21);
		justiceLeague.setStartDate(this.calendar.getTime());
		justiceLeague.setManager(this.createBatman());
		return justiceLeague;
	}
	
	public ProjectDto createFortressOfSolitude() {
		ProjectDto fortressOfSolitude = new ProjectDto();
		fortressOfSolitude.setId(2L);
		fortressOfSolitude.setName("Fortress of Solitude");
		fortressOfSolitude.setDescription("Be alone");
		this.calendar.set(2017, 5, 21);
		fortressOfSolitude.setStartDate(this.calendar.getTime());
		fortressOfSolitude.setManager(this.createSuperman());
		return fortressOfSolitude;
	}	
	
	public PrestationDto createSendEmail() {
		PrestationDto prestation = new PrestationDto();
		prestation.setId(1L);
		prestation.setComment("Send email");
		prestation.setDuration(2);
		prestation.setEmployee(this.createBatman());
		prestation.setProject(this.createJusticeLeague());
		this.calendar.set(2017, 5, 22);
		prestation.setDay(this.calendar.getTime());
		return prestation;
	}
	
	public PrestationDto createReadEmail() {
		PrestationDto prestation = new PrestationDto();
		prestation.setId(2L);
		prestation.setComment("Read email");
		prestation.setDuration(1);
		prestation.setEmployee(this.createWonderWoman());
		prestation.setProject(this.createJusticeLeague());
		this.calendar.set(2017, 5, 23);
		prestation.setDay(this.calendar.getTime());
		return prestation;
	}
	
	public PrestationDto createSendResponse() {
		PrestationDto prestation = new PrestationDto();
		prestation.setId(2L);
		prestation.setComment("Send response");
		prestation.setDuration(1);
		prestation.setEmployee(this.createWonderWoman());
		prestation.setProject(this.createJusticeLeague());
		this.calendar.set(2017, 5, 23);
		prestation.setDay(this.calendar.getTime());
		return prestation;
	}
	
	public PrestationDto createNew() {
		PrestationDto prestation = new PrestationDto();
		prestation.setComment("prestation n° " + System.currentTimeMillis());
		prestation.setDuration(1);
		prestation.setEmployee(this.createWonderWoman());
		prestation.setProject(this.createJusticeLeague());
		this.calendar.set(2017, 5, 24);
		prestation.setDay(this.calendar.getTime());
		return prestation;
	}
}
