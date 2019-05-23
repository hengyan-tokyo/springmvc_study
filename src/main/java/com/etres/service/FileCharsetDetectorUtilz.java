package jp.co.seiyu.sng.api.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.StringUtils;
import org.mozilla.universalchardet.UniversalDetector;

/**
 * 文字コードを判定するクラス.
 */
public class FileCharsetDetectorUtilz {

	/**
	 * 文字コードを判定するメソッド.
	 * 
	 * @param ファイルパス
	 * @return 文字コード
	 */
	public static String detector(File file) {
		String charSet = null;
		try (FileInputStream fis = new FileInputStream(file);) {
			charSet = detector(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return charSet;
	}

	/**
	 * 文字コードを判定するメソッド.
	 * 
	 * @param InputStream
	 * @return 文字コード
	 */
	public static String detector(InputStream ins) {

		byte[] buf = new byte[4096];
		String charSet = null;
		try {

			// 文字コード判定ライブラリの実装
			UniversalDetector detector = new UniversalDetector(null);

			// 判定開始
			int nread;
			while ((nread = ins.read(buf)) > 0 && !detector.isDone()) {
				detector.handleData(buf, 0, nread);
			}
			// 判定終了
			detector.dataEnd();

			// 文字コード判定
			charSet = detector.getDetectedCharset();

			// 判定の初期化
			detector.reset();

		} catch (IOException e) {

		} finally {
			try {
				ins.close();
			} catch (IOException e) {
			}
		}

		return StringUtils.isBlank(charSet) ? "UTF-8" : charSet;

	}

}