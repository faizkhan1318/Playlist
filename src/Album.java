import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Album {
    private String artist;
    private String title;
    private List<Song> songs;


    public Album(String artist, String title) {
        this.artist = artist;
        this.title = title;
        this.songs=new ArrayList<>();
    }
    public Album(String artist, String title, List<Song> songs) {
        this.artist = artist;
        this.title = title;
        this.songs= songs;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public String addSong(Song song){
        if(this.findSong(song)){
            return "song is already exists";
        }
        this.songs.add(song);
        return "song added";
    }

    private boolean findSong(Song songToFind) {
        for(Song song : songs){
            if(song.getName().equals(songToFind.getName()) && song.getArtist().equals(songToFind.getArtist())){
                return true;
            }
        }
        return false;
    }
    public boolean findSong(String songName){
        for(Song song : songs){
            if(song.getName().equals(songName)){
                return true;
            }
        }
        return false;
    }

    public Optional<Song> searchSong(String songName) {
        for(Song song:songs){
            if(song.getName().equals(songName)){
                return Optional.of(song);
            }
        }
        return Optional.empty();
    }
}
