package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Currency;
import com.example.demo.bean.ResponseBean;
import com.example.demo.fiegn.CurrencyAPIService;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CurrencyConverterController {

	private final static Logger LOGGER = LoggerFactory.getLogger(CurrencyConverterController.class);

	@Autowired
	private CurrencyAPIService currencyService;

	@GetMapping("/get/{name}")
	@Retry(name = "getCurrencyRetry", fallbackMethod = "fallback")
	public ResponseBean<Currency> getCurrency(@PathVariable String name) {
		LOGGER.info("CurrencyConverterController : getCurrency : name : " + name);
		return currencyService.getCurrency(name);

	}

	public ResponseBean<Currency> fallback(Exception e) {
		ResponseBean<Currency> resp = new ResponseBean<Currency>();
		resp.setCode(500);
		resp.setMessage("Something went wrong...!");
		return resp;
	}

}
