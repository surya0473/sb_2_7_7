package com.example.demo.fiegn;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.bean.Currency;
import com.example.demo.bean.ResponseBean;

@FeignClient(value = "CURRENCY", url = "http://localhost:8080/sb_2")
public interface CurrencyAPIService {

	@GetMapping(value = "/get/{name}")
	ResponseBean<Currency> getCurrency(@PathVariable String name);

}
