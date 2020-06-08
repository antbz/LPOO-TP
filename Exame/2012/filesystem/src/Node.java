import java.util.Objects;

public abstract class Node {
    private static int next_number = 0;
    private FileSystem fileSystem;
    private Folder parent;
    private String name;
    private int number;

    public Node(Folder parent, String name) throws DuplicateNameException {
        this.parent = parent;
        this.name = name;
        if (parent != null) {
            if (!parent.addChild(this))
                throw new DuplicateNameException();
            this.fileSystem = parent.getFileSystem();
        }
        this.number = ++next_number;
    }

    public Folder getParent() {
        return parent;
    }

    protected void setParent(Folder parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public static void resetNumbering(int i) {
        next_number = i;
    }

    public FileSystem getFileSystem() {
        return fileSystem;
    }

    public void setFileSystem(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    public void move(Folder new_parent, String new_name) throws CycleException {
        Folder testParent = new_parent.getParent();
        while (testParent != null) {
            if (testParent.equals(this))
                throw new CycleException();
            testParent = testParent.getParent();
        }
        parent.removeChild(this);
        parent = new_parent;
        new_parent.addChild(this);
        name = new_name;
    }

    public abstract int getSize();

    public abstract Node clone(Folder new_parent, String new_name) throws DuplicateNameException;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Node)) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent, name);
    }


    public String getPath() {
        if (parent != null)
            return parent.getPath() + fileSystem.getNameFormatter().getSeparator() + name;
        return "";
    }
}
