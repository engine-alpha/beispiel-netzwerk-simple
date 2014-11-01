import ea.*;


/**
 * Ein sehr einfacher Broadcast-Server
 * 
 * @author Michael Andonie
 */
public class MeinBroadcastServer
implements Empfaenger
{
    /**
     * Der harte Basis-Server der Engine, der die Netzwerk-Arbeit übernimmt.
     */
    private Server server;
    
    /**
     * Der Konstruktor erstellt den Server automatisch auf Port 34567.
     * Außerdem wird das erstellte Objekt als globaler Empfänger gesetzt.
     */
    public MeinBroadcastServer() {
        //Server lauscht auf einem willkürlichen Port (> 1024).
        server = new Server(34567);
        
        //Dieses Objekt als Empfänger für alle Sendungen an den Server festlegen
        server.globalenEmpfaengerSetzen(this);
    }
    
    /* --- Empfaenger-Methoden --- */
 
    /**
     * Wird aufgerufen, wenn ein beliebiger Client an den Server einen String sendet.
     * 
     * Der Server führt hier einen kleinen Algorithmus aus:
     * - Ist die Länge der Eingabe gerade, sendet er die Länge der Eingabe an alle Clients.
     * - Ist die Länge der Eingabe ungerade, sendet er die Eingabe selbst an alle Clients.
     */
    @Override
    public void empfangeString (String string) {
        int laenge = string.length();
        if(laenge % 2 == 0) {
            //Laenge ist gerade
            server.sendeInt(laenge);
        } else {
            //Laenge ist ungerade
            server.sendeString(string);
        }
    }
 
    /**
     * Wird aufgerufen, wenn ein beliebiger Client die Verbindung zum Server
     * beendet.
     * 
     * Der Server informiert mit einer Standard-Nachricht alle (anderen) Clients
     * vom Verbindungsabbruch.
     */
    @Override
    public void verbindungBeendet () {
        server.sendeString("Info an alle: Ein Client hat gerade die Verbindung abgebrochen.");
    }
 
         // Info: Diese Methoden müssen implementiert werden.
         //       Sie bleiben leer, da sie hier nicht verwendet werden.
 
    @Override
    public void empfangeInt (int i) {
    }
 
    @Override
    public void empfangeByte (byte b) {
    }
 
    @Override
    public void empfangeDouble (double d) {
    }
 
    @Override
    public void empfangeChar (char c) {
    }
 
    @Override
    public void empfangeBoolean (boolean b) {
    }
}
