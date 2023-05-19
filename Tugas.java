// library yang dipakai
import java.util.ArrayList;
import java.util.List;

// Interface yang dibuat
interface Document {
    void create();
    void delete();
    void rename(String newName);
}

// Abstract class yang dibuat
abstract class File {
    protected String name;

    public File(String name) {
        this.name = name;
    }

    public abstract void open();
    public abstract void close();
}

// Inner class yang dibuat
class DocumentManagement {
    private List<Document> documents = new ArrayList<>();

    public void addDocument(Document document) {
        documents.add(document);
        System.out.println("" + document + " berhasil ditambahkan.");
    }

    public void removeDocument(Document document) {
        documents.remove(document);
        System.out.println("" + document + " berhasil dihapus.");
    }

    public void listDocuments() {
        System.out.println("List : ");
        for (Document document : documents) {
            System.out.println(document);
        }
    }

    class MyDocument implements Document {
        private String name;

        public MyDocument(String name) {
            this.name = name;
        }

        @Override
        public void create() {
            System.out.println(" " + name + " telah dibuat.");
        }

        @Override
        public void delete() {
            System.out.println(" " + name + " telah dihapus.");
        }

        @Override
        public void rename(String newName) {
            System.out.println("" + name + " telah diganti nama menjadi " + newName + ".");
            name = newName;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}

public class Tugas {
    public static void main(String[] args) {
        DocumentManagement documentManagement = new DocumentManagement();

        // membuat dokumen
        DocumentManagement.MyDocument document1 = documentManagement.new MyDocument("Dokumen barbie");
        DocumentManagement.MyDocument document2 = documentManagement.new MyDocument("Dokumen Muthia");
        DocumentManagement.MyDocument document3 = documentManagement.new MyDocument("Dokumen tugas");

        // menambahkan dokumen
        documentManagement.addDocument(document1);
        documentManagement.addDocument(document2);
        documentManagement.addDocument(document3);

        // List dokumen
        documentManagement.listDocuments();

        // menghapus dokumen
        documentManagement.removeDocument(document2);

        // mengganti nama dokumen
        document3.rename("Dokumen PBO");

        // List dokument terbaru
        documentManagement.listDocuments();
    }
}
