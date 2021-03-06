/*
 * @(#)SUNVMCID.java	1.13 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.corba.se.impl.util;

/**
 * The vendor minor code ID reserved for Sun by the OMG.
 * All VMCIDs occupy the high order 20 bits.
 */

public interface SUNVMCID {

    /**
     * The vendor minor code ID reserved for Sun. This value is or'd with
     * the high order 20 bits of the minor code to produce the minor value
     * in a system exception.
     */
    static final int value = 0x53550000;
}
