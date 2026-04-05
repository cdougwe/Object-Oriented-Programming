enum PlayerType {
    MP3, MIDI, WAV;
}

interface IPlayerAdapter {
    void open(String filename);
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
    public void closeMP3() {
        System.out.println(" Close MP3 Music.... ");
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

class AdapterForMidi implements IPlayerAdapter {
    private Midi m = new Midi();

    public void open(String filename) {
        m.openMidi(filename);
    }
    public void play() {
        m.playMidi();
    }
    public void stop() {
        m.stopMidi();
    }
    public void close() {
        m.closeMidi();
    }
}

class AdapterForMP3 implements IPlayerAdapter {
    private MP3 mp = new MP3();

    public void open(String filename) {
        mp.openMP3(filename);
    }
    public void play() {
        mp.playMP3();
    }
    public void stop() {
        mp.stopMP3();
    }
    public void close() {
        mp.closeMP3();
    }
}

class AdapterForWAV implements IPlayerAdapter {
    private WAV w = new WAV();

    public void open(String filename) {
        w.openWAV(filename);
    }
    public void play() {
        w.playWAV();
    }
    public void stop() {
        w.stopWAV();
    }
    public void close() {
        w.closeWAV();
    }
}

class GeneralMusicPlayer {
    protected IPlayerAdapter iAdapter;

    public GeneralMusicPlayer(IPlayerAdapter iPlayerAdapter) {
        this.iAdapter = iPlayerAdapter;
    }

    public final void start(String filename) {
        iAdapter.open(filename);
        iAdapter.play();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        iAdapter.stop();
        iAdapter.close();
    }
}

class MusicPlayerFactory {
    public GeneralMusicPlayer getPlayerType(String type) {
        if (type == null) {
            throw new IllegalArgumentException("PlayerType can not be a null value");
        }
        try {
            PlayerType playerType = PlayerType.valueOf(type.toUpperCase());
            IPlayerAdapter iPlayerAdapter = switch (playerType) {
                case MP3 -> new AdapterForMP3();
                case MIDI -> new AdapterForMidi();
                case WAV -> new AdapterForWAV();
            };
            return new GeneralMusicPlayer(iPlayerAdapter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unsuported type : " + type);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MusicPlayerFactory musicPlayerFactory = new MusicPlayerFactory();
        GeneralMusicPlayer player = musicPlayerFactory.getPlayerType("wav");
        player.start("wavsound.wav"); // 撥放音樂一段時間，然後關閉檔案

        player = musicPlayerFactory.getPlayerType("MP3");
        player.start("mp3sound.mp3"); // 撥放音樂一段時間，然後關閉檔案

        player = musicPlayerFactory.getPlayerType("Midi");
        player.start("midi.mid"); // 撥放音樂一段時間，然後關閉檔案
    }
}