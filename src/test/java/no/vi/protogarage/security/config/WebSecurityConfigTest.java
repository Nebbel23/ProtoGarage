package no.vi.protogarage.security.config;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import no.vi.protogarage.repositories.AppUserRepository;
import no.vi.protogarage.services.AppUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.accept.ContentNegotiationStrategy;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {WebSecurityConfig.class, BCryptPasswordEncoder.class,
		AuthenticationConfiguration.class})
@ExtendWith(SpringExtension.class)
class WebSecurityConfigTest
{
	@MockBean
	private AppUserService appUserService;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@MockBean
	private AuthenticationTrustResolver authenticationTrustResolver;
	
	@MockBean
	private ContentNegotiationStrategy contentNegotiationStrategy;
	
	@Autowired
	private ObjectPostProcessor<Object> objectPostProcessor;
	
	@Autowired
	private WebSecurityConfig webSecurityConfig;
	
	/**
	 * Method under test: {@link WebSecurityConfig#configure(AuthenticationManagerBuilder)}
	 */
	@Test
	void testConfigure() throws Exception
	{
		AuthenticationManagerBuilder authenticationManagerBuilder = new AuthenticationManagerBuilder(
				this.objectPostProcessor);
		this.webSecurityConfig.configure(authenticationManagerBuilder);
		assertTrue(authenticationManagerBuilder.isConfigured());
	}
	
	/**
	 * Method under test: {@link WebSecurityConfig#daoAuthenticationProvider()}
	 */
	@Test
	void testDaoAuthenticationProvider()
	{
		//   Diffblue Cover was unable to write a Spring test,
		//   so wrote a non-Spring test instead.
		//   Reason: R004 No meaningful assertions found.
		//   Diffblue Cover was unable to create an assertion.
		//   Make sure that fields modified by daoAuthenticationProvider()
		//   have package-private, protected, or public getters.
		//   See https://diff.blue/R004 to resolve this issue.
		
		AppUserService appUserService = new AppUserService(mock(AppUserRepository.class));
		DaoAuthenticationProvider actualDaoAuthenticationProviderResult = (new WebSecurityConfig(appUserService,
				new BCryptPasswordEncoder())).daoAuthenticationProvider();
		assertTrue(actualDaoAuthenticationProviderResult
				.getUserCache() instanceof org.springframework.security.core.userdetails.cache.NullUserCache);
		assertTrue(actualDaoAuthenticationProviderResult.isHideUserNotFoundExceptions());
		assertFalse(actualDaoAuthenticationProviderResult.isForcePrincipalAsString());
	}
}