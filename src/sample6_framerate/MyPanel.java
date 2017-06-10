package sample6_framerate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

/**
 * メインの処理や描画を行うクラス.
 */
public class MyPanel extends JPanel implements Runnable
{
	/** 画面の幅を表す定数 */
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;

	/** フレームレート */
	public static final int frameRate = 60;

	Image imgBuf;
	Graphics gBuf;

	/** フレームカウンタ */
	int counter;

	long timer;

	/** 四角形の座標 */
	int x, y;

	/**
	 * コンストラクタ
	 */
	MyPanel()
	{
		// パネルサイズを設定する.
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		counter = 0;
		x = WIDTH / 2;
		y = HEIGHT / 2;

		// スレッドを作成し,開始する.
		Thread thread = new Thread(this);
		thread.start();
	}

	/**
	 * スレッドが開始されると,ここを通る.
	 */
	public void run()
	{
		// オフスクリーンバッファを作成する.
		while (imgBuf == null) imgBuf = createImage(WIDTH, HEIGHT);
		gBuf = imgBuf.getGraphics();

		long before, after, sleep;
		// メインループ
		for (;; counter++)
		{
			before = System.nanoTime();

			// オフスクリーンに描画
			render(gBuf);
			// 画面に描画
			paintScreen();
			// メイン処理
			update();

			after = System.nanoTime();

			sleep = 1000 / frameRate - (after - before) / 1000000L;

			try
			{
				if (sleep > 0) Thread.sleep(sleep);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	private void render(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		g.setColor(Color.black);
		g.drawString("フレームレートを一定にして、なめらかにアニメーションさせます。", 20, 20);

		// 四角形を赤色で描画する.
		g.setColor(Color.red);
		g.fillRect(x, y, 20, 20);
	}

	private void paintScreen()
	{
		// グラフィックインスタンスを取得する.
		Graphics g = getGraphics();
		if (g != null && gBuf != null)
		{
			// バッファイメージを画面に描画する.
			g.drawImage(imgBuf, 0, 0, null);
		}
		Toolkit.getDefaultToolkit().sync();
		if (g != null)
		{
			// グラフィックインスタンスを破棄する.
			g.dispose();
		}
	}

	/**
	 * メインの処理を行う. (座標の更新など)
	 */
	private void update()
	{
		// X座標を 2 ずつ増やす.
		// 右端まで来たら,左端に戻す.
		x = x < WIDTH ? x + 2 : -20;
	}
}
