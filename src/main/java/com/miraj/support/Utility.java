package com.miraj.support;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Utility {

	public String convertTimestampToString(Timestamp timeStamp) {
		return new SimpleDateFormat("MM/dd/yyyy").format(timeStamp.getTime());
	}

	public Timestamp getTimestamp(String dateValue) {
		if (dateValue != null) {
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			Date date = null;
			try {
				date = formatter.parse(dateValue);
				Timestamp timestamp = new Timestamp(date.getTime());
				return timestamp;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * Calculate distance between two points in latitude and longitude taking
	 * into account height difference. If you are not interested in height
	 * difference pass 0.0. Uses Haversine method as its base.
	 * 
	 * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
	 * el2 End altitude in meters
	 * @returns Distance in Meters
	 */
	
	public double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == "K") {
			dist = dist * 1.609344;
		} 
		return (dist);
	}
	
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts decimal degrees to radians						 :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts radians to decimal degrees						 :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
	
	/*
	 * Example of calculating distance
	 * distance(32.9697, -96.80322, 29.46786, -98.53506, "M") + " Miles\n";
	 * */
	
	/*
	 * sql query for locating point in range
	   SET @lat = 23.00000;
	   SET @lon = 91.00000;
	
	  SELECT * from (SELECT latitude,longitude,(((acos(sin((@lat*pi()/180)) * sin((latitude*pi()/180))+cos((@lat*pi()/180))
	 * cos((latitude*pi()/180)) * cos(((@lon - longitude)*pi()/180))))*180/pi())*60*1.1515*1.609344) 
	 as distance FROM blood.user) t where distance <=125 ;

	 * */
	
	
	
}
