package com.cts.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.bean.Banks;
import com.cts.exception.BankException;
import com.cts.service.BankService;

@Controller
public class BankController {
	public static final Logger LOG = Logger.getLogger(BankController.class);
	@Autowired
	BankService bankService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String registerData(Model model, HttpServletRequest request) {
		LOG.info("initail page");
		request.setAttribute("Banks", bankService.displayBank());
		model.addAttribute("bank", new Banks());
		return "AdminPage";
	}

	@RequestMapping(value = "bankNamesAdd", method = RequestMethod.POST)
	public String bankAdd(@ModelAttribute("bank") Banks bank, Model model,
			HttpServletRequest request) {
		LOG.info("adding a bank");
		try {
			bankService.addBank(bank);
		} catch (BankException e) {
			request.setAttribute("error", e.getMessage());
		}
		request.setAttribute("Banks", bankService.displayBank());
		model.addAttribute("bank", new Banks());
		return "AdminPage";
	}

	@RequestMapping(value = "bankNamesEdit", method = RequestMethod.POST)
	public String bankEdit(
			@ModelAttribute("bank") Banks bank,
			Model model,
			HttpServletRequest request,
			@RequestParam("newname") String editBankName,
			@RequestParam("BankName") String oldBank,
			@RequestParam(value = "deleteBank", required = false) String deleteBank) {
		LOG.info("edit a bank");
		if (deleteBank == null) {
			try {
				bankService.editBank(oldBank, editBankName);
			} catch (BankException e) {
				request.setAttribute("error", e.getMessage());
			}
		} else {
			try {
				bankService.deleteBank(oldBank);
			} catch (BankException e) {
				request.setAttribute("error", e.getMessage());
			}
		}
		model.addAttribute("bank", new Banks());
		request.setAttribute("Banks", bankService.displayBank());
		return "AdminPage";
	}

}
