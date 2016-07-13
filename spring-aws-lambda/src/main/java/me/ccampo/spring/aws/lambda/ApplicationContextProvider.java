package me.ccampo.spring.aws.lambda;

import org.springframework.context.ApplicationContext;

/**
 * @author Chris Campo
 */
public interface ApplicationContextProvider {
    ApplicationContext getApplicationContext();
}
