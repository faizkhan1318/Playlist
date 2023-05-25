import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class Playlist {
    private String title;
    private List<Song> songs;
    private boolean wasNext=true;
    private ListIterator<Song> itr;

    public Playlist(String title) {
        this.title = title;
        this.songs = new ArrayList<>();//so we are firt taking a empty list then add song
        itr = songs.listIterator();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Song> getSongs() {
        return songs;
    }
    //add song from album in playlist
    public String addSongFromAlbum(Album album, String songName){
//        Boolean songExist = album.findSong(songName);
//        if(songExist){
//            album.searchSong(songName);
//        }
        Optional<Song> songOpt = album.searchSong(songName);
        if(songOpt.isEmpty()){//!songOpt.isPresent
            return "song not found in Album";
        }
        Song songInAlbum=songOpt.get();
        this.songs.add(songInAlbum);
        itr = songs.listIterator(); // update my list
        return "song added successfully";
    }
    public String playNext(){
        if(wasNext){

        }
        if(!wasNext){
            wasNext=true;
            itr.next();
        }
        if(itr.hasNext()){
            wasNext=true;
            Song song = itr.next();
            return "Next Song" + song;
        }
        return "playlist is ended";
    }

    public String playPrev(){
        if(!wasNext){

        }
        if(wasNext){
            wasNext=false;
            itr.next();
        }
        if(itr.hasPrevious()){
            wasNext=false;
            Song song = itr.previous();
            return "Next Song" + song;
        }
        return "playlist is ended";
    }
    public String currentSong(){
        if(wasNext){
            wasNext = false;
            return  "Current song is" + itr.previous();
        }
        wasNext = true;
        return "Current song is" + itr.next();
    }
}
