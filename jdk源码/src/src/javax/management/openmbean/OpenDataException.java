/*
 * @(#)OpenDataException.java	3.19 05/11/17
 * 
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.management.openmbean;

// jmx import
//
import javax.management.JMException;

/**
 * This checked exception is thrown when an <i>open type</i>, an <i>open data</i>  or an <i>open MBean metadata info</i> instance 
 * could not be constructed because one or more validity constraints were not met.
 *
 * @version     3.19  05/11/17
 * @author      Sun Microsystems, Inc.
 *
 * @since 1.5
 * @since.unbundled JMX 1.1
 */
public class OpenDataException extends JMException {

    private static final long serialVersionUID = 8346311255433349870L;

    /**
     * An OpenDataException with no detail message.
     */
    public OpenDataException() {
	super();
    }

    /**
     * An OpenDataException with a detail message.
     *
     * @param msg the detail message.
     */
    public OpenDataException(String msg) {
	super(msg);
    }

}
