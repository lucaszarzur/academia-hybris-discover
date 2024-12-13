/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.yb2bacceleratorstorefront.filters;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.security.BruteForceAttackCounter;
import de.hybris.platform.util.Config;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.web.util.matcher.RequestMatcher;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class PreLoginCheckFilterTest
{
	@InjectMocks
	private PreLoginCheckFilter preLoginCheckFilter;

	@Mock
	private BruteForceAttackCounter bruteForceAttackCounter;

	@Mock
	private HttpServletRequest httpServletRequest;

	@Mock
	private HttpServletResponse httpServletResponse;

	@Mock
	private FilterChain filterChain;

	@Mock
	private HttpSession httpSession;

	@Mock
	private RequestMatcher loginRequestMatcher;


	@Test
	public void testDoFilterWithOtpEnabledAndUsernameNotMatch() throws Exception {
		try (MockedStatic<Config> config = Mockito.mockStatic(Config.class))
		{
			config.when(() -> Config.getBoolean(WebConstants.OTP_CUSTOMER_LOGIN_ENABLED, false)).thenReturn(true);
			when(httpServletRequest.getSession()).thenReturn(httpSession);
			when(loginRequestMatcher.matches(any())).thenReturn(true);
			when(httpServletRequest.getParameter("otpUserName")).thenReturn("username");
			when(httpServletRequest.getParameter("lastOtpUserName")).thenReturn("lastUsername");
			preLoginCheckFilter.doFilter(httpServletRequest, httpServletResponse, filterChain);
			verify(bruteForceAttackCounter, times(1)).registerLoginFailure("username");
			verify(httpSession, times(1)).setAttribute("SPRING_SECURITY_LAST_USERNAME", "username");
			verify(httpSession, times(1)).setAttribute("OTP_USERNAME_CHANGED", true);
			verify(filterChain, never()).doFilter(httpServletRequest, httpServletResponse);
		}
	}

	@Test
	public void testDoFilterWithOtpEnabledAndUsernameMatch() throws Exception {
		try (MockedStatic<Config> config = Mockito.mockStatic(Config.class))
		{
			config.when(() -> Config.getBoolean(WebConstants.OTP_CUSTOMER_LOGIN_ENABLED, false)).thenReturn(true);
			when(loginRequestMatcher.matches(any())).thenReturn(true);
			when(httpServletRequest.getParameter("otpUserName")).thenReturn("username");
			when(httpServletRequest.getParameter("lastOtpUserName")).thenReturn("username");
			preLoginCheckFilter.doFilter(httpServletRequest, httpServletResponse, filterChain);
			verify(filterChain, times(1)).doFilter(httpServletRequest, httpServletResponse);
		}
	}

	@Test
	public void testDoFilterWithOtpNotEnabled() throws Exception {
		try (MockedStatic<Config> config = Mockito.mockStatic(Config.class))
		{
			config.when(() -> Config.getBoolean(WebConstants.OTP_CUSTOMER_LOGIN_ENABLED, false)).thenReturn(false);
			when(Config.getBoolean(WebConstants.OTP_CUSTOMER_LOGIN_ENABLED, false)).thenReturn(false);
			preLoginCheckFilter.doFilter(httpServletRequest, httpServletResponse, filterChain);
			verify(filterChain, times(1)).doFilter(httpServletRequest, httpServletResponse);
		}
	}
}