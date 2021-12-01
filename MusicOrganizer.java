import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     *
     *  ----------------------------------------------------
     * | ESTO NO SE DEBE HACER, YA QUE OCURRE UNA EXCEPCIÓN |
     * | ELIMINANDO ARCHIVOS A TRAVÉS DE UN BUCLE FOR-EACH  |
     *  ----------------------------------------------------
     *  
     *  
     * Borra todas las canciones del organizador que contengan el
     * texto indicado usando un bucle for-each
     * 
     * @param searchString

    public void deleteSongWithText(String searchString) {
        boolean error = true;
        for (String filename : files) {
                if(filename.contains(searchString)) {
                    files.remove(filename);
                    error = false;
                }
            }
            if(error) {
                System.out.println("No hay resultados que eliminar con esta búsqueda");
            }
        }
    }

    */

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * List all files.
     */
    public void listAllFiles() {
        int i = 0;
        while(i < files.size()) {
            System.out.println((i + 1) + ". " + files.get(i));
            i++;
        }
    }

    /**
     * List files with the string as parameter
     */
    public void listMatching(String searchString) {
        boolean error = true;
        for (String filename : files) {
            if(filename.contains(searchString)) {
                System.out.println(filename);
                error = false;
            }
        }
        if(error) {
            System.out.println("No hay resultados con esta búsqueda");
        }
    }

    /**
     * Reproduce los primeros segundos de todas la canciones
     * de un determinado artista
     */
    public void playSamplesArtist(String artist) {
        for(String filename : files) {
            if(filename.contains(artist)) {
                player.playSample(filename);
            }
        }
    }

    /**
     * Localiza el índice del primer archivo que contiene
     * la cadena de búsqueda indicada .
     * @param searchString La cadena que hay que buscar.
     * @return El índice de la primera aparición o -1 si
     * no se encuentra ninguna correspondencia
     */
    public int findFirst(String searchString) {
        boolean searching = true;
        int i = 0;
        int result = -1;
        int colection = files.size();
        while(searching && i < colection) {
            String filename = files.get(i);
            if(filename.contains(searchString)) {
                result = i;
                searching = false;
           }
           i++;
        }
        return result;
    }
}