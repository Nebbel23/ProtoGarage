package no.vi.protogarage.security.config;

import lombok.AllArgsConstructor;

import no.vi.protogarage.enums.AppUserRole;
import no.vi.protogarage.services.AppUserService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static no.vi.protogarage.config.Constants.PATH_PREFIX;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
	private final AppUserService appUserService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
				.csrf().disable()
				.authorizeRequests()
				
				//TODO USERROLLEN!!!
				//todo kijken of dit invloed heeft op /car/nogiets
				
				.antMatchers(PATH_PREFIX + "/customer/**").hasAnyAuthority(AppUserRole.CASHIER.name(), AppUserRole.ADMIN.name())
				.antMatchers(PATH_PREFIX + "/car/**").hasAnyAuthority(AppUserRole.ADMIN.name(), AppUserRole.MECHANIC.name())
				.antMatchers(PATH_PREFIX + "/reparation").hasAnyAuthority(AppUserRole.ADMIN.name())
				
				//.antMatchers(PATH_PREFIX + "").hasAnyAuthority(AppUserRole.ADMIN.name())
				
				
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.and()
				.httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.authenticationProvider(daoAuthenticationProvider());
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(bCryptPasswordEncoder);
		provider.setUserDetailsService(appUserService);
		return provider;
	}
}