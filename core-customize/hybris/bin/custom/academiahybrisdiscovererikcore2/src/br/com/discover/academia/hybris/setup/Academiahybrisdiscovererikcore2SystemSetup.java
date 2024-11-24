/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package br.com.discover.academia.hybris.setup;

import static br.com.discover.academia.hybris.constants.Academiahybrisdiscovererikcore2Constants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import br.com.discover.academia.hybris.constants.Academiahybrisdiscovererikcore2Constants;
import br.com.discover.academia.hybris.service.Academiahybrisdiscovererikcore2Service;


@SystemSetup(extension = Academiahybrisdiscovererikcore2Constants.EXTENSIONNAME)
public class Academiahybrisdiscovererikcore2SystemSetup
{
	private final Academiahybrisdiscovererikcore2Service academiahybrisdiscovererikcore2Service;

	public Academiahybrisdiscovererikcore2SystemSetup(final Academiahybrisdiscovererikcore2Service academiahybrisdiscovererikcore2Service)
	{
		this.academiahybrisdiscovererikcore2Service = academiahybrisdiscovererikcore2Service;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		academiahybrisdiscovererikcore2Service.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return Academiahybrisdiscovererikcore2SystemSetup.class.getResourceAsStream("/academiahybrisdiscovererikcore2/sap-hybris-platform.png");
	}
}
