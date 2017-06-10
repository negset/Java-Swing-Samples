package sample1_window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * メインの処理や描画を行うクラス.
 */
public class MyPanel extends JPanel implements Runnable
{
	/** 画面の幅を表す定数 */
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;

	/** フレームカウンタ */
	int counter;

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
		// メインループ
		for (;; counter++)
		{
			// メイン処理
			update();
			// 画面の描画
			repaint();

			try
			{
				// スレッドを20ミリ秒間だけ停止する.
				Thread.sleep(20);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * メインの処理を行う.
	 * (座標の更新など)
	 */
	public void update()
	{
		// X座標を2ずつ増やす.
		// 右端まで来たら,左端に戻す.
		x = x < WIDTH ? x + 2 : -20;
	}

	/**
	 * 画面の描画を行う.
	 * repaint() を呼び出すと,ここを通る.
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		// 画面を白色で塗りつぶす.
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		g.setColor(Color.black);
		g.drawString("ウィンドウを作って画面に表示します。", 20, 20);

		// 四角形を赤色で描画する.
		g.setColor(Color.red);
		g.fillRect(x, y, 20, 20);
	}
}
