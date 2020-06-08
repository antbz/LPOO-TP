public class FileSystem {
    private String type;
    private Folder root;
    private NameFormatter nameFormatter = new UnixFormatter();

    public FileSystem(String type) throws DuplicateNameException {
        root = new Folder(null, "");
        root.setFileSystem(this);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Folder getRoot() {
        return root;
    }

    public void setNameFormatter(NameFormatter nameFormatter) {
        this.nameFormatter = nameFormatter;
    }

    public NameFormatter getNameFormatter() {
        return nameFormatter;
    }
}
