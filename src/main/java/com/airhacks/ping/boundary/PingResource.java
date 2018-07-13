package com.airhacks.ping.boundary;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import vs.hardcoredistro.entities.Customer;
import vs.hardcoredistro.services.CustomerService;

/**
 *
 * @author airhacks.com
 */
@Path("ping")
public class PingResource {

	@Inject
	private CustomerService customerService;

	@GET
	public Response ping() {
		List<Customer> all = customerService.findAll();
		GenericEntity<List<Customer>> list = new GenericEntity<List<Customer>>(all) {
		};
		return Response.ok(list).build();
	}

}
