/**
 * 
 */
package org.generationcp.ibpworkbench.navigation;

import java.lang.annotation.*;

/**
 * @author CyrusVenn
 *
 */
@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface DynamicViewType {
	ViewType type() default ViewType.MAIN_CONTENT;
}
