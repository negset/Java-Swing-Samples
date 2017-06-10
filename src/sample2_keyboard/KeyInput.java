package sample2_keyboard;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
	/** キーの状態を保持しておくためのフラグ */
	boolean keyLeft;
	boolean keyRight;
	boolean keyUp;
	boolean keyDown;

	/**
	 * コンストラクタ
	 */
	KeyInput()
	{
		keyLeft = false;
		keyRight = false;
		keyUp = false;
		keyDown = false;
	}

	/**
	 * キーがタイプされたときに呼び出される.
	 */
	public void keyTyped(KeyEvent e)
	{
	}

	/**
	 * キーが押されたときに呼び出される.
	 */
	public void keyPressed(KeyEvent e)
	{
		// 押されたキーで分岐する.
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_LEFT:
				keyLeft = true;
				break;
			case KeyEvent.VK_RIGHT:
				keyRight = true;
				break;
			case KeyEvent.VK_UP:
				keyUp = true;
				break;
			case KeyEvent.VK_DOWN:
				keyDown = true;
				break;
		}
	}

	/**
	 * キーが離されたときに呼び出される.
	 */
	public void keyReleased(KeyEvent e)
	{
		// 離されたキーで分岐する.
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_LEFT:
				keyLeft = false;
				break;
			case KeyEvent.VK_RIGHT:
				keyRight = false;
				break;
			case KeyEvent.VK_UP:
				keyUp = false;
				break;
			case KeyEvent.VK_DOWN:
				keyDown = false;
				break;
		}
	}
}
