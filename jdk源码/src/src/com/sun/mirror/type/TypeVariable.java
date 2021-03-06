/*
 * @(#)TypeVariable.java	1.2 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc.  All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 */

package com.sun.mirror.type;


import com.sun.mirror.declaration.*;


/**
 * Represents a type variable.
 * A type variable is declared by a
 * {@linkplain TypeParameterDeclaration type parameter} of a
 * type, method, or constructor.
 *
 * @author Joe Darcy
 * @author Scott Seligman
 * @version 1.2 05/11/17
 * @since 1.5
 */

public interface TypeVariable extends ReferenceType {

    /**
     * Returns the type parameter that declared this type variable.
     *
     * @return the type parameter that declared this type variable
     */
    TypeParameterDeclaration getDeclaration();
}
