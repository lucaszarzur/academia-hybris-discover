/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package br.com.discover.academia.hybris.controller;

import static br.com.discover.academia.hybris.constants.Academiahybrisdiscovererikcore3Constants.PLATFORM_LOGO_CODE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.discover.academia.hybris.service.Academiahybrisdiscovererikcore3Service;


@Controller
public class Academiahybrisdiscovererikcore3HelloController
{
	@Autowired
	private Academiahybrisdiscovererikcore3Service academiahybrisdiscovererikcore3Service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(final ModelMap model)
	{
		model.addAttribute("logoUrl", academiahybrisdiscovererikcore3Service.getHybrisLogoUrl(PLATFORM_LOGO_CODE));
		return "welcome";
	}
}
