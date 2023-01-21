package com.example.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Currency;
import com.example.demo.repo.CurrencyRepository;

@Service
public class CurrencyService {

	private final static Logger LOGGER = LoggerFactory.getLogger(CurrencyService.class);

	@Autowired
	private CurrencyRepository repo;

	public Currency getCurrency(String name) {
		LOGGER.info("CurrencyService :: getCurrency ::  " + name);
		return repo.findByName(name);

	}

}
