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

package com.liferay.portal.service;

import aQute.bnd.annotation.ProviderType;

/**
 * Provides a wrapper for {@link PortalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PortalService
 * @generated
 */
@ProviderType
public class PortalServiceWrapper implements PortalService,
	ServiceWrapper<PortalService> {
	public PortalServiceWrapper(PortalService portalService) {
		_portalService = portalService;
	}

	@Override
	public java.lang.String getAutoDeployDirectory() {
		return _portalService.getAutoDeployDirectory();
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _portalService.getBeanIdentifier();
	}

	@Override
	public int getBuildNumber() {
		return _portalService.getBuildNumber();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_portalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public void testAddClassNameAndTestTransactionPortletBar_PortalRollback(
		java.lang.String transactionPortletBarText) {
		_portalService.testAddClassNameAndTestTransactionPortletBar_PortalRollback(transactionPortletBarText);
	}

	@Override
	public void testAddClassNameAndTestTransactionPortletBar_PortletRollback(
		java.lang.String transactionPortletBarText) {
		_portalService.testAddClassNameAndTestTransactionPortletBar_PortletRollback(transactionPortletBarText);
	}

	@Override
	public void testAddClassNameAndTestTransactionPortletBar_Success(
		java.lang.String transactionPortletBarText) {
		_portalService.testAddClassNameAndTestTransactionPortletBar_Success(transactionPortletBarText);
	}

	@Override
	public void testAddClassName_Rollback(java.lang.String classNameValue) {
		_portalService.testAddClassName_Rollback(classNameValue);
	}

	@Override
	public void testAddClassName_Success(java.lang.String classNameValue) {
		_portalService.testAddClassName_Success(classNameValue);
	}

	@Override
	public void testAutoSyncHibernateSessionStateOnTxCreation() {
		_portalService.testAutoSyncHibernateSessionStateOnTxCreation();
	}

	@Override
	public void testDeleteClassName()
		throws com.liferay.portal.kernel.exception.PortalException {
		_portalService.testDeleteClassName();
	}

	@Override
	public int testGetBuildNumber() {
		return _portalService.testGetBuildNumber();
	}

	@Override
	public void testGetUserId() {
		_portalService.testGetUserId();
	}

	@Override
	public boolean testHasClassName() {
		return _portalService.testHasClassName();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	@Deprecated
	public PortalService getWrappedPortalService() {
		return _portalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	@Deprecated
	public void setWrappedPortalService(PortalService portalService) {
		_portalService = portalService;
	}

	@Override
	public PortalService getWrappedService() {
		return _portalService;
	}

	@Override
	public void setWrappedService(PortalService portalService) {
		_portalService = portalService;
	}

	private PortalService _portalService;
}