package com.airhacks.ping.boundary;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import vs.hardcoredistro.entities.Album;
import vs.hardcoredistro.entities.Customer;
import vs.hardcoredistro.entities.Purchase;
import vs.hardcoredistro.services.AlbumService;
import vs.hardcoredistro.services.CustomerService;
import vs.hardcoredistro.services.PurchaseService;

/**
 *
 * @author airhacks.com
 */
@Path("ping")
public class PingResource {

	@Inject
	private CustomerService customerService;

	@Inject
	private AlbumService albumService;
	
	@Inject
	private PurchaseService purchaseService;

	@GET
	@Path("customers")
	public Response customers() {
		List<Customer> all = customerService.findAll();
		GenericEntity<List<Customer>> list = new GenericEntity<List<Customer>>(all) {
		};
		return Response.ok(list).build();
	}

	@GET
	@Path("albums")
	public Response albums() {
		List<Album> all = albumService.findAll();
		GenericEntity<List<Album>> list = new GenericEntity<List<Album>>(all) {
		};
		return Response.ok(list).build();
	}
	
	@GET
	@Path("purchases")
	public Response purchases() {
		List<Purchase> all = purchaseService.findAll();
		GenericEntity<List<Purchase>> list = new GenericEntity<List<Purchase>>(all) {
		};
		return Response.ok(list).build();
	}

}
