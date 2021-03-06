/*
 * @(#)SwitchTree.java	1.2 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * Use and Distribution is subject to the Java Research License available
 * at <http://wwws.sun.com/software/communitysource/jrl.html>.
 */

package com.sun.source.tree;

import java.util.List;

/**
 * A tree node for a 'switch' statement.
 *
 * For example:
 * <pre>
 *   switch ( <em>expression</em> ) {
 *     <em>cases</em>
 *   }
 * </pre>
 *
 * @see "The Java Language Specification, 3rd ed, section 14.11"
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface SwitchTree extends StatementTree {
    ExpressionTree getExpression();
    List<? extends CaseTree> getCases();
}
