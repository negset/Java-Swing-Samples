package sample4_image;

import javax.swing.JFrame;

public class Main extends JFrame
{
	/**
	 * コンストラクタ
	 */
	Main()
	{
		// ウィンドウのタイトルを設定する.
		setTitle("Sample4 画像の表示");
		// ウィンドウサイズの変更を不可にする.
		setResizable(false);

		// パネルを生成し,フレームに追加する.
		MyPanel panel = new MyPanel();
		getContentPane().add(panel);

		// ウィンドウのサイズを適用する.
		pack();

		// ウィンドウを閉じたときの動作.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ウィンドウを表示する.
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new Main();
	}
}
