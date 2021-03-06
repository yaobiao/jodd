// Copyright (c) 2003-2014, Jodd Team (jodd.org). All Rights Reserved.

package jodd.madvoc.meta;

import jodd.madvoc.filter.ActionFilter;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines array of action filters. May be used on whole class and all action methods,
 * or on single method overriding class default value.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface FilteredBy {

	/**
	 * Array of action filters.
	 */
	Class<? extends ActionFilter>[] value();

}