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

package com.liferay.portlet.blogs.model.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Image;
import com.liferay.portal.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.webserver.WebServerServletTokenUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 * @author Juan Fernández
 */
public class BlogsEntryImpl extends BlogsEntryBaseImpl {

	@Override
	public String getCoverImageURL(ThemeDisplay themeDisplay)
		throws PortalException {

		long coverImageFileEntryId = getCoverImageFileEntryId();

		if (coverImageFileEntryId == 0) {
			return null;
		}

		FileEntry fileEntry = PortletFileRepositoryUtil.getPortletFileEntry(
			coverImageFileEntryId);

		return DLUtil.getPreviewURL(
			fileEntry, fileEntry.getFileVersion(), themeDisplay,
			StringPool.BLANK);
	}

	@Override
	public String getEntryImageURL(ThemeDisplay themeDisplay) {
		if (!isSmallImage()) {
			return null;
		}

		if (Validator.isNotNull(getSmallImageURL())) {
			return getSmallImageURL();
		}

		return
			themeDisplay.getPathImage() + "/blogs/entry?img_id=" +
				getSmallImageId() + "&t=" +
					WebServerServletTokenUtil.getToken(getSmallImageId());
	}

	@Override
	public String getSmallImageType() throws PortalException {
		if ((_smallImageType == null) && isSmallImage()) {
			Image smallImage = ImageLocalServiceUtil.getImage(
				getSmallImageId());

			_smallImageType = smallImage.getType();
		}

		return _smallImageType;
	}

	@Override
	public boolean isVisible() {
		Date displayDate = getDisplayDate();

		if (isApproved() && displayDate.before(new Date())) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void setSmallImageType(String smallImageType) {
		_smallImageType = smallImageType;
	}

	private String _smallImageType;

}