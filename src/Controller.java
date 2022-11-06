import java.util.ArrayList;

public class Controller {
    ArrayList<Cancion> arr = new ArrayList<>();
    static Ipod ip = new Ipod();
    public static void menu() throws Exception {
        int op = UI.initial();
        switch (op){
            case 1: ip.SwitchONOFF(ip.estado);
                break;
            case 2:
                if(ip.estado){
                    ip.LockUnlockDevice(ip.bloqueado);
                }else{
                    UI.err2();
                }
                break;
            case 3: if(ip.estado || !ip.bloqueado){
                float actualV = ip.getVolume();
                ip.setVolume((float) (actualV + 0.5));
            }else {
                UI.err3();
            }
                break;
            case 4:
                if(ip.estado || !ip.bloqueado){
                    float actualV = ip.getVolume();
                    ip.setVolume((float) (actualV - 0.5));
                }else {
                    UI.err3();
                }
                break;
            case 5:
                if(ip.estado || !ip.bloqueado){
                    int inex = ip.getActualIndex();
                    ip.Next(inex);
                }else{
                    UI.err3();
                }
                break;
            case 6:
                if(ip.estado || !ip.bloqueado){
                    int inex = ip.getActualIndex();
                    ip.Prev(inex);
                }else{
                    UI.err3();
                }
                break;
            case 7:
                if(ip.estado || !ip.bloqueado){
                    int inex = ip.getActualIndex();
                    Cancion can;
                    can = (Cancion) ip.selectSpecificSong(inex);
                    ip.addToFavorite(can);
                }else{
                    UI.err3();
                }
                break;
            case 8:
                if(ip.estado || !ip.bloqueado){
                    int ind = UI.requestFavoriteSong();
                    ip.selectSpecificFavoriteSong(ind);
                }else{
                    UI.err3();
                }
                break;
            case 9:
                if(ip.estado){
                    ip.getStatus(ip.estado,ip.bloqueado,true,ip.selectSpecificSong(ip.getActualIndex()));
                }else {
                    UI.err2();
                }
                break;
            default:
                UI.err1();
                break;
        }
        menu();
    }
    public static void addAllSongs() throws Exception {
        ip.addSongToList("Tranquilito","Gerardo Ortiz - Aleman","Tranquilito","2:50",1);
        ip.addSongToList("No me rajo","Hadrian","No no rajo","2:45",2);
        ip.addSongToList("By the Sword","iamjakehill","agressive phonk","3:50",3);
        ip.addSongToList("141 - Version banda","Banda MS","141","2:40",3);
        ip.addSongToList("Rocket","Bearded legend","Phonk","1:45",4);
        ip.addSongToList("Yakuza","do not resurrect","Phonk","2:53",5);
        ip.addSongToList("Guisao","Luis R Conriquez","Corridos","1:54",6);
        ip.addSongToList("Siempre pendientes","Peso pluma","Corridos","3:45",7);
        ip.addSongToList("Tiempos de Guerra","Yerai R","Corridos","2:45",8);
        ip.addSongToList("Money Rain","VTORNIK","PHONK","4:54",9);
        ip.addSongToList("Me gusta mi vida","Joan y su elite","Corridos","4:45",10);
    }
}
