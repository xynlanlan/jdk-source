/*
 * @(#)Override.java	1.6 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.lang;

import java.lang.annotation.*;

/**
 * Indicates that a method declaration is intended to override a
 * method declaration in a superclass.  If a method is annotated with
 * this annotation type but does not override a superclass method,
 * compilers are required to generate an error message.
 *
 * @author  Joshua Bloch
 * @since 1.5
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Override {
}
