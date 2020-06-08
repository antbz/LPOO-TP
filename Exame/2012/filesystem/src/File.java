public class File extends Node {
    private int size;

    public File(Folder parent, String name) throws DuplicateNameException {
        super(parent, name);
    }

    public File(Folder parent, String name, int size) throws DuplicateNameException {
        super(parent, name);
        this.size = size;
    }

    public File clone(Folder new_parent, String new_name) throws DuplicateNameException {
        return new File(new_parent, new_name, size);
    }

    @Override
    public int getSize() {
        return size;
    }
}
