package sample5_sound;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * WAVEサウンドを読み込み,再生するクラス.
 */
public class Wave implements LineListener
{
	/** 再生するWAVEサウンド */
	private Clip clip;
	/** 再生中フラグ */
	private boolean playing;

	/**
	 * コンストラクタ
	 *
	 * @param path ファイルの場所
	 */
	Wave(String path)
	{
		try
		{
			// WAVE ファイルを読み込む.
			AudioInputStream ais;
			ais = AudioSystem.getAudioInputStream(new File(path));
			clip = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));

			// LineListener を登録する.
			clip.addLineListener(this);

			clip.open(ais);
		}
		catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
		{
			e.printStackTrace();
		}

		playing = false;
	}

	@Override
	public void update(LineEvent event)
	{
		// 停止または最後まで再生した場合
		if (event.getType() == LineEvent.Type.STOP)
		{
			clip.stop();
			// 再生位置を最初に戻す.
			clip.setFramePosition(0);

			playing = false;
		}
	}

	/**
	 * WAVEサウンドを再生する.
	 */
	void start()
	{
		if (!playing)
		{
			clip.start();
			playing = true;
		}
	}

	/**
	 * WAVEサウンドを停止する.
	 */
	void stop()
	{
		clip.stop();
	}

	/**
	 * WAVEサウンドを閉じて,メモリを開放する.
	 */
	void close()
	{
		clip.close();
	}

	/**
	 * WAVEサウンドが再生中かどうかを返す.
	 *
	 * @return 再生中かどうか
	 */
	boolean isPlaying()
	{
		return playing;
	}
}