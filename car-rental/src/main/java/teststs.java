public class TestSTS {
    private String chaine = "hello"; // Déclaration correcte de la chaîne

    @Override
    public String toString() { // Correction de la signature de la méthode
        return chaine; // Retourne la chaîne définie dans la classe
    }

    public static void main(String[] args) { // Méthode main pour tester
        TestSTS test = new TestSTS();
        System.out.println(test.toString()); // Affiche la chaîne
    }
}
