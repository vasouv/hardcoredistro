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
import vs.hardcoredistro.entities.Stock;
import vs.hardcoredistro.services.AlbumService;
import vs.hardcoredistro.services.CustomerService;
import vs.hardcoredistro.services.PurchaseService;
import vs.hardcoredistro.services.StockService;

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
	private StockService stockService;

	@Inject
	private PurchaseService purchaseService;

	@GET
	@Path("customers")
	public Response allCustomers() {
		List<Customer> customers = customerService.findAll();
		GenericEntity<List<Customer>> list = new GenericEntity<List<Customer>>(customers) {
		};
		return Response.ok(list).build();
	}

	@GET
	@Path("albums")
	public Response allAlbums() {
		List<Album> album = albumService.findAll();
		GenericEntity<List<Album>> list = new GenericEntity<List<Album>>(album) {
		};
		return Response.ok(list).build();
	}

	@GET
	@Path("stock")
	public Response allStock() {
		List<Stock> stock = stockService.findAll();
		GenericEntity<List<Stock>> list = new GenericEntity<List<Stock>>(stock) {
		};
		return Response.ok(list).build();
	}

	@GET
	@Path("purchases")
	public Response allPurchases() {
		List<Purchase> purchases = purchaseService.findAll();
		GenericEntity<List<Purchase>> list = new GenericEntity<List<Purchase>>(purchases) {
		};
		return Response.ok(list).build();
	}

	@GET
	@Path("purchases/1")
	public Response firstPurchase() {
		return Response.ok(purchaseService.first()).build();
	}

	@GET
	@Path("purchases/vasouv")
	public Response vasouv() {
		List<Purchase> vasouv = purchaseService.vasouv();
		GenericEntity<List<Purchase>> list = new GenericEntity<List<Purchase>>(vasouv) {
		};
		return Response.ok(list).build();
	}

}
