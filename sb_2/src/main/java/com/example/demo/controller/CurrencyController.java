package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.ResponseBean;
import com.example.demo.entity.Currency;
import com.example.demo.service.impl.CurrencyService;

@RestController
public class CurrencyController {

	private final static Logger LOGGER = LoggerFactory.getLogger(CurrencyController.class);

	@Autowired
	private CurrencyService service;

	@GetMapping("/get/{name}")
	public ResponseBean<Currency> getCurrency(@PathVariable String name) {
		LOGGER.info("CurrencyController : getCurrency : name : " + name);
		ResponseBean<Currency> resp = new ResponseBean<>();
		Currency currency = service.getCurrency(name);
		if (currency != null) {
			resp.setResponse(currency);
			resp.setCode(200);
			resp.setMessage("Currency FOund");
		} else {
			resp.setCode(201);
			resp.setMessage("No Currency FOund");
		}
		return resp;

	}

}
