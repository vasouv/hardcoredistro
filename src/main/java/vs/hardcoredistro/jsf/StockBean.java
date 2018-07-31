package vs.hardcoredistro.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import vs.hardcoredistro.services.StockService;

@Named
@RequestScoped
public class StockBean {

	@Inject
	private StockService stockService;
	
	public int getStock(Long aid) {
		return stockService.findByID(aid).getStock();
	}

}
