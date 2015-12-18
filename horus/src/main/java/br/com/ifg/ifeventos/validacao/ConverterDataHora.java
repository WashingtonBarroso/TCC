package br.com.ifg.ifeventos.validacao;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
/*
public class ConverterDataHora {

	public ConverterDataHora() {
		//this(null,null,null);
	}

	@Inject
	private HttpServletRequest request;

	@Inject 
	private DateTimeFormatter fmtData;

	@Inject 
	private DateTimeFormatter fmtHora;

	public LocalDate converterData() {
		String rData = request.getParameter("data");
		fmtData =  DateTimeFormat.forPattern("dd/MM/yyyy"); 
		return	LocalDate.parse(rData,fmtData);
	}	

	public LocalTime converterTime(){
		String rHora = request.getParameter("hora");
		fmtHora = DateTimeFormat.forPattern("HH:mm");
		return LocalTime.parse(rHora, fmtHora);
	}

}
*/