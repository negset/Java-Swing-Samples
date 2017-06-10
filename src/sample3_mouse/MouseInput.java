package sample3_mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * マウスの動作を受け取るためのクラス.
 * MouseListener, MouseMotionListener を実装している.
 */
public class MouseInput implements MouseListener, MouseMotionListener
{
	/** マウスの座標 */
	int mouseX, mouseY;

	/**
	 * コンストラクタ
	 */
	MouseInput()
	{
		// 最初は画面の中央にしておく.
		mouseX = MyPanel.WIDTH / 2;
		mouseY = MyPanel.HEIGHT / 2;
	}

	/**
	 * マウスがクリックされたとき呼び出される.
	 * (MouseListener)
	 */
	public void mouseClicked(MouseEvent e)
	{
	}

	/**
	 * マウスボタンが押されたとき呼び出される.
	 * (MouseListener)
	 */
	public void mousePressed(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}

	/**
	 * マウスボタンが離されたとき呼び出される.
	 * (MouseListener)
	 */
	public void mouseReleased(MouseEvent e)
	{
	}

	/**
	 * マウスカーソルがウィンドウに入ったとき呼び出される.
	 * (MouseListener)
	 */
	public void mouseEntered(MouseEvent e)
	{
	}

	/**
	 * マウスカーソルがウィンドウから出たとき呼び出される.
	 * (MouseListener)
	 */
	public void mouseExited(MouseEvent e)
	{
	}

	/**
	 * マウスがドラッグされたとき呼び出される.
	 * (MouseMotionListener)
	 */
	public void mouseDragged(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}

	/**
	 * マウスカーソルが動いたとき呼び出される.
	 * (MouseMotionListener)
	 */
	public void mouseMoved(MouseEvent e)
	{
	}
}