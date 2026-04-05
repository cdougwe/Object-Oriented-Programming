interface IMyMediaPlayer {
    void open(String fn);
    void play();
    void stop();
    void close();
}

class Midi {
    public void openMidi(String filename) {
        System.out.println(" Open Midi file: " + filename);
    }
    public void playMidi() {
        System.out.println(" Play Midi Music.... ");
    }
    public void stopMidi() {
        System.out.println(" Stop Midi Music.... ");
    }
    public void closeMidi() {
        System.out.println(" Close Midi Music.... ");
    }
}

class MP3 {
    public void openMP3(String filename) {
        System.out.println(" Open MP3 file: " + filename);
    }
    public void playMP3() {
        System.out.println(" Play MP3 Music.... ");
    }
    public void stopMP3() {
        System.out.println(" Stop MP3 Music.... ");
    }
}

class WAV {
    public void openWAV(String filename) {
        System.out.println(" Open Wav file: " + filename);
    }
    public void playWAV() {
        System.out.println(" Play Wav Music.... ");
    }
    public void stopWAV() {
        System.out.println(" Stop Wav Music.... ");
    }
    public void closeWAV() {
        System.out.println(" Close Wav Music.... ");
    }

}

class AdapterForMP3 implements IMyMediaPlayer {
    private MP3 mp3 = new MP3();

    @Override
    public void open(String fn) {
        mp3.openMP3(fn);
    }
    @Override
    public void play() {
        mp3.playMP3();
    }
    @Override
    public void stop() {
        mp3.stopMP3();
    }
    @Override
    public void close() {
    }
}

class AdapterForMidi implements IMyMediaPlayer {
    private Midi midi = new Midi();

    @Override
    public void open(String fn) {
        midi.openMidi(fn);
    }
    @Override
    public void play() {
        midi.playMidi();
    }
    @Override
    public void stop() {
        midi.stopMidi();
    }
    @Override
    public void close() {
        midi.closeMidi();
    }

}

class AdapterForWAV implements IMyMediaPlayer {
    private WAV wav = new WAV();

    @Override
    public void open(String fn) {
        wav.openWAV(fn);
    }
    @Override
    public void play() {
        wav.playWAV();
    }
    @Override
    public void stop() {
        wav.stopWAV();
    }
    @Override
    public void close() {
        wav.closeWAV();
    }
}

public class Test {
    public void playMusic(String fn, IMyMediaPlayer player) {
        player.open(fn);
        player.play();
        try {
            Thread.sleep(3000); // 暫停3秒
        } catch (Exception e) {
        }
        player.stop();
        player.close();
    }
    public static void main(String[] args) {
        Test tt = new Test();
        // play MP3 music
        tt.playMusic("mp3sound.mp3", new AdapterForMP3());
        // play Midi music
        tt.playMusic("midi.mid", new AdapterForMidi());
        // play WAV music
        tt.playMusic("wavsound.wav", new AdapterForWAV());
    }
}