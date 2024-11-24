/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package br.com.discover.academia.hybris.setup;

import static br.com.discover.academia.hybris.constants.Academiahybrisdiscovererikcore3Constants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import br.com.discover.academia.hybris.constants.Academiahybrisdiscovererikcore3Constants;
import br.com.discover.academia.hybris.service.Academiahybrisdiscovererikcore3Service;


@SystemSetup(extension = Academiahybrisdiscovererikcore3Constants.EXTENSIONNAME)
public class Academiahybrisdiscovererikcore3SystemSetup
{
	private final Academiahybrisdiscovererikcore3Service academiahybrisdiscovererikcore3Service;

	public Academiahybrisdiscovererikcore3SystemSetup(final Academiahybrisdiscovererikcore3Service academiahybrisdiscovererikcore3Service)
	{
		this.academiahybrisdiscovererikcore3Service = academiahybrisdiscovererikcore3Service;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		academiahybrisdiscovererikcore3Service.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return Academiahybrisdiscovererikcore3SystemSetup.class.getResourceAsStream("/academiahybrisdiscovererikcore3/sap-hybris-platform.png");
	}
}
