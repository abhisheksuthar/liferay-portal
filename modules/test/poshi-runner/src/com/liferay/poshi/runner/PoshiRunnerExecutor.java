/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.poshi.runner;

import com.liferay.poshi.runner.selenium.LiferaySelenium;
import com.liferay.poshi.runner.selenium.SeleniumUtil;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

/**
 * @author Karen Dang
 * @author Michael Hashimoto
 */
public class PoshiRunnerExecutor {

	public static void runSeleniumElement(Element element) throws Exception {
		List<Class> parameterClasses = new ArrayList<>();
		List<String> arguments = new ArrayList<>();

		String selenium = element.attributeValue("selenium");

		int parameterCount = PoshiRunnerContext.getSeleniumParameterCount(
			selenium);

		for (int i = 0; i < parameterCount; i++) {
			parameterClasses.add(String.class);

			String argument = element.attributeValue("argument" + (i + 1));

			arguments.add(argument);
		}

		Class clazz = _liferaySelenium.getClass();

		Method method = clazz.getMethod(
			selenium,
			parameterClasses.toArray(new Class[parameterClasses.size()]));

		method.invoke(clazz, arguments.toArray(new String[arguments.size()]));
	}

	private static final LiferaySelenium _liferaySelenium =
		SeleniumUtil.getSelenium();

}