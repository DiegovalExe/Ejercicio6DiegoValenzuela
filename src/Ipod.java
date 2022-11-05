public class Ipod implements IIpod_simulator{

    private float volumen;

    /***
     * Este m�todo enciende / Apaga el dispositivo, recibe una variable booleana
     * que tiene el estado actual del dispositivo
     * @param actual_state el estado actual del dispositivo
     * @return el estado futuro del dipositivo
     */
    @Override
    public boolean SwitchONOFF(boolean actual_state) {
        if (actual_state){
            return false;
        }else{
            return true;
        }
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
            return false;
        }else{
            return true;
        }
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
     * Adelanta una cancion en la lista y la devuelve
     * @param actual_index el indice actual
     * @return el nuevo indice
     */
    @Override
    public int Prev(int actual_index) {
        return 0;
    }

    /***
     * Regresa una cancion en la lista y la devuelve
     * @param actual_index el indice actual
     * @return el nuevo indice
     */
    @Override
    public int Next(int actual_index) {
        return 0;
    }

    /***
     * Obtiene el indice actual de la cancion que se esta ejecutando
     * @return el indice actual
     */
    @Override
    public int getActualIndex() {
        return 0;
    }

    /***
     * Establece el indice Actual
     * @param actual_index
     * @exception Exception Cuando el indice esta fuera de rango
     */
    @Override
    public void setActualIndex(int actual_index) throws Exception {

    }

    /**
     * Este metodo guarda una cancion en listado de favoritos
     *
     * @param _song la cancion que se desea guardar
     * @throws Exception cuando la lista ya esta llena
     */
    @Override
    public void addToFavorite(ICancion _song) throws Exception {

    }

    /***
     * Devolvera una cancion especifica del listado general
     * @param index el indice en el que se encuentra la cancion
     * @return El objeto Cancion
     * @exception Exception Cuando el indice esta fuera de rango
     */
    @Override
    public ICancion selectSpecificSong(int index) throws Exception {
        return null;
    }

    /***
     * Devolvera una cancion especifica del listado de las favoritas
     * @param index el indice en el que se encuentra la cancion
     * @return El objeto Cancion
     * @exception Exception Cuando el indice esta fuera de rango
     */
    @Override
    public ICancion selectSpecificFavoriteSong(int index) throws Exception {
        return null;
    }

    /**
     * Este metodo devuelve el listado completo de canciones
     *
     * @return el listado de canciones
     */
    @Override
    public ICancion[] getAllSongs() {
        return new ICancion[0];
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
        return null;
    }

    /***
     * Verifica si un indice es valido o no
     * @param index el indice que se desea verificar
     * @return true si el indice contiene cancion, false de lo cointrario
     */
    @Override
    public boolean isValidIndex(int index) {
        return false;
    }

    /***
     * Se agrega una cancion para ser instanciada en el metodo y agregada a la lista
     * @param _titulo
     * @param _artista
     * @param _album
     * @param _duracion
     * @param _id
     * @exception Exception si el listado esta lleno
     */
    @Override
    public void addSongToList(String _titulo, String _artista, String _album, String _duracion, int _id) throws Exception {

    }

    /**
     * Este metodo elimina una cancion de una posicion determinada
     *
     * @param index
     * @throws Exception Cuando el indice esta fuera de rango
     */
    @Override
    public void deleteSongFromList(int index) throws Exception {

    }

    /**
     * Elimina una cancion de la lista de favoritas pero no del listado general
     *
     * @param index
     * @throws Exception Cuando el indice esta fuera de rango
     */
    @Override
    public void deleteSongFromTop10(int index) throws Exception {

    }
}
