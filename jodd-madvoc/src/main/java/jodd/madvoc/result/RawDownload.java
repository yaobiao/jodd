// Copyright (c) 2003-2014, Jodd Team (jodd.org). All Rights Reserved.

package jodd.madvoc.result;

import jodd.madvoc.MadvocException;
import jodd.madvoc.meta.RenderWith;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Download data for raw results.
 */
@RenderWith(RawResult.class)
public class RawDownload extends RawResultData {

	public RawDownload(InputStream inputStream, String downloadFileName, String mimeType, int length) {
		super(inputStream, downloadFileName, mimeType, length);
	}

	public RawDownload(byte[] bytes, String downloadFileName, String mimeType) {
		super(new ByteArrayInputStream(bytes), downloadFileName, mimeType, bytes.length);
	}

	public RawDownload(byte[] bytes, String downloadFileName) {
		this(bytes, downloadFileName, null);
	}

	public RawDownload(File file, String downloadFileName, String mimeType) {
		super(createFileInputStream(file), downloadFileName, mimeType, (int) file.length());
	}

	public RawDownload(File file, String mimeType) {
		super(createFileInputStream(file), file.getName(), mimeType, (int) file.length());
	}

	public RawDownload(File file) {
		this(file, null);
	}

	private static FileInputStream createFileInputStream(File file) {
		try {
			return new FileInputStream(file);
		} catch (FileNotFoundException fis) {
			throw new MadvocException(fis);
		}
	}

}
