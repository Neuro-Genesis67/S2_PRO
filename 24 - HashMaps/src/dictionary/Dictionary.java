package dictionary;

public interface Dictionary {
    /**
     * Returnerer elementet hørende til nøglen k. Hvis nøglen ikke findes,
     * returneres null
     */
    public Object get(Object key);

    /**
     * Returnerer om dictionary er tom.
     */
    public boolean isEmpty();

    /**
     * Indsætter objektet value med nøgle key i dictionary. Hvis key allerede
     * eksisterer, overskrives value hørende til den key, og den gamle value
     * returneres. Hvis key ikke findes, returneres null. Hverken key eller
     * value må være null
     */
    public Object put(Object key, Object value);

    /**
     * Fjerner (nøgle, værdi)-parret med nøglen key fra dictionary'en og
     * value returneres. Hvis key ikke findes, returneres null.
     */
    public Object remove(Object key);

    /**
     * Returnerer antallet af elementer i dictionary
     */
    public int size();
}

