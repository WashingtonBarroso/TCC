package br.com.ifg.ifeventos.converterdata;
import java.util.Locale;

import org.joda.time.LocalDate;

import br.com.caelum.vraptor.converter.jodatime.LocalTimeConverter;
import br.com.caelum.vraptor.converter.jodatime.LocalDateConverter;


public class ConverterData {


public LocalDate convertData(){
	LocalDateConverter dta = new LocalDateConverter(Locale.ROOT);
	String sdta;
	return dta.convert(sdta,);
}
	
	
	
	
	
}
