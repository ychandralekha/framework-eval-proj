package com.cts.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.bean.CustomerAccount;
import com.cts.exception.BankException;
import com.cts.service.BankService;
import com.cts.service.CustomerService;

@Controller
public class CustomerController {
	public static final Logger LOG = Logger.getLogger(CustomerController.class);
	@Autowired
	CustomerService customerService;
	@Autowired
	BankService bankService;

	@RequestMapping(value = "CustomerPage", method = RequestMethod.GET)
	public String customerGet(Model model, HttpServletRequest request) {
		LOG.info("customer page");
		request.setAttribute("Banks", bankService.displayBank());
		model.addAttribute("customer", new CustomerAccount());
		return "CustomerPage";
	}

	@RequestMapping(value = "CustomerAdd", method = RequestMethod.POST)
	public String addCustomer(Model model,
			@RequestParam("BankName") String selectedBankName,
			@ModelAttribute("customer") CustomerAccount customer,
			HttpServletRequest request) throws ParseException {
		LOG.info("adding a customer and displaying the entire list");
		try {
			customerService.addCustomer(customer, selectedBankName);
		} catch (BankException e) {
			request.setAttribute("error", e.getMessage());
		}
		request.setAttribute("Banks", bankService.displayBank());
		try {
			request.setAttribute("Customers", customerService.displayCustomer());
		} catch (BankException e) {
			request.setAttribute("error", e.getMessage());
		}
		model.addAttribute("customer", new CustomerAccount());
		return "CustomerPage";
	}

}
