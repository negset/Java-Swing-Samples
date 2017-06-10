package sample4_image;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 画像の読み込みを行うクラス.
 */
public class LoadImage
{
	/**
	 * 与えられた場所の画像を読み込んで,
	 * Image 型で返す.
	 *
	 * @param path 画像ファイルの場所
	 * @return 読み込んだ画像
	 */
	public static Image load(String path)
	{
		Image img = null;
		try
		{
			FileInputStream fis = new FileInputStream(path);
			img = ImageIO.read(fis);
			fis.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return img;
	}
}
