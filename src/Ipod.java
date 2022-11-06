import java.util.ArrayList;

public class Ipod implements IIpod_simulator{

    private float volumen = 0;
    private int index = 0;
    public ArrayList<Cancion> canciones = new ArrayList<>();
    public ArrayList<Cancion> fav = new ArrayList<>();

    public boolean estado = false;
    public boolean bloqueado = true;

    /***
     * Este m�todo enciende / Apaga el dispositivo, recibe una variable booleana
     * que tiene el estado actual del dispositivo
     * @param actual_state el estado actual del dispositivo
     * @return el estado futuro del dipositivo
     */
    @Override
    public boolean SwitchONOFF(boolean actual_state) {
        if (actual_state){
            this.estado = false;
        }else{
            this.estado = true;
        }
        return true;
    }

    /***
     * Este m�todo bloquea / Desblocquea el dispositivo, para que no se ejecute ninguna
     * acci�n cuando est� bloqueado
     * @param actual_locked_state estado de bloqueo actual del dispositivo
     * @return estado de bloqueo futuro del dispositivo
     */
    @Override
    public boolean LockUnlockDevice(boolean actual_locked_state) {
        if(actual_locked_state){
            this.bloqueado = false;
        }else{
            this.bloqueado = true;
        }
        return true;
    }

    /***
     * Obtiene el volumen actual
     * @return valor que indica el volumen actual
     */
    @Override
    public float getVolume() {
        return volumen;
    }

    /***
     * Establece el volumen actual
     * @param volume
     * @return
     */
    @Override
    public float setVolume(float volume) {
        this.volumen = volume;
        return 0;
    }

    /***
     * Atrasar una cancion en la lista y la devuelve
     * @param actual_index el indice actual
     * @return el nuevo indice
     */
    @Override
    public int Prev(int actual_index) {
        if(actual_index == 0){
            //ERROR NO HAY CANCIONES PREVIAS
            return -1001;
        }
        else{
            this.index = actual_index - 1;
            return actual_index - 1;
        }
    }

    /***
     * Avanza una cancion en la lista y la devuelve
     * @param actual_index el indice actual
     * @return el nuevo indice
     */
    @Override
    public int Next(int actual_index) {
        if(actual_index == 49){
            //ERROR MAX CANCIONES
            return -2002;
        }
        else{
            this.index = actual_index + 1;
            return actual_index + 1;
        }
    }

    /***
     * Obtiene el indice actual de la cancion que se esta ejecutando
     * @return el indice actual
     */
    @Override
    public int getActualIndex() {
        return index;
    }

    /***
     * Establece el indice Actual
     * @param actual_index
     * @exception Exception Cuando el indice esta fuera de rango
     */
    @Override
    public void setActualIndex(int actual_index) throws Exception {
        if(actual_index < 50){
            this.index = actual_index;
        }else{
            throw new Exception("LIMITE DE CANCIONES ALCANZADA");
        }
    }

    /**
     * Este metodo guarda una cancion en listado de favoritos
     *
     * @param _song la cancion que se desea guardar
     * @throws Exception cuando la lista ya esta llena
     */
    @Override
    public void addToFavorite(ICancion _song) throws Exception {
        if(fav.size() < 10){
            fav.add((Cancion) _song);
        }
        else{
            throw new Exception("LISTA DE CANCIONES FAVORITAS LLENA");
        }
    }

    /***
     * Devolvera una cancion especifica del listado general
     * @param index el indice en el que se encuentra la cancion
     * @return El objeto Cancion
     * @exception Exception Cuando el indice esta fuera de rango
     */
    @Override
    public ICancion selectSpecificSong(int index) throws Exception {
        if(index < canciones.size()){
            return canciones.get(index);
        }
        else{
            throw new Exception("INDEX FUERA DE RANGO");
        }
    }

    /***
     * Devolvera una cancion especifica del listado de las favoritas
     * @param index el indice en el que se encuentra la cancion
     * @return El objeto Cancion
     * @exception Exception Cuando el indice esta fuera de rango
     */
    @Override
    public ICancion selectSpecificFavoriteSong(int index) throws Exception {
        if(index < fav.size()){
            this.index = index;
            return fav.get(index);
        }
        else{

            throw new Exception("INDEX FUERA DE RANGO");
        }
    }

    /**
     * Este metodo devuelve el listado completo de canciones
     *
     * @return el listado de canciones
     */
    @Override
    public ICancion[] getAllSongs() {
        ICancion[] ic = new ICancion[50];
        for(int i=0; i<=canciones.size(); i++){
            ic[i] = canciones.get(i);
        }
        return ic;
    }

    /***
     * ESte metodo devuelve el estado general del ipod
     * @param _isON valor logico que indica si esta encendido o apagado
     * @param _isLocked valor logico que indica si esta bloqueado o desbloqueado
     * @param _isPlaying valor logico que indica si esta sonando una cancion o no
     * @param _actualSong valor que indica que cancion esta sonando
     * @return Un cadena que contien e el estado de la informacion
     */
    @Override
    public String getStatus(boolean _isON, boolean _isLocked, boolean _isPlaying, ICancion _actualSong) {
        String estado = "Volumen: "+ this.volumen+" Estado: ";

        if(_isON){
            estado = estado + "Encendido, ";
        }else {
            estado = estado + " Apagado, ";
            return estado;
        }

        if(_isLocked){
            estado = estado + " Bloqueado, ";
        }else {
            estado = estado + " Desbloqueado, ";
        }

        if(_isPlaying){
            estado = estado + " Reproduciendo: "+ _actualSong.getTitle() + " Del artista: "+_actualSong.getArtist()+" del album: "+_actualSong.getAlbum()+" Duracion: "+_actualSong.getDuration();
        }else{
            estado = estado + "sin reproducir nada";
        }
        return estado;
    }

    /***
     * Verifica si un indice es valido o no
     * @param index el indice que se desea verificar
     * @return true si el indice contiene cancion, false de lo cointrario
     */
    @Override
    public boolean isValidIndex(int index) {
        if(index <= canciones.size()){
            return true;
        }else {
            return false;
        }
    }

    /***
     * Se agrega una cancion para ser instanciada en el metodo y agregada a la lista
     * @param _titulo titulo de la cancion
     * @param _artista artista de la cancion
     * @param _album album de la cancion
     * @param _duracion duracion de la cancion
     * @param _id id de la cancion
     * @exception Exception si el listado esta lleno
     */
    @Override
    public void addSongToList(String _titulo, String _artista, String _album, String _duracion, int _id) throws Exception {
        if(canciones.size() < 50){
            Cancion cn = new Cancion();
            cn.setTitle(_titulo);
            cn.setAlbum(_album);
            cn.setArtist(_artista);
            cn.setDuration(_duracion);
            cn.setID(_id);
            canciones.add(cn);
        }else{
            throw new Exception("LIMITE MAXIMO DE CANCIONES ALCANZADAS");
        }

    }

    /**
     * Este metodo elimina una cancion de una posicion determinada
     *
     * @param index indice de la cancion a eliminar
     * @throws Exception Cuando el indice esta fuera de rango
     */
    @Override
    public void deleteSongFromList(int index) throws Exception {
        if(index <= canciones.size()){
            canciones.remove(index);
        }else{
            throw new Exception("INDICE FUERA DE RANGO");
        }
    }

    /**
     * Elimina una cancion de la lista de favoritas pero no del listado general
     *
     * @param index
     * @throws Exception Cuando el indice esta fuera de rango
     */
    @Override
    public void deleteSongFromTop10(int index) throws Exception {
        if(index <= fav.size()){
            fav.remove(index);
        }else{
            throw new Exception("INDICE FUERA DE RANGO");
        }
    }
}
