package de.hft_stuttgart.unittest.loader;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Peter Heusch
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface Skeleton {
}
