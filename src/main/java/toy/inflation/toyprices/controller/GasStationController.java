package toy.inflation.toyprices.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import toy.inflation.toyprices.domain.GasStation;
import toy.inflation.toyprices.repository.ApiDao;
import toy.inflation.toyprices.service.ApiService;

@RestController
public class GasStationController {
	@Autowired ApiService openApi;
	@Autowired ApiDao apiDao;
	GasStation station;
	
	public String stationList() throws IOException {
		openApi.findValues(station);
		
		return null;
	}
	
	public String stationModify() throws IOException {
		openApi.modifyValues(station);
		
		return null;
	}
}
