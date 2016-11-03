package irdeto;

import java.util.ArrayList;
import java.util.List;

//import org.apache.log4j.Logger;

public class TestSearchInStringArray {

    private String[] catalogsInDST = { "Catalog_comp_SVOD_zip", "Catalog_comp_TVOD_zip" };

    private List<String> catalogsInUse = new ArrayList<>();

    public static void main(String[] args) {
        new TestSearchInStringArray().start();
    }

    void start() {

        String[] catalogsAdded = { "Catalog_comp_SVOD_zip", "Catalog_comp_TVOD_zip" };
        addCatalog(catalogsInDST[0]);
        System.out.println("Should be true=" + validateCatalogsCurrentlyInUse(catalogsInDST[0]));
        System.out.println("Should be false=" + validateCatalogsCurrentlyInUse(catalogsInDST[1]));

        removeCatalog(catalogsInDST[0]);
        System.out.println("\nShould be false=" + validateCatalogsCurrentlyInUse(catalogsInDST[0])+"\n");

        addCatalog(catalogsInDST[0]);
        addCatalog(catalogsInDST[1]);
        removeCatalog(catalogsInDST[0]);
        System.out.println("\nShould be false=" + validateCatalogsCurrentlyInUse(catalogsInDST[0]));
        System.out.println("Should be true=" + validateCatalogsCurrentlyInUse(catalogsInDST[1]));
    }

    private void addCatalog(String... catalogNames) {
        boolean catalogFound = false;
        for (String catalog : catalogNames) {
            catalogsInUse.add(catalog);
            System.out.println(catalog + " Catalog added list size=" + catalogsInUse.size());
        }
    }

    private void removeCatalog(String... catalogNames) {
        for (String catalog : catalogNames) {
            catalogsInUse.remove(catalog);
            System.out.println(catalog + " Catalog removed list size=" + catalogsInUse.size());
        }
    }

    public boolean validateCatalogsCurrentlyInUse(String... catalogNames) {
        boolean catalogsInUse = false;
        for (String catalog : catalogNames) {
            if (!findCatalogsCurrentlyInUse(catalog)) {
                return false;
            } else {
                catalogsInUse = true;
            }
        }
        return catalogsInUse;
    }

    /**
     * Will confirm if the passed in catalog name/s are in use
     * 
     * @param catalogName
     * @return
     */
    private boolean findCatalogsCurrentlyInUse(String catalogName) {
        boolean catalogFound = false;
        for (String catalog : catalogsInUse) {
            if (catalogName.equals(catalog)) {
                return true;
            }
        }
        return catalogFound;
    }

    /**
     * 
     * @param catalogNames
     * @return catalogAvailable
     */
    public boolean catalogsAvailable(String... catalogNames) {
        boolean catalogAvailable = false;
        for (String catalog : catalogNames) {
            if (!findCatalogInDST(catalog)) {
                return false;
            } else {
                catalogAvailable = true;
            }
        }
        return catalogAvailable;
    }

    private boolean findCatalogInDST(String catalogName) {
        boolean catalogFound = false;
        for (String catalog : catalogsInDST) {
            if (catalogName.equals(catalog)) {
                return true;
            }
        }
        return catalogFound;
    }
}
