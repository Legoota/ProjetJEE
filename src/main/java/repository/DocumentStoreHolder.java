package repository;

import net.ravendb.client.documents.DocumentStore;
import net.ravendb.client.documents.IDocumentStore;

// 'DocumentStore' is a main-entry point for client API.
// It is responsible for managing and establishing connections
// between your application and RavenDB server/cluster
// and is capable of working with multiple databases at once.
// Due to it's nature, it is recommended to have only one
// singleton instance per application
public class DocumentStoreHolder {

    private static class DocumentStoreContainer {
        public static final IDocumentStore store =
                new DocumentStore("http://localhost:8888", "jee");

        static {
            store.initialize();
        }
    }

    public static IDocumentStore getStore() {
        return DocumentStoreContainer.store;
    }
}
