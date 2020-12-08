package repository;

import net.ravendb.client.documents.DocumentStore;
import net.ravendb.client.documents.IDocumentStore;

// 'DocumentStore' is a main-entry point for client API.
// It is responsible for managing and establishing connections
// between your application and RavenDB server/cluster
// and is capable of working with multiple databases at once.
// Due to it's nature, it is recommended to have only one
// singleton instance per application

/**
 * Classe représentant le point d'entrée avec la base de données
 */
public class DocumentStoreHolder {

    /**
     * Classe représentant le conteneur lié à la base de données
     */
    private static class DocumentStoreContainer {

        /**
         * Gestion de l'accès à la base de données
         */
        public static final IDocumentStore store = new DocumentStore("http://localhost:8888", "jee");

        static {
            store.initialize();
        }
    }

    /**
     * Méthode de classe récupérant l'instance de l'accès à la base de données
     * @return Le <i>DocumentStore</i> de la base de données
     */
    public static IDocumentStore getStore() {
        return DocumentStoreContainer.store;
    }
}
