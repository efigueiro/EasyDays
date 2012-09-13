package com.easydays.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Classe responsável por manipular dados do banco.
 * 
 * @author Éverson Figueiró
 * @version 1.0
 */
public class TimeConverter {

	private static TimeConverter timeConverter;

	private TimeConverter() {
	}

	public static TimeConverter getInstance() {
		if (timeConverter == null) {
			timeConverter = new TimeConverter();
		}
		return timeConverter;
	}

	public String currentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		return sdf.format(cal.getTime());
	}

	public String currentDate() {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		return df.format(calendar.getTime());
	}

	/*public String calculaHoraTrabalho(String inicio, String fim)
			throws ParseException {

		int inicioTurnoMinutos;
		int fimTurnoMinutos;
		int minutosTrabalhados;

		inicioTurnoMinutos = (Integer.parseInt(inicio.substring(0, 2)) * 60)
				+ (Integer.parseInt(inicio.substring(3, 5)));

		fimTurnoMinutos = (Integer.parseInt(fim.substring(0, 2)) * 60)
				+ (Integer.parseInt(fim.substring(3, 5)));

		minutosTrabalhados = fimTurnoMinutos - inicioTurnoMinutos;

		return minutosParaHoras(minutosTrabalhados);
	}

	public String minutosParaHoras(int loop) {
		String total = "";
		int hora = 0;
		int minuto = 0;
		
		String strHora = "";
		String strMinuto = "";
		
		for(int i = 0; i < loop; i++){
			minuto ++;
			if(minuto > 59){
				minuto = 0;
				hora ++;
			}
		}
		
		if(hora <= 9){
			strHora = "0" + String.valueOf(hora);
		} else{
			strHora = String.valueOf(hora);
		}
		
		if(minuto <= 9){
			strMinuto = "0" + String.valueOf(minuto);
		} else{
			strMinuto = String.valueOf(minuto);
		}
		
		total = strHora + ":" + strMinuto;
		
		return total;
	}*/
}
