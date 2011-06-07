package com.nambar.opensesame.repository;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;

@SuppressWarnings("serial")
public class SearchGateServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/plain");
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Key key = KeyFactory.createKey(GateUtils.GATE, GateUtils.GATE);
		Query query = new Query(GateUtils.GATE, key).addSort(GateUtils.GATE_NAME, Query.SortDirection.ASCENDING);
		List<Entity> gates = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(5));
		resp.getWriter().println(gates.toString());
	}
}
