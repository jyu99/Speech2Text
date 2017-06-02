package com.jyu7499.speechtotext;

import android.app.Service;
import android.content.Intent;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class AudioService extends Service {

    AudioTrack mAudio;
    private String TAG = "AudioService";
    AudioServiceHandler mAudioServiceHandler;
    HandlerThread handlerThread;

    public AudioService() {


    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate");
        handlerThread = new HandlerThread("SerivceThread");
        handlerThread.start();
        mAudioServiceHandler = new AudioServiceHandler(handlerThread.getLooper());
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Message msg = mAudioServiceHandler.obtainMessage();

        msg.what = intent.getIntExtra(IPCConstant.SERVICE_COMMAND,-1);
        mAudioServiceHandler.sendMessage(msg);

        //return super.onStartCommand(intent, flags, startId);
        return START_NOT_STICKY;
    }

    private final class AudioServiceHandler extends Handler {

        public AudioServiceHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == IPCConstant.AUDIO_PLAY_REQ) {
                Log.d(TAG, "AUDIO_PLAY_REQ");
//                int bufsize = AudioTrack.getMinBufferSize(16000, AudioFormat.CHANNEL_OUT_MONO,AudioFormat.ENCODING_PCM_16BIT);
//
//                mAudio = new AudioTrack(AudioManager.STREAM_MUSIC,
//                        16000, //sample rate
//                        AudioFormat.CHANNEL_OUT_MONO, //1 channel
//                        AudioFormat.ENCODING_PCM_16BIT, // 16-bit
//                        bufsize,
//                        AudioTrack.MODE_STREAM );
//                mAudio.play();
//                mAudio.write();


            }
            if (msg.what == IPCConstant.AUDIO_PAUSE_REQ) {
                Log.d(TAG, "AUDIO_PLAY_REQ");


            }
            if (msg.what == IPCConstant.AUDIO_STOP_REQ) {
                Log.d(TAG, "AUDIO_PLAY_REQ");

            }
        }//end of private final class AudioServiceHandler extends Handler

    }
}
