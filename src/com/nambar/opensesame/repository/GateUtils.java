package com.nambar.opensesame.repository;

import javax.servlet.http.HttpServletRequest;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class GateUtils
{
	public static final String GATE = "gate";
	public static final String GATE_ID = "gateid";
	public static final String GATE_NAME = "name";
	public static final String GATE_LATITUDE = "latitude";
	public static final String GATE_LONGITUDE = "longitude";
	public static final String GATE_OPEN_DISTANCE = "open_distance";
	public static final String GATE_PHONE_NUMBER = "phone_number";
	public static final String GATE_TIME_LIMIT = "time_limit";
	public static final String GATE_FROM_HOUR = "from_hour";
	public static final String GATE_FROM_MINUTES = "from_minutes";
	public static final String GATE_UNTIL_HOUR = "until_hour";
	public static final String GATE_UNTIL_MINUTES = "until_minutes";
	
	public static Entity makeEntity(HttpServletRequest req)
	{
		Key key = KeyFactory.createKey(GATE, GATE);
		Entity e = new Entity(GATE, key);
		e.setProperty(GATE_ID, req.getParameter(GATE_ID));
		e.setProperty(GATE_NAME, req.getParameter(GATE_NAME));
		e.setProperty(GATE_LATITUDE, Long.valueOf(req.getParameter(GATE_LATITUDE)));
		e.setProperty(GATE_LONGITUDE, Long.valueOf(req.getParameter(GATE_LONGITUDE)));
		e.setProperty(GATE_OPEN_DISTANCE, Float.valueOf(req.getParameter(GATE_OPEN_DISTANCE)));
		e.setProperty(GATE_PHONE_NUMBER, req.getParameter(GATE_PHONE_NUMBER));
		return e;
	}
}
