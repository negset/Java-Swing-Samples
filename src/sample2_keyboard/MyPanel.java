package sample2_keyboard;

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

	/** キーボード入力の受け取り用 */
	KeyInput keyInput;

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
		// パネルがキーボード入力を受け付けるようにする.
		setFocusable(true);

		// キーボード入力を読み取れるようにする.
		keyInput = new KeyInput();
		addKeyListener(keyInput);

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
		if (keyInput.keyLeft)
			x -= 3;
		if (keyInput.keyRight)
			x += 3;
		if (keyInput.keyUp)
			y -= 3;
		if (keyInput.keyDown)
			y += 3;
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
		g.drawString("キーボードで ←↑↓→ を入力すると、四角形が移動します。", 20, 20);

		// 四角形を赤色で描画する.
		g.setColor(Color.red);
		g.fillRect(x, y, 20, 20);
	}
}
