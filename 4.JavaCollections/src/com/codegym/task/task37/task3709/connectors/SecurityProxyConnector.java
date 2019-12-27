package com.codegym.task.task37.task3709.connectors;

import com.codegym.task.task37.task3709.security.SecurityChecker;
import com.codegym.task.task37.task3709.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector {
    private SimpleConnector simpleConnector;
    private SecurityChecker securityChecker;

    public SecurityProxyConnector(String resourceString) {
        this.simpleConnector = new SimpleConnector(resourceString);
        this.securityChecker = new SecurityCheckerImpl();
    }

    @Override
    public void connect() {
        if(securityChecker.performSecurityCheck())
            simpleConnector.connect();
        else System.out.println("SECURITY FAIL!");
    }
}
