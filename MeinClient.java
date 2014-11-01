import ea.*;

/**
 * Der Client kann beliebige String-Nachrichten an den Broadcast-Server schicken.
 * 
 * @author Michael Andonie
 */
public class MeinClient
extends Client {
    
    /**
     * Erstellt einen Client, der immer an Port 34567 nach dem Server sucht
     * (damit stimmen die Portnummern von Server und Client überein).
     * 
     * @param ipAdresse Die IP-Adresse des Servers, zu dem dieser Client eine
     *                  Verbindung aufbauen soll. (z.B. "192.168.0.2")
     */
    public MeinClient(String ipAdresse) {
        super(ipAdresse, 34567);
    }
    
    /**
     * Sendet eine Nachricht an den Server. Dies wird über die Methode
     * <code>sendeString(String)</code> umgesetzt.
     * @param nachricht Eine beliebige Nachricht an den Server als String.
     */
    public void sendeNachrichtAnServer(String nachricht) {
        super.sendeString(nachricht);
    }
    
    /**
     * Diese Methode wird immer dann aufgerufen, wenn der Server einen
     * Integer-Wert aussendet.
     * @param   i   Der Integer-Wert, den der Server gesendet hat.
     */
    @Override
    public void empfangeInt(int i) {
        System.out.println("[Integer empfangen:] " + i);
    }
    
    /**
     * Diese Methode wird immer dann aufgerufen, wenn der Server einen
     * String-Wert aussendet.
     * @param   string   Der String-Wert, den der Server gesendet hat.
     */
    @Override
    public void empfangeString(String string) {
        System.out.println("[String empfangen:] " + string);
    }
}
