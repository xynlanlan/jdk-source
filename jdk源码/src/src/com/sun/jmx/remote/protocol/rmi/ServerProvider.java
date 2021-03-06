/*
 * @(#)ServerProvider.java	1.4 04/02/13
 * 
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.jmx.remote.protocol.rmi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import javax.management.MBeanServer;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerProvider;
import javax.management.remote.JMXServiceURL;
import javax.management.remote.rmi.RMIConnectorServer;

public class ServerProvider implements JMXConnectorServerProvider {

    public JMXConnectorServer newJMXConnectorServer(JMXServiceURL serviceURL,
						    Map<String,?> environment,
						    MBeanServer mbeanServer)
	    throws IOException {
	if (!serviceURL.getProtocol().equals("rmi")) {
	    throw new MalformedURLException("Protocol not rmi: " +
					    serviceURL.getProtocol());
	}
	return new RMIConnectorServer(serviceURL, environment, mbeanServer);
    }

}
