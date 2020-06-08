import java.util.HashSet;
import java.util.Set;

public class Folder extends Node {
    private Set<Node> child = new HashSet<>();

    public Folder(Folder parent, String name) throws DuplicateNameException {
        super(parent, name);
    }

    public Object[] getChild() {
        return child.toArray();
    }

    public Node getChildByName(String name) {
        for (Node n : child) {
            if (n.getName().equals(name)) return n;
        }
        return null;
    }

    public boolean addChild(Node node) {
        return child.add(node);
    }

    public boolean removeChild(Node node) {
        return child.remove(node);
    }

    public void setChild(Set<Node> child) {
        this.child = child;
    }

    private void updateChild() {
        for (Node n : child) {
            n.setParent(this);
        }
    }

    public Folder clone(Folder new_parent, String new_name) throws DuplicateNameException {
        Folder newFolder = new Folder(new_parent, new_name);
        newFolder.setFileSystem(this.getFileSystem());
        for (Node n : child) {
            newFolder.addChild(n.clone(newFolder, n.getName()));
        }
        return newFolder;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Node n : child) {
            size += n.getSize();
        }
        return size;
    }
}
